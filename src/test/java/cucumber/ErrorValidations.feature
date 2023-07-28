@tag
Feature: Error Validations
  
  Background:
  Given Landing on Ecommerce page

  @ErrorValidation
  Scenario Outline: Validating errors of Submitting the Order
  
    Given Logged in with username <username> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | username      |   password  |
      |AvosD@gmail.com|   Avos@123  |
 
