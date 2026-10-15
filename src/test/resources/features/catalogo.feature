Feature: Product catalog
  As a shopper
  I want to find products and add them to the cart
  So that I can begin a purchase

  @Issue-7
  @Catalogo-BusquedaSinCoincidencias
  Scenario Outline: Search for text with no matching products
    Given the shopper opens the catalog
    When the shopper searches for "<texto>"
    Then the catalog shows no matching products

    Examples:
      | texto                          |
      | producto-sin-coincidencia      |
      | zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz |
      | __sin_coincidencias_987654321__ |

  @Issue-8
  @Catalogo-FiltrarPorCategoria
  Scenario: Filter the catalog by category
    Given the shopper opens the catalog
    When the shopper filters by category "Pociones"
    Then the catalog shows matching products

  @Issue-9
  @Catalogo-AgregarPrimerProducto
  Scenario: Add the first available product
    Given the shopper opens the catalog
    When the shopper adds the first available product
    Then the catalog confirms that the product was added
