#Author: Gyanaranjan Mahapatra
#feature : This feature file contain the logging to app and adding item to cart scenarios.

Feature: This feature file contains the logging in to app and adding item to cart scenarios.

  @Regression @Login @AddToCart @LogOut
  Scenario Outline: TC001 login to app and add an item to cart
    Given User logs into the application
    When User searches for a random "<item>"
    And User adds the first item displayed in the list
    Then Verify the item is displayed with the first item in the cart

    Examples: 
      | item  | 
      | T-Shirts |
      
      
@Regression @Login @AddRandomToCart @LogOut
  Scenario Outline: TC002 Add random item to the cart
    Given User logs into the application in "<Mode>" mode
    When User searches for a random "<item>"
    And User adds a random item displayed in the list
    Then Verify the item is displayed with the added item in the cart with all details
    
     Examples: 
     | Mode | item  | 
     | Portrait | TV |
     
@Regression @Login @CheckAddRandomToCart @LogOut
  Scenario Outline: TC003 Verify Details added to the cart matches with that in the list
    Given User logs into the application in "<Mode>" mode
    When User searches for a random "<item>"
    And User adds a random item displayed in the list
    Then Verify the item is displayed with the added item in the cart are same as the details from the list
    
     Examples: 
     | Mode | item  | 
     | Landscape | TV |
    
    @Regression @Login @CheckOut @LogOut
  Scenario Outline: TC004 Checkout item added
    Given User logs into the application
    When User searches for a random "<item>"
    And User adds the first item displayed in the list
    Then Verify the item is displayed with the first item in the cart
    And Check Out the item

    Examples: 
      | item  | 
      | Mobile |
