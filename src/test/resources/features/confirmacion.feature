@compra
Feature: Order confirmation
  As a shopper
  I want to review my order confirmation
  So that I can verify the purchase

  @Issue-13
  @Confirmacion-OrdenSinReciente
  Scenario: Open confirmation without a recent order
    Given the shopper opens order confirmation
    Then the page reports that there is no recent order

  @Issue-14
  @Confirmacion-ContinuarComprando
  Scenario: Continue shopping from an order confirmation
    Given the shopper completes a purchase
    When the shopper chooses to continue shopping
    Then the shopper returns to the catalog
