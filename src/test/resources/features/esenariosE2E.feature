@Login
Feature: E2E-001- Flujo completo de compra en SauceDemo
  @Login001-004E2E
  Scenario: Login exitoso con credenciales válidas
    Given que el usuario está en la página de login
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    And hace clic en el botón de login
    Then debería ver la página principal de productos
    #agregar productos al carrito de compras
    When Seleccionar el producto "Sauce Labs Backpack" y hacer clic en su botón "Add to cart"
    #El botón cambia a "Remove" y el carrito en la esquina superior derecha muestra un "1".
    And Dar clic en el ícono del carrito de compras el sistema muestra la pantalla "Your Cart" con la mochila en la lista
    And Dar clic en el botón "Checkout"
    #llenar datos de cliente
    Then Ingresar en el campo First Name "Juan" e Ingresar en el campo Last Name "Perez"
    And Ingresar "56373" en el campo Zip Postal
    And Dar clic en el botón2 "Continue"
    Then Se muestra la pantalla Checkout Overview con el resumen y total a pagar y Hacer clic en el botón "Finish"
    Then Validacion de  mensaje exacto "Thank you for your orden"
