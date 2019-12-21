@tag
Feature: Use the website to find restaurants So that I can order food
As a hungry customer I want to be able to find restaurants in my area

  @tag1
  Scenario: Navigate to Just Eat Website
    Given launch Justeat url
    When  Verify the home Page
    
  Scenario: Search for restaurants in an area
    Given I want food in "AR511AA"
    When I search for restaurants
    Then I should see some restaurants in "AR511AA"
    
   Scenario: I want to order a pizza
    Given Filter the Pizzas on top 
    When Click on any top listed Restaurant
    Then Add Pizza Deal to inbox
    
    Scenario: Select additional and checkout NOT COVERED IN TEST SCRIPT 
    Then Select Pizza Deal 
    Then Select Skip Extras
    Then Select option
    Then Select some snacks
    Then Add to Basket
    Then Click on Checkout
    Then Close the driver 