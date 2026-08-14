@Login
Feature: Inicio de sesión en SauceDemo

  @Login001
  Scenario: Login exitoso con credenciales válidas
    Given que el usuario está en la página de login
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    And hace clic en el botón de login
    Then debería ver la página principal de productos

  @Login002
  Scenario: Login fallido con credenciales invalidas
    Given que el usuario está en la página de login
    When ingresa el usuario "Francisco" y la contraseña "secret_sauce"
    And hace clic en el botón de login
    Then debera mostrar mensaje ""

  @Login003
  Scenario: Login con extraccion de valores en pantalla
    Given que el usuario está en la página de login
    When se extrae el usuario y contraseña
    #And hace clic en el botón de login
    #Then debería ver la página principal de productos

  @Login004
  Scenario: Login con extraccion y asignacion de valores
    Given que el usuario está en la página de login
    When se extraen y agregan usuario y contraseña
    And hace clic en el botón de login
    Then debería ver la página principal de productos