@contact-us @regression

Feature: WebDriver University - Contact Us Page

  Background:
    Given I access the webdriver university contact us page

  Scenario: Validate Successful Submission - Unique Data
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on the submit button
    Then I am presented with a successful contact us submission message

  Scenario: Validate Successful Submission - Specific Data
    When I enter a specific first name: Michael
    And I enter a specific last name: Jordan
    And I enter a specific email address: michaeljordan@gmail.com
    And I enter a specific comment: "Hello it's me Michael Jordan!!"
    And I click on the submit button
    Then I am presented with a successful contact us submission message