@wip
Feature: As a teacher I want to see all my students in 3rd period Algebra II class and view ISAT Math 2011 assessment scores

This is the data I am assuming for these tests
SectionName:  Algebra II
ClassPeriod = 3
Teacher = Ms. Jones
Assume that Teacher, Student, Section, Assessment entity and associations are available

Background: Nothing yet

Scenario: As a teacher I want to see all my students in 3rd period Algebra II class and view ISAT Math 2011 assessment scores
Given format "application/json"
When I navigate to GET /teachers/<'Ms. Jones' ID>
Then I should receive of 3 links
	And I should see a link named "getTeacherSectionAssociations" with URI  /teacher-section-associations/<'Ms. Jones' ID>
	And I should see  a link named "getSections" with URI  /teacher-section-associations/<'Ms. Jones' ID>/targets
	And I should see a link named "self" with URI /teachers/<'Ms Jones' ID>

When I navigate to "getSections"
Then I should receive a collection of 3 section links that resolve to
	And I should find section with sectionName = "French" and classPeriod "5" and with <'ImportantSection' ID>
	And I should find section with sectionName = "Algebra II" and classPeriod "3"
	And I should find section with sectionName = "Algebra II" and classPeriod "1"

When I navigate to "getSections" and filter by "sectionName="Algebra II" and sectionPeriod = "3""
Then I should receive 1 section
	And I should receive a link named "getStudents" URI /student-section-associations/<'ImportantSection' ID>/targets

When I navigate to "getStudents"
Then I should receive a collection of 5 student links that resolve to
	And I should find Student with <'John Doe' ID>
	And I should find Student with <'Sean Deer' ID>
	And I should find Student with <'Suzy Queue' ID>
	And I should find Student with <'Mary Line' ID>
 	And I should find Student with <'Dong Steve' ID>

When I navigate to GET /students/<'Suzy Queue' ID>
Then I should find a link named "getStudentAssessmentAssociations" with URI "/student-assessment-associations/<'Suzy Queue' ID>
	And I should find a link named "getAssessments" with URI "/student-assessment-associations/<'Suzy Queue' ID>/targets

When I navigate to "getAssessments"
	And filter by "assessmentTitle = "ISAT MATH"
	And "administrationDate" is between "2011/1/1" and "2011/12/30"
Then I should find a student-assessment-association.ScoreResult is 89
	And I should find a student-assessment-association.PerformanceLevel = 3
