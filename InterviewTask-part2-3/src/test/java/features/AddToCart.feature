Feature: user can add items to the cart

  Scenario: user can add items to the cart
    Given user go to eshop home page
    When  user login to his account
    And  user add first item from homepage to the cart
    And  navigate to the home page
    And  user add second item from homepage to the cart
    And  navigate to the home page
    And user search for a Third item
    And add it to the cart
    And go to his cart
    Then user will find all three items he added in his cart