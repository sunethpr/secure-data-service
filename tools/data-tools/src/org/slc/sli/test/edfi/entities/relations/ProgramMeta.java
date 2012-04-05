package org.slc.sli.test.edfi.entities.relations;

import java.util.Set;
import java.util.HashSet;

public class ProgramMeta {

    public Set<String> staffIds;
    public Set<String> studentIds;

    public String schoolId; // this is used in generating studentProgram associations
    
    public final String id;

    public ProgramMeta(String id, SchoolMeta schoolMeta) {
        this.id = schoolMeta.id + "-" + id;

        staffIds = new HashSet<String>();
        studentIds = new HashSet<String>();
        
        schoolId = schoolMeta.id;
    }

    @Override
    public String toString() {
        return "ProgramMeta [id=" + id + ", staffIds=" + staffIds + ",studentIds=" + studentIds + "]";
    }

}
