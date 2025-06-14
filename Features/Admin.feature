Feature: ADMIN – Add employee

Background:
  Given I launchess the application
  And I logged with username "Admin" and password "admin123"
  And I navigate to ADMIN page

Scenario: Add a new user
  When click on the add button
  And click on the user role dropdown
  And select the Admin user option
  And Enter the employee name in the field "charles"
  And click on the status dropdown
  And Enter the username
  And Enter the password
  And Enter the confirm password
  And click on the save button
