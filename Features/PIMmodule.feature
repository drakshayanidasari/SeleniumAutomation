Feature: PIM – Add employee

Background:
  Given I launched the application
  And I logged in with username "Admin" and password "admin123"
  And I navigate to the PIM page

Scenario: Add a single employee
  When I start adding a new employee
And I upload the employee image 
  And I enter employee details:
    | firstName | middleName | lastName | id   |
    | Jitendra  | Prasad     | Busam    | 0470 |
  And I save the employee
  Then the personal details page should open
