Feature: Web Login
Scenario: User able to login
Given User is on login page
When User enter valid username "<username>" and password "<password>"
And click submit button
Then User is able to successfully login

Examples:
    | username | password |
    | iamtestpassautomation@gmail.com    | Lacerte03    |