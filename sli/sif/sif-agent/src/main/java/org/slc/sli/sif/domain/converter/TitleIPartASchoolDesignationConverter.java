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
package org.slc.sli.sif.domain.converter;

import openadk.library.student.Title1Status;

import org.springframework.stereotype.Component;

import org.slc.sli.sif.domain.slientity.TitleIPartASchoolDesignation;

/**
 * Coverter for TitleIPartASchoolDesignation
 */
@Component
public class TitleIPartASchoolDesignationConverter {

    public TitleIPartASchoolDesignation convert(Title1Status status) {

        if (Title1Status.NA.valueEquals(status.getValue())) {
            return TitleIPartASchoolDesignation.NOT_DESIGNATED;
        } else if (Title1Status.SCHOOLWIDE.valueEquals(status.getValue())) {
            return TitleIPartASchoolDesignation.PART_A_SCHOOLWIDE;
        } else if (Title1Status.TARGETED.valueEquals(status.getValue())) {
            return TitleIPartASchoolDesignation.PART_A_TARGETED;
        }

        return null;
    }
}
