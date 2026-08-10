package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    //locatores
    private By inputUserName = By.id("user-name");
    private By inputUserPassword = By.xpath("//div//input[@id='password']");
    private By btnLogin = By.id("login-button");
    private By logoInicio = By.className("app_logo");
    private By h3MensajeError = By.xpath("//div//h3");

    //Constructor
    public LoginPage (WebDriver driver){
        this.driver = driver;
    }
    // Aciones de la pagina

    public void ingresarUrl(){

        try{
            driver.get("https://www.saucedemo.com/");
            //Thread.sleep(5000);
            // Pausa la ejecución de Java por 5 segundos exactos, ciegamente.
            // Si el botón carga en 1 segundo, desperdiciaste 4 segundos.
            // Si tarda 6 segundos, tu prueba fallará de todos modos.
        } catch(Exception e){
            System.out.printf("Error al ingresar a la URL" + e);
        }
    }
    public void ingresarUsuarioContraseña(String usuario, String password){

        try {
            driver.findElement(inputUserName).sendKeys(usuario);
            driver.findElement(inputUserPassword).sendKeys(password);
            //Espera implicita

        }catch (Exception e){
            System.out.printf("Error al ingresar" + usuario + password + e );
        }
    }
    public void darClicBotonLogin (){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
            driver.findElement(btnLogin).click();
            //Espera explicita: Le dice a Selenium que espere hasta que se cumpla una condición específica en un elemento particular, con un tiempo límite.
            // Si la condición se cumple rápido, el código continúa inmediatamente, ahorrando tiempo.

        }catch (Exception e){
            System.out.printf("Error al dar click" + e );
        }
    }

    public void validarLogoInicio (){
        Boolean logoDeInicioVisible = driver.findElement(logoInicio).isDisplayed();

        if (logoDeInicioVisible){
            System.out.printf("El elemento esta visible");
        } else {
            System.out.printf("No esta visible");
        }

    }
    public void ValidarMensajeError (){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(h3MensajeError));
            driver.findElement(h3MensajeError).isDisplayed();
        }catch (Exception e){
            System.out.printf("Error de usuario o contraseña" + e );
        }

    }

}
