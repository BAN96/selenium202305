Feature: Dashboard functionality

Background:
Given user has already logged in to application
|username|password|
|Admin|admin123|

Scenario: verify the page title

Given user on dashboard page
When user get the page title
Then page title should be "Dashboard"

Scenario: PIM page functionality

Given user on dashboard page
When user clicks on PIM in side menu
Then user on PIM Page 
