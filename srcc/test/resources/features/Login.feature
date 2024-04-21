Feature: Login Funcationality

Scenario Outline: Login with Valid Credentials
Given User has navigates to Login Page
When User enters valid email address <username> into email field
And User has entered valid password <password> into password field
And User clicks on Login button
Then User should get successfully logged in
Examples:
|username                  |password   |
|ngovindselenium@gmail.com |allrounder |
|nnagaselenium@gmail.com   |allrounder |

Scenario: Login with Invalid Credentials
Given User has navigates to Login Page
When User enters invalid email address into email field
And User has entered invalid password "allrounder11" into password field
And User clicks on Login button
Then User should get a proper warning message about credentails mismatch

Scenario: Login with valid email and invalid password
Given User has navigates to Login Page
When User enters invalid email address into email field
And User has entered invalid password "allrounder11" into password field
And User clicks on Login button
Then User should get a proper warning message about credentails mismatch

Scenario: Login with invalid email and valid password
Given User has navigates to Login Page
When User enters invalid email address into email field
And User has entered invalid password "allrounder" into password field
And User clicks on Login button
Then User should get a proper warning message about credentails mismatch

Scenario: Login without providing any credentials
Given User has navigates to Login Page
When User dont enter email address into email field
And User dont entere password into password field
And User clicks on Login button
Then User should get a proper warning message about credentails mismatch




