Feature: ADMIN – Add employee

Background:
  Given I launchess the application
  And I logged with username "Admin" and password "admin123"
  And I navigate to ADMIN page

Scenario: Add a new user
  When click on the add button
  And click on the user role dropdown
  And select the Admin user option
  And Enter the employee name in the field "Linda Jane"
  And click on the status dropdown
  And Enter the username as "lindajane77"
  And Enter the password as "Admin@123"
  And Enter the confirm password as "Admin@123"
  And click on the save button
