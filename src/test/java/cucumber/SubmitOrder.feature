@tag
Feature: Purchase the Order from Ecommerce site
  
  Background:
  Given Landing on Ecommerce page

  @Regression
  Scenario Outline: Positive test of Submitting the Order
  
    Given Logged in with username <username> and password <password>
    When Adding Product <productName> to the cart
    And Checkout product <productName> and Submit the Order
    Then "THANKYOU FOR THE ORDER." message is displayed on the ConfirmationPage

    Examples: 
      | username      |   password  | productName      |
      |AvosD@gmail.com|   Avos@1234 | ZARA COAT 3      |
 
