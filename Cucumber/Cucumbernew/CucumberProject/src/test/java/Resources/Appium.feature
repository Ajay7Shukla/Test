Feature: Appium use case
Scenario: Validate custom test
Given User open application
When User search in application  searchQuery "<searchQuery>"
Then User validate Title

Examples:
    | searchQuery | 
    |    Virtusa | 