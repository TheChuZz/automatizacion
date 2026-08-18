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
import java.util.HashMap;
import java.util.Map;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginpage;

    @Before // Se ejecutara antes de abrir el navegador //
    public void setUP (){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");//declarar argumentos con que se ejecutara el navegador
        option.addArguments("--diseable-notifications");
        option.addArguments("--incognito");
        option.addArguments("--disable-features=PasswordManager");
        option.addArguments("--disable-notifications");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        option.setExperimentalOption("prefs", prefs);

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
    @When("se extrae el usuario y contraseña")
    public void se_extrae_el_usuario_y_contraseña(){
       loginpage.validarExtraccionCredenciales();
    }
    @When("se extraen y agregan usuario y contraseña")
    public void se_extraen_y_agregan_usuario_y_contraseña (){
        loginpage.ValidarAsignacionCredencialesAutomatico();
    }
    @When("Seleccionar el producto {string} y hacer clic en su botón {string}")
    public void Seleccionar_el_producto_y_hacer_clic_en_su_botón_Add_to_cart(String sauceLabsBackpack, String addToCart){
        loginpage.validarAgregarProductoCarrito();
    }
    @And ("Dar clic en el ícono del carrito de compras el sistema muestra la pantalla {string} con la mochila en la lista")
    public void Dar_clic_en_el_ícono_del_carrito_de_compras_el_sistema_muestra_la_pantalla_con_la_mochila_en_la_lista(String yourCart){
        loginpage.validarPoductoLista();
    }
    @And("Dar clic en el botón {string}")
    public void Dar_clic_en_el_botón (String Checkout){
        loginpage.validarCheckout();
    }
    @Then("Ingresar en el campo First Name {string} e Ingresar en el campo Last Name {string}")
    public void Ingresar_en_el_campo_First_Name_e_Ingresar_en_el_campo_Last_Name(String nombre, String apellido){
        loginpage.ingresarNombreyApellido(nombre, apellido);
    }
    @And("Ingresar {string} en el campo Zip Postal")
    public void Ingresar_en_el_campo_Zip_Postal(String codigo){
        loginpage.ingresarCodigoPostal(codigo);
    }
    @And("Dar clic en el botón2 {string}")
    public void Dar_clic_en_el_botón2 (String Continue){
      loginpage.validarContinuar();
    }
    @Then("Se muestra la pantalla Checkout Overview con el resumen y total a pagar y Hacer clic en el botón {string}")
    public void Se_muestra_la_pantalla_Checkout_Overview_con_el_resumen_y_total_a_pagar_y_Hacer_clic_en_el_botón (String Finish){
        loginpage.validarfinalizarOrden();
    }
    @Then("Validacion de  mensaje exacto {string}")
    public void Validacion_de_mensaje_exacto(String mensaje){
        loginpage.validarMensajeExcato(mensaje);
    }

}
