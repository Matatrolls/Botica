@compra
Feature: Product catalog
  As a shopper
  I want to find products and add them to the cart
  So that I can begin a purchase

  Scenario Outline: Search for text with no matching products
    Given the shopper opens the catalog
    When the shopper searches for "<texto>"
    Then the catalog shows no matching products

    Examples:
      | texto                          |
      | producto-sin-coincidencia      |
      | zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz |
      | __sin_coincidencias_987654321__ |

  Scenario: Filter the catalog by category
    Given the shopper opens the catalog
    When the shopper filters by category "Pociones"
    Then the catalog shows matching products

  Scenario: Add the first available product
    Given the shopper opens the catalog
    When the shopper adds the first available product
    Then the catalog confirms that the product was added
