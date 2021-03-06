@RALLY_US0615
@RALLY_US927

Feature: Daily Attendance Ingestion Test

Background: I have a landing zone route configured
Given I am using local data store
  And I am using preconfigured Ingestion Landing Zone

Scenario: Post a zip file containing all configured interchanges as a payload of the ingestion job: Clean Database
Given I post "DailyAttendance.zip" file as the payload of the ingestion job
  And the following collections are empty in datastore:
     | collectionName              |
     | recordHash                  |
     | student                     |
     | studentSchoolAssociation    |
     | educationOrganization       |
     | school                      |
     | session                     |
     | attendance                  |
When zip file is scp to ingestion landing zone
  And a batch job for file "DailyAttendance.zip" is completed in database
Then I should see following map of entry counts in the corresponding collections:
     | collectionName              | count |
     | student                     | 94    |
     | studentSchoolAssociation    | 123   |
     | educationOrganization       | 8     |
     | school                      | 0     |
     | session                     | 8     |
     | attendance                  | 72    |
   And I check to find if record is in collection:
     | collectionName              | expectedRecordCount | searchParameter           | searchValue   |
    | attendance                  | 72                  | body.schoolYear            | 2011-2012     |
    | attendance                  | 10                  | body.attendanceEvent.event | Tardy         |
    | attendance                  | 69                  | body.attendanceEvent.event | In Attendance |
     | attendance                  | 0                   | body.attendanceEvent.date  | 2011-09-01    |
     | attendance                  | 72                  | body.attendanceEvent.date  | 2011-11-10    |
     | studentSchoolAssociation     | 7                   | body.classOf                                     | 2011-2012    |

  And I should see "Processed 387 records." in the resulting batch job file
  And I should not see an error log file created
  And I should not see a warning log file created
  And I should see "InterchangeStudent.xml records considered for processing: 94" in the resulting batch job file
  And I should see "InterchangeStudent.xml records ingested successfully: 94" in the resulting batch job file
  And I should see "InterchangeStudent.xml records failed processing: 0" in the resulting batch job file
  And I should see "StudentAttendanceEvents.xml records considered for processing: 144" in the resulting batch job file
  And I should see "StudentAttendanceEvents.xml records ingested successfully: 144" in the resulting batch job file
  And I should see "StudentAttendanceEvents.xml records failed processing: 0" in the resulting batch job file

Scenario: Post a zip file containing attendance event interchange with non-existent student as a payload of the ingestion job: Populated Database
Given I post "DailyAttendanceNoStudent.zip" file as the payload of the ingestion job
When zip file is scp to ingestion landing zone
  And a batch job for file "DailyAttendanceNoStudent.zip" is completed in database
  And I should see "Processed 1 records." in the resulting batch job file
  And I should see "StudentAttendanceNoStudent.xml records considered for processing: 0" in the resulting batch job file
  And I should see "StudentAttendanceNoStudent.xml records ingested successfully: 0" in the resulting batch job file
  And I should see "StudentAttendanceNoStudent.xml records not considered for processing: 1" in the resulting batch job file

Scenario: Post a zip file where an attendanceEvent occurs in a school's parent LEA session: Clean Database
Given I post "DailyAttendanceInheritedSession.zip" file as the payload of the ingestion job
  And the following collections are empty in datastore:
     | collectionName              |
     | recordHash                  |
     | student                     |
     | educationOrganization       |
     | session                     |
     | attendance                  |
	| recordHash                  |
When zip file is scp to ingestion landing zone
  And a batch job for file "DailyAttendanceInheritedSession.zip" is completed in database
Then I should see following map of entry counts in the corresponding collections:
     | collectionName              | count |
     | student                     | 1     |
     | educationOrganization       | 3     |
     | session                     | 1     |
     | attendance                  | 1     |
 And I check to find if record is in collection:
     | collectionName              | expectedRecordCount | searchParameter                                | searchValue     |
     | attendance                  | 1                   | body.attendanceEvent.date | 2011-09-06      |
  And I should see "Processed 8 records." in the resulting batch job file
  And I should not see an error log file created
  And I should not see a warning log file created
  And I should see "InterchangeStudent.xml records considered for processing: 1" in the resulting batch job file
  And I should see "InterchangeStudent.xml records ingested successfully: 1" in the resulting batch job file
  And I should see "InterchangeStudent.xml records failed processing: 0" in the resulting batch job file
  And I should see "InterchangeAttendance.xml records considered for processing: 1" in the resulting batch job file
  And I should see "InterchangeAttendance.xml records ingested successfully: 1" in the resulting batch job file
  And I should see "InterchangeAttendance.xml records failed processing: 0" in the resulting batch job file

  Scenario: Ingest a zip file and ensure the attendance entity contains the expected format.
    Given I post "DailyAttendance.zip" file as the payload of the ingestion job
    And the following collections are empty in datastore:
      | attendance                  |
    When zip file is scp to ingestion landing zone
    And a batch job for file "DailyAttendance.zip" is completed in database
    And I should not see a warning log file created
    Then all attendance entities should should have the expected structure
