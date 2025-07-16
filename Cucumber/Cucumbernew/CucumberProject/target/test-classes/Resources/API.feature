Feature: API Validation of get method
 
  @GetUserDetails
  Scenario Outline: Send a valid Request and check status
 
    Given I send a request to the url <url> 
    Then the response will return status <statusCode> 
    Then the response contains title <title>
 
    Examples:
    | statusCode | url  | title |
    | 200        | 'https://www.google.com' | 'Google' |
