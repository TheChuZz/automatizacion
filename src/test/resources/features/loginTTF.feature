Feature: Inicio de Sesion Fallida SauceDemo

  @Login005
  Scenario Outline: Login fallido con credenciales incorrectas
    Given que el usuario está en la página de login
    When ingresa el usuario "<user>" y la contraseña "<password>"
    And hace clic en el botón de login
    Then debera mostrar mensaje "<msj>"

    Examples:
    |user           |password     |msj                                                                      |
    |standard_user  |             |Epic sadface: Password is required                                       |
    |               |secret_sauce |Epic sadface: Username is required                                       |
    |standard_user  |1234         |Epic sadface: Username and password do not match any user in this service|
    |locked_out_user|secret_sauce |Epic sadface: Sorry, this user has been locked out.                      |



