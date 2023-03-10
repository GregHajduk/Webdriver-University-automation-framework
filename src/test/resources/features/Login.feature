@login @regression

Feature: WebDriver University - Login Page

  Scenario Outline: Successful & Unsuccessful Login check
    When the user accesses the webdriver university login page
    And enters valid username <username>
    And enters valid password <password>
    And clicks on the login button
    Then user should be presented with the successful login popup message "<validationMessage>"
    Examples:
      | username  | password     | validationMessage    |
      | webdriver | webdriver123 | validation succeeded |
      | webdriver | password777  | validation failed    |
      | driver    | webdriver123 | validation failed    |
