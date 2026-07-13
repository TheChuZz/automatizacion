Feature: Inicio de sesión en SauceDemo

  Scenario: Login exitoso con credenciales válidas
    Given que el usuario está en la página de login
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    And hace clic en el botón de login
    Then debería ver la página principal de productos