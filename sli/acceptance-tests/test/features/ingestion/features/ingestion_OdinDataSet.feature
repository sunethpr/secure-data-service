@RALLY_US4816
Feature: Odin Data Set Ingestion Correctness and Fidelity
Background: I have a landing zone route configured
Given I am using odin data store 

Scenario: Post Odin Sample Data Set
Given I am using preconfigured Ingestion Landing Zone for "Midgar-Daybreak"
  And I post "OdinSampleDataSet.zip" file as the payload of the ingestion job
  And the following collections are empty in datastore:
     | collectionName                            |
     | assessment                                |
     | assessmentFamily                          |
     | assessmentPeriodDescriptor                |
     | attendance                                |
     | calendarDate                              |
     | cohort                                    |
     | competencyLevelDescriptor                 |
     | course                                    |
     | courseOffering                            |
     | courseSectionAssociation                  |
     | courseTranscript                          |
     | disciplineAction                          |
     | disciplineIncident                        |
     | educationOrganization                     |
     | educationOrganizationAssociation          |
     | educationOrganizationSchoolAssociation    |
     | grade                                     |
     | gradebookEntry                            |
     | gradingPeriod                             |
     | graduationPlan                            |
     | learningObjective                         |
     | learningStandard                          |
     | parent                                    |
     | program                                   |
     | reportCard                                |
     | school                                    |
     | schoolSessionAssociation                  |
     | section                                   |
     | sectionAssessmentAssociation              |
     | sectionSchoolAssociation                  |
     | session                                   |
     | sessionCourseAssociation                  |
     | staff                                     |
     | staffCohortAssociation                    |
     | staffEducationOrganizationAssociation     |
     | staffProgramAssociation                   |
     | student                                   |
     | studentAcademicRecord                     |
     | studentAssessment                         |
     | studentCohortAssociation                  |
     | studentCompetency                         |
     | studentCompetencyObjective                |
     | studentDisciplineIncidentAssociation      |
     | studentGradebookEntry                     |
     | studentParentAssociation                  |
     | studentProgramAssociation                 |
     | studentSchoolAssociation                  |
     | studentSectionAssociation                 |
     | teacher                                   |
     | teacherSchoolAssociation                  |
     | teacherSectionAssociation                 |
When zip file is scp to ingestion landing zone
  And a batch job for file "OdinSampleDataSet.zip" is completed in database
  Then I should see following map of entry counts in the corresponding collections:
     | collectionName                           |              count|
     | student                                  |                 10|
    And I should not see an error log file created
	And I should not see a warning log file created

Scenario: Verify entities in education organization calendar were ingested correctly: Populated Database
    And I check to find if record is in collection:
     | collectionName              | expectedRecordCount | searchParameter                          | searchValue                                   | searchType           |
     | assessmentFamily            | 13                  | body.assessmentFamilyReference           | 9f6aff89dd832d41f0b5bea003fef8e429227147_id   | string               |
     | assessmentFamily            | 1                   | body.assessmentPeriods                   | b65a29fe0bd39ebf1f1bb77a0491d6ba1e90b2ea_id   | string               |
     | assessmentPeriodDescriptor  | 1                   | _id                                      | b65a29fe0bd39ebf1f1bb77a0491d6ba1e90b2ea_id   | string               |
     | assessment                  | 2                   | body.assessmentPeriodDescriptorId        | b4eb598d47d621d9b8969cbdc033f0edd5683154_id   | string               |
     | assessment                  | 2                   | body.assessmentFamilyReference           | 673e722b6b0511717b633fc5fec0cc069fd5ed96_id   | string               |
     | session                     | 1                   | body.sessionName                         | 2013-2014 Year Round session: IL-DAYBREAK     | string               |
     | session                     | 1                   | body.sessionName                         | 2014-2015 Year Round session: IL-DAYBREAK     | string               |
     | session                     | 1                   | body.sessionName                         | 2015-2016 Year Round session: IL-DAYBREAK     | string               |
     | session                     | 2                   | body.schoolYear                          | 2013-2014                                     | string               |
     | session                     | 2                   | body.schoolYear                          | 2014-2015                                     | string               |
     | session                     | 2                   | body.schoolYear                          | 2015-2016                                     | string               |
     | session                     | 6                   | body.term                                | Year Round                                    | string               |
     | session                     | 6                   | body.totalInstructionalDays              | 180                                           | integer              |
     | gradingPeriod               | 6                   | body.gradingPeriodIdentity.gradingPeriod | End of Year                                   | string               |
     | gradingPeriod               | 2                   | body.gradingPeriodIdentity.schoolYear    | 2013-2014                                     | string               |
     | gradingPeriod               | 2                   | body.gradingPeriodIdentity.schoolYear    | 2014-2015                                     | string               |
     | gradingPeriod               | 2                   | body.gradingPeriodIdentity.schoolYear    | 2015-2016                                     | string               |
     | gradingPeriod               | 3                   | body.gradingPeriodIdentity.schoolId      | 880572db916fa468fbee53a68918227e104c10f5_id   | string               |
     | gradingPeriod               | 3                   | body.gradingPeriodIdentity.schoolId      | 1b223f577827204a1c7e9c851dba06bea6b031fe_id   | string               |
     | gradingPeriod               | 6                   | body.totalInstructionalDays              | 180                                           | integer              |

Scenario: Verify entities in student were ingested correctly: Populated Database
    And I check to find if record is in collection:
     | collectionName              | expectedRecordCount | searchParameter                          | searchValue                                   | searchType           |
     | student                     | 10                  | type                                     | student                                       | string               |
     | student                     | 1                   | body.studentUniqueStateId                | 1                                             | string               |
     | student                     | 1                   | body.studentUniqueStateId                | 2                                             | string               |
     | student                     | 1                   | body.studentUniqueStateId                | 3                                             | string               |
     | student                     | 1                   | body.studentUniqueStateId                | 4                                             | string               |
     | student                     | 1                   | body.studentUniqueStateId                | 5                                             | string               |
     | student                     | 1                   | body.studentUniqueStateId                | 6                                             | string               |
     | student                     | 1                   | body.studentUniqueStateId                | 7                                             | string               |
     | student                     | 1                   | body.studentUniqueStateId                | 8                                             | string               |
     | student                     | 1                   | body.studentUniqueStateId                | 9                                             | string               |
     | student                     | 1                   | body.studentUniqueStateId                | 10                                            | string               |
     | student                     | 10                  | schools.entryDate                        | 2013-08-27                                    | string               |
     | student                     | 3                   | schools.entryGradeLevel                  | Sixth grade                                   | string               |
     | student                     | 1                   | schools.entryGradeLevel                  | Kindergarten                                  | string               |
     | student                     | 3                   | schools.entryGradeLevel                  | Ninth grade                                   | string               |     
     | student                     | 1                   | _id                                      | 9e54047cbfeeee26fed86b0667e98286a2b72791_id   | string               |
     | studentParentAssociation    | 2                   | body.studentId                           | 9e54047cbfeeee26fed86b0667e98286a2b72791_id   | string               |

Scenario: Verify specific staff document for Rebecca Braverman ingested correctly: Populated Database
  When I can find a "staff" with "body.teacherUniqueStateId" "rbraverman" in tenant db "Midgar"
    Then the "staff" entity "type" should be "teacher"

Scenario: Verify specific staff document for Charles Gray ingested correctly: Populated Database
  When I can find a "staff" with "body.teacherUniqueStateId" "cgray" in tenant db "Midgar"
    Then the "staff" entity "type" should be "teacher"

Scenario: Verify specific staff document for Linda Kim ingested correctly: Populated Database
  When I can find a "staff" with "body.teacherUniqueStateId" "linda.kim" in tenant db "Midgar"
    Then the "staff" entity "type" should be "teacher"
    
Scenario: Verify superdoc studentSchoolAssociation references ingested correctly: Populated Database
  When Examining the studentSchoolAssociation collection references
    Then the document references "educationOrganization" "_id" with "body.schoolId"
    And the document references "student" "_id" with "body.studentId"
    And the document references "student" "schools._id" with "body.schoolId"
    And the document references "student" "schools.entryDate" with "body.entryDate"
    And the document references "student" "schools.entryGradeLevel" with "body.entryGradeLevel"

Scenario: Verify staffEducationOrganizationAssociation references ingested correctly: Populated Database
  When Examining the staffEducationOrganizationAssociation collection references
    Then the document references "educationOrganization" "_id" with "body.educationOrganizationReference"
     And the document references "staff" "_id" with "body.staffReference"

Scenario: Verify teacherSchoolAssociation references ingested correctly: Populated Database
  When Examining the teacherSchoolAssociation collection references
    Then the document references "educationOrganization" "_id" with "body.schoolId"
     And the document references "staff" "_id" with "body.teacherId"

Scenario: Verify entities in specific student document ingested correctly: Populated Database
  When I can find a "student" with "_id" "9e54047cbfeeee26fed86b0667e98286a2b72791_id" in tenant db "Midgar"
    Then the "student" entity "body.race" should be "White"
    And the "student" entity "body.limitedEnglishProficiency" should be "NotLimited"
    And the "student" entity "body.schoolFoodServicesEligibility" should be "Reduced price"  
    And the "student" entity "schools.entryGradeLevel" should be "Kindergarten"
    And the "student" entity "schools.entryGradeLevel" should be "First grade" 
    And the "student" entity "schools.entryGradeLevel" should be "Second grade" 

Scenario: Verify entities in student school association were ingested correctly
    And I check to find if record is in collection:
     | collectionName              | expectedRecordCount | searchParameter                             | searchValue                                   | searchType           |
     | graduationPlan              | 1                   | _id                                         | 438cc6756e65d65da2eabb0968387ad25a3e0b93_id   | string               |
     | studentSchoolAssociation    | 5                   | body.graduationPlanId                       | 438cc6756e65d65da2eabb0968387ad25a3e0b93_id   | string               |

Scenario: Verify objective assessment in assessment has valid references
    And I check to find if record is in collection:
     | collectionName              | expectedRecordCount | searchParameter                             | searchValue                                   | searchType           |
     | assessment                  | 4                   | objectiveAssessment.body.learningObjectives | d8e3b4100ed9fb6da738846c845693ffd897165b_id   | string               |
     | learningObjective           | 1                   | _id                                         | d8e3b4100ed9fb6da738846c845693ffd897165b_id   | string               |

Scenario: Verify the sli verification script confirms everything ingested correctly
    Given the edfi manifest that was generated in the 'generated' directory
    And the tenant is 'Midgar'
    Then the sli-verify script completes successfully

Scenario: Verify the course optional fields is ingested correctly
    And I check to find if record is in collection:
     | collectionName              | expectedRecordCount | searchParameter                          | searchValue                                     | searchType           |
     | course                      | 14                  | body.courseLevel                         |Honors                                           | string               |
     | course                      | 2                   | body.courseLevelCharacteristics          |Magnet                                           | string               |
     | course                      | 1                   | body.gradesOffered                       |First grade                                      | string               |
     | course                      | 4                   | body.subjectArea                         |Reading                                          | string               |
     | course                      | 1                   | body.courseDescription                   |this is a course for First grade                 | string               |
     | course                      | 14                  | body.courseGPAApplicability              |Not Applicable                                   | string               |
     | course                      | 6                   | body.courseDefinedBy                     |School                                           | string               |
     | course                      | 14                  | body.careerPathway                       |Science, Technology, Engineering and Mathematics | string               |
     | courseTranscript            | 12                  | body.gradeLevelWhenTaken                 |Seventh grade                                    | string               |
     | courseTranscript            | 26                  | body.finalLetterGradeEarned              |C+                                               | string               |
     | courseTranscript            | 75                  | body.courseRepeatCode                    |RepeatCounted                                    | string               |
     | courseTranscript            | 75                  | body.methodCreditEarned                  |Classroom credit                                 | string               |
     | courseTranscript            | 75                  | body.creditsAttempted.credit             |3                                                | integer              |
     | courseTranscript            | 6                   | body.finalNumericGradeEarned             |80                                               | integer              |
     | cohort                      | 3                   | body.academicSubject                     |Science                                          | string               |
     | cohort                      | 2                   | body.academicSubject                     |ELA                                              | string               |
     | cohort                      | 4                   | body.academicSubject                     |Critical Reading                                 | string               |
     | cohort                      | 3                   | body.programId                           |222b0ac8868da74a2cddfcc2f4e409689e0ccc6c_id      | string               |
     | cohort                      | 3                   | body.programId                           |5e830477e285446dc92b5cc6f4adef8e339f78fc_id      | string               |
     | cohort                      | 3                   | body.programId                           |222b0ac8868da74a2cddfcc2f4e409689e0ccc6c_id      | string               |

Scenario: Verify use of generic Education Organization
    And there exist "1" "educationOrganization" records like below in "Midgar" tenant. And I save this query as "Daybreak Central High"
       | field                               | value                                       |
       | _id                                 | a13489364c2eb015c219172d561c62350f0453f3_id |
       | body.stateOrganizationId            | Daybreak Central High                       |
       | type                                | educationOrganization                       |
    And there are only the following in the "organizationCategories" of the "educationOrganization" collection for id "a13489364c2eb015c219172d561c62350f0453f3_id" on the "Midgar" tenant
       | value                  |
       | School                 |
    And there are only the following in the "body.parentEducationAgencyReference" of the "educationOrganization" collection for id "a13489364c2eb015c219172d561c62350f0453f3_id" on the "Midgar" tenant
       | value                                       |
       | 1b223f577827204a1c7e9c851dba06bea6b031fe_id |
    And there are only the following in the "metaData.edOrgs" of the "educationOrganization" collection for id "a13489364c2eb015c219172d561c62350f0453f3_id" on the "Midgar" tenant
       | value                                       |
       | a13489364c2eb015c219172d561c62350f0453f3_id |
       | 884daa27d806c2d725bc469b273d840493f84b4d_id |
       | 1b223f577827204a1c7e9c851dba06bea6b031fe_id |

    And there exist "1" "educationOrganization" records like below in "Midgar" tenant. And I save this query as "South Daybreak Elementary"
       | field                               | value                                       |
       | _id                                 | 352e8570bd1116d11a72755b987902440045d346_id |
       | body.stateOrganizationId            | South Daybreak Elementary                   |
       | type                                | educationOrganization                       |
    And there are only the following in the "organizationCategories" of the "educationOrganization" collection for id "352e8570bd1116d11a72755b987902440045d346_id" on the "Midgar" tenant
       | value                  |
       | School                 |
    And there are only the following in the "body.parentEducationAgencyReference" of the "educationOrganization" collection for id "352e8570bd1116d11a72755b987902440045d346_id" on the "Midgar" tenant
       | value                                       |
       | 1b223f577827204a1c7e9c851dba06bea6b031fe_id |
    And there are only the following in the "metaData.edOrgs" of the "educationOrganization" collection for id "352e8570bd1116d11a72755b987902440045d346_id" on the "Midgar" tenant
       | value                                       |
       | 352e8570bd1116d11a72755b987902440045d346_id |
       | 884daa27d806c2d725bc469b273d840493f84b4d_id |
       | 1b223f577827204a1c7e9c851dba06bea6b031fe_id |

    And there exist "1" "educationOrganization" records like below in "Midgar" tenant. And I save this query as "East Daybreak Junior High"
       | field                               | value                                       |
       | _id                                 | 772a61c687ee7ecd8e6d9ad3369f7883409f803b_id |
       | body.stateOrganizationId            | East Daybreak Junior High                   |
       | type                                | educationOrganization                       |
    And there are only the following in the "organizationCategories" of the "educationOrganization" collection for id "772a61c687ee7ecd8e6d9ad3369f7883409f803b_id" on the "Midgar" tenant
       | value                  |
       | School                 |
    And there are only the following in the "body.parentEducationAgencyReference" of the "educationOrganization" collection for id "772a61c687ee7ecd8e6d9ad3369f7883409f803b_id" on the "Midgar" tenant
       | value                                       |
       | 1b223f577827204a1c7e9c851dba06bea6b031fe_id |
    And there are only the following in the "metaData.edOrgs" of the "educationOrganization" collection for id "772a61c687ee7ecd8e6d9ad3369f7883409f803b_id" on the "Midgar" tenant
       | value                                       |
       | 772a61c687ee7ecd8e6d9ad3369f7883409f803b_id |
       | 884daa27d806c2d725bc469b273d840493f84b4d_id |
       | 1b223f577827204a1c7e9c851dba06bea6b031fe_id |

    And there exist "1" "educationOrganization" records like below in "Midgar" tenant. And I save this query as "5"
       | field                               | value                                       |
       | _id                                 | 880572db916fa468fbee53a68918227e104c10f5_id |
       | body.stateOrganizationId            | 5                                           |
       | type                                | educationOrganization                       |
    And there are only the following in the "organizationCategories" of the "educationOrganization" collection for id "880572db916fa468fbee53a68918227e104c10f5_id" on the "Midgar" tenant
       | value                  |
       | Local Education Agency |
    And there are only the following in the "body.parentEducationAgencyReference" of the "educationOrganization" collection for id "880572db916fa468fbee53a68918227e104c10f5_id" on the "Midgar" tenant
       | value                                       |
       | 884daa27d806c2d725bc469b273d840493f84b4d_id |

    And there exist "1" "educationOrganization" records like below in "Midgar" tenant. And I save this query as "IL-DAYBREAK"
       | field                               | value                                       |
       | _id                                 | 1b223f577827204a1c7e9c851dba06bea6b031fe_id |
       | body.stateOrganizationId            | IL-DAYBREAK                                 |
       | type                                | educationOrganization                       |
    And there are only the following in the "organizationCategories" of the "educationOrganization" collection for id "1b223f577827204a1c7e9c851dba06bea6b031fe_id" on the "Midgar" tenant
       | value                  |
       | Local Education Agency |
    And there are only the following in the "body.parentEducationAgencyReference" of the "educationOrganization" collection for id "1b223f577827204a1c7e9c851dba06bea6b031fe_id" on the "Midgar" tenant
       | value                                       |
       | 884daa27d806c2d725bc469b273d840493f84b4d_id |

    And there exist "1" "educationOrganization" records like below in "Midgar" tenant. And I save this query as "STANDARD-SEA"
       | field                               | value                                       |
       | _id                                 | 884daa27d806c2d725bc469b273d840493f84b4d_id |
       | body.stateOrganizationId            | STANDARD-SEA                                 |
       | type                                | educationOrganization                       |
    And there are only the following in the "organizationCategories" of the "educationOrganization" collection for id "884daa27d806c2d725bc469b273d840493f84b4d_id" on the "Midgar" tenant
       | value                  |
       | State Education Agency |
