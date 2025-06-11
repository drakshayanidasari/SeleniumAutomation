Feature: OrangeHRM Login Functionality

Background:
  Given I launches the application

Scenario: Successful login and dashboard verification
  When I log in with username "Admin" and password "admin123"
  Then the dashboard visible

Scenario Outline: Login with multiple credentials (data-driven)
  When I log in with username "<username>" and password "<password>"
  Then the dashboard should be visible

  Examples:
    | username | password  |
    | Admin    | admin123  |
    | Admin1   | admin12   |
    | practice | admin1234 |
