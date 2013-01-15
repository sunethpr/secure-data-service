/*
 * Copyright 2012 Shared Learning Collaborative, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.slc.sli.ingestion.routes.orchestra;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.slc.sli.common.util.tenantdb.TenantContext;
import org.slc.sli.ingestion.BatchJobStageType;
import org.slc.sli.ingestion.FileEntryWorkNote;
import org.slc.sli.ingestion.landingzone.IngestionFileEntry;
import org.slc.sli.ingestion.model.Stage;
import org.slc.sli.ingestion.model.da.BatchJobDAO;

/**
 * Splits the zip file, and generate a FileEntryWorkNote for each file
 * @author tke
 *
 */
@Component
public class ZipFileSplitter {
    private static final Logger LOG = LoggerFactory.getLogger(ZipFileSplitter.class);
    public static final String ZIP_FILE_SPLITTER = "Splits the zip file into FileEntryWorkNote per file within the zip file";

    @Autowired
    private BatchJobDAO batchJobDAO;

    public List<FileEntryWorkNote> splitZipFile(Exchange exchange) {

        Stage stage = Stage.createAndStartStage(BatchJobStageType.ZIP_FILE_SPLITTER, ZIP_FILE_SPLITTER);

        String jobId = null;
        List<FileEntryWorkNote> fileEntryWorkNotes = null;

        jobId = exchange.getIn().getHeader("jobId").toString();
        TenantContext.setJobId(jobId);
        LOG.info("splitting zip file for job {}", jobId);

        List<IngestionFileEntry> fileEntries= exchange.getIn().getBody(List.class);
        fileEntryWorkNotes = createWorkNotes(jobId, fileEntries);

        return fileEntryWorkNotes;
    }

    /**
     * @param jobId
     * @param zipFile
     * @return
     */
    private List<FileEntryWorkNote> createWorkNotes (String jobId, List<IngestionFileEntry> fileEntries) {
        List<FileEntryWorkNote> fileEntryWorkNotes = new ArrayList<FileEntryWorkNote>();
        List<String> fileNames = new ArrayList<String>();

        for (IngestionFileEntry fileEntry : fileEntries) {
            fileNames.add(fileEntry.getFileName());
            fileEntryWorkNotes.add(new FileEntryWorkNote(jobId, fileEntry));
        }

        batchJobDAO.createFileLatch(jobId, fileNames);

        return fileEntryWorkNotes;
    }

    /**
     * @return the batchJobDAO
     */
    public BatchJobDAO getBatchJobDAO() {
        return batchJobDAO;
    }

    /**
     * @param batchJobDAO the batchJobDAO to set
     */
    public void setBatchJobDAO(BatchJobDAO batchJobDAO) {
        this.batchJobDAO = batchJobDAO;
    }

}
