Feature: testing the login page

Scenario: login to the valid credentials

Given user opens the url
When user enter the username "Admin"
And user enters the password "admin123"
And user clicks on submit button
Then user on dashboard page

