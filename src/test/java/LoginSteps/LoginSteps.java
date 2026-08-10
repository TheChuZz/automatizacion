package LoginSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

import java.time.Duration;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginpage;

    @Before // Se ejecutara antes de abrir el navegador //
    public void setUP (){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");//declarar argumentos con que se ejecutara el navegador
        driver = new ChromeDriver (option);
        loginpage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Se configura una sola vez al configurar tu driver.
        // Le dice a Selenium: "Si no encuentras un elemento,
        // búscalo repetidamente en el DOM hasta X segundos antes de rendirte".
    }
    @Given ("que el usuario está en la página de login")
    public void que_el_usuario_está_en_la_página_de_login (){
        loginpage.ingresarUrl();
    }
    @When ("ingresa el usuario {string} y la contraseña {string}")
    public void ingresa_el_usuario_y_la_contraseña (String usuario, String contraseña){
        loginpage.ingresarUsuarioContraseña(usuario, contraseña);
    }
    @And("hace clic en el botón de login")
    public void hace_clic_en_el_botón_de_login (){
        loginpage.darClicBotonLogin();
    }
    @Then("debería ver la página principal de productos")
    public void debería_ver_la_página_principal_de_productos(){
        loginpage.validarLogoInicio();
    }
    @Then("debera mostrar mensaje {string}")
    public void debera_mostrar_mensaje (String mensaje){
        loginpage.ValidarMensajeError();
    }
    @After //Ejecuta finalizacion de prueba "Cerrar navegador"
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }

    }

}
