@compra
Feature: Shopping cart
  As a shopper
  I want to manage items and coupons in my cart
  So that I can review my purchase

  Scenario: Show the empty cart
    Given the shopper opens the cart
    Then the cart is empty

  Scenario Outline: Update an item quantity within the allowed range
    Given the cart contains a product
    When the shopper updates the first item quantity to "<cantidad>"
    Then the first item quantity is "<cantidad>"

    Examples:
      | cantidad |
      | 1        |
      | 2        |
      | 5        |

  Scenario: Remove the last item
    Given the cart contains a product
    When the shopper removes the first item
    Then the cart is empty

  Scenario Outline: Reject an invalid coupon
    Given the cart contains a product
    When the shopper applies the invalid coupon "<codigo>"
    Then the coupon is rejected

    Examples:
      | codigo                               |
      | CODIGO-NO-VALIDO                     |
      | X                                     |
      | PROMO-INVALIDA-CON-VALOR-MUY-LARGO-1 |
