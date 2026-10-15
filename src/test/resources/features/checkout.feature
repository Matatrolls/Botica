Feature: Checkout
  As a shopper
  I want to provide delivery details and confirm my order
  So that the purchase can be completed

  @Issue-10
  @Checkout-CamposObligatorios
  Scenario Outline: Require each delivery field
    Given the shopper opens checkout with an item in the cart
    When the shopper submits checkout details "<nombre>", "<correo>", "<direccion>", "<ciudad>", "<telefono>"
    Then the checkout field "<campo>" displays the error "<error>"

    Examples:
      | nombre             | correo                   | direccion            | ciudad          | telefono   | campo     | error                     |
      |                    | comprador@example.test   | Calle de prueba 123  | Ciudad prueba   | 3001234567 | nombre    | Este campo es obligatorio |
      | Comprador de prueba|                          | Calle de prueba 123  | Ciudad prueba   | 3001234567 | correo    | Este campo es obligatorio |
      | Comprador de prueba| comprador@example.test   |                      | Ciudad prueba   | 3001234567 | direccion | Este campo es obligatorio |
      | Comprador de prueba| comprador@example.test   | Calle de prueba 123  |                 | 3001234567 | ciudad    | Este campo es obligatorio |
      | Comprador de prueba| comprador@example.test   | Calle de prueba 123  | Ciudad prueba   |            | telefono  | Este campo es obligatorio |

  @Issue-11
  @Checkout-DatosMalFormados
  Scenario Outline: Reject malformed checkout data
    Given the shopper opens checkout with an item in the cart
    When the shopper submits checkout details "<nombre>", "<correo>", "<direccion>", "<ciudad>", "<telefono>"
    Then the checkout field "<campo>" displays the error "<error>"

    Examples:
      | nombre              | correo             | direccion           | ciudad        | telefono   | campo    | error                           |
      | Comprador de prueba | correo-invalido    | Calle de prueba 123 | Ciudad prueba | 3001234567 | correo   | Ingresa un correo válido        |
      | Comprador de prueba | comprador@test.com | Calle de prueba 123 | Ciudad prueba | 123456789  | telefono | El teléfono debe tener 10 dígitos |
      | Comprador de prueba | comprador@test.com | Calle de prueba 123 | Ciudad prueba | 12345678901| telefono | El teléfono debe tener 10 dígitos |

  @Issue-12
  @Checkout-ConfirmarPedidoValido
  Scenario: Confirm an order with valid delivery information
    Given the shopper opens checkout with an item in the cart
    When the shopper submits valid checkout information
    Then the shopper reaches the order confirmation page
