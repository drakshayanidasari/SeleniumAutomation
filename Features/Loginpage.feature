Feature: Login
Scenario: Successful Login with valid credentials
Given User Launch chrome browser
When User opens URL "https://practice.expandtesting.com/login"
And User enters Email as "practice"
And User enters Password as "SuperSecretPassword!"
And Click on login 
When User clicks on Log out link
And close the browser


Scenario Outline: Login Data Driven
Given User Launch chrome browser
When User opens URL "https://practice.expandtesting.com/login"
And User enters Email as "<username>"
And User enters Password as "<password>"
And Click on login 
When User clicks on Log out link
And close the browser

Examples:
|username|password|
|practice|SuperSecretPassword!|
|practice1|SuperSecretPassword!|
|practice|SuperSecretPassword!1|
