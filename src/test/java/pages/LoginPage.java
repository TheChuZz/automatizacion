package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPage {
    private WebDriver driver;

    //locatores
    private By inputUserName = By.id("user-name");
    private By inputUserPassword = By.xpath("//div//input[@id='password']");
    private By btnLogin = By.id("login-button");
    private By logoInicio = By.className("app_logo");
    private By h3MensajeError = By.xpath("//div//h3");
    private By brUserValido = By.xpath("//div [@id='login_credentials']");
    private By h4UserPassword = By.xpath( "//div [@class='login_password']");
    private By aMochila = By.xpath("//a[@id='item_4_title_link']//div");
    private By btnMochila = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
    private By btnCarrito = By.xpath("//a[@class='shopping_cart_link']");
    private By btnCheckout = By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']");
    private By inputNombre = By.xpath("//input[@placeholder='First Name']");
    private By inputApellido = By.xpath("//input[@placeholder='Last Name']");
    private By inputCodigopostal = By.xpath("//input[@placeholder='Zip/Postal Code']");
    private By btnContinuar = By.xpath("//input[@class='submit-button btn btn_primary cart_button btn_action']");
    private By btnFinalizar = By.xpath("//button[@id='finish']");
    private By mnjFinalexacto = By.xpath("//h2[@class='complete-header']");
    //h2[@class='complete-header']

    //input[@placeholder='First Name']
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
            System.out.printf("Error al ingresar a la URL " + e);
            throw new AssertionError("Error al ingresar a la URL " + e);
        }
    }
    public void ingresarUsuarioContraseña(String usuario, String password){

        try {
            driver.findElement(inputUserName).sendKeys(usuario);
            driver.findElement(inputUserPassword).sendKeys(password);
            //Espera implicita

        }catch (Exception e){
            System.out.printf("Error al ingresar" + usuario + password + e );
            throw new AssertionError("Error al ingresar " + e);
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
            throw new AssertionError("Error al dar click " + e);
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
            throw new AssertionError("Error de usuario o contraseña " + e);
        }

    }
    public void validarExtraccionCredenciales(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(h4UserPassword));
            driver.findElement(h4UserPassword).isDisplayed();
            WebElement element = driver.findElement(h4UserPassword);
            String textoUser = element.getText();
            Pattern pattern = Pattern.compile("Password for all users:\\s*(\\w+)");
            Matcher matcher = pattern.matcher(textoUser);
            String password = "";
            if (matcher.find()){
                password = matcher.group(1);
            }
            System.out.println("ESTE ES LA CONTRASEÑA EXTRAIDA: " + password);

            element = driver.findElement(brUserValido);
            textoUser = element.getText();

            Pattern patternUser = Pattern.compile("(\\w+_user)");

            Matcher matcherUser = patternUser.matcher(textoUser);
            List<String> usuarios = new ArrayList<>();
            while (matcherUser.find()){
                usuarios.add(matcherUser.group(1));
            }
            System.out.println("ESTA ES LA LISTA DE USUARIOS EXTRAIDOS: " + usuarios);

        }catch (Exception e){
            System.out.printf("Error de usuario o contraseña " + e );
            throw new AssertionError("Error de usuario o contraseña " + e);

        }
    }
    public void ValidarAsignacionCredencialesAutomatico(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(h4UserPassword));
            driver.findElement(h4UserPassword).isDisplayed();
            WebElement element = driver.findElement(h4UserPassword);
            String textoUser = element.getText();
            Pattern pattern = Pattern.compile("Password for all users:\\s*(\\w+)");
            Matcher matcher = pattern.matcher(textoUser);
            String password = "";
            if (matcher.find()){
                password = matcher.group(1);
            }
            System.out.println("ESTE ES LA CONTRASEÑA EXTRAIDA: " + password);

            element = driver.findElement(brUserValido);
            textoUser = element.getText();

            Pattern patternUser = Pattern.compile("(\\w+_user)");
            Matcher matcherUser = patternUser.matcher(textoUser);
            List<String> usuarios = new ArrayList<>();
            while (matcherUser.find()){
                usuarios.add(matcherUser.group(1));
            }
            System.out.println("ESTA ES LA LISTA DE USUARIOS EXTRAIDOS: " + usuarios);
            String user01 = usuarios.get(0);
            ingresarUsuarioContraseña(user01,password);

        }catch (Exception e){
            System.out.printf("Error de usuario o contraseña " + e );
            throw new AssertionError("Error de usuario o contraseña " + e);

        }
    }
    public void validarAgregarProductoCarrito(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(aMochila));
            driver.findElement(aMochila).click();
        } catch (Exception e){
            System.out.printf("Error al consultar producto" + e );
            throw new AssertionError("Error al consultar producto" + e);
        }
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnMochila));
            driver.findElement(btnMochila).click();
            //Thread.sleep(5000);
        } catch (Exception e){
            System.out.printf("Error al agregar producto" + e );
            throw new AssertionError("Error al consultar producto" + e);
        }
    }
    public void validarPoductoLista(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnCarrito));
            driver.findElement(btnCarrito).click();
            //Thread.sleep(5000);
        } catch (Exception e){
            System.out.printf("Error al consultar producto en carrito" + e );
            throw new AssertionError("Error al consultar producto en carrito" + e);
        }
    }
    public void validarCheckout(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnCheckout));
            driver.findElement(btnCheckout).click();
            //Thread.sleep(5000);
        } catch (Exception e){
            System.out.printf("Error al realizar checkout" + e);
            throw new AssertionError("Error al realizar checkout" + e);
        }

    }
    public void ingresarNombreyApellido(String nombre, String apellido){
        try {
            driver.findElement(inputNombre).sendKeys(nombre);
            driver.findElement(inputApellido).sendKeys(apellido);
        }catch (Exception e){
            System.out.printf("Error al ingresar datos: " + nombre + apellido + e );
            throw new AssertionError("Error al ingresar datos: " + e);
        }
    }
    public void ingresarCodigoPostal(String codigo){
        try {
            driver.findElement(inputCodigopostal).sendKeys(codigo);
            //Thread.sleep(5000);
        }catch (Exception e){
            System.out.printf("Error en codigo postal: " + codigo + e);
        }
    }
    public void validarContinuar(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnContinuar));
            driver.findElement(btnContinuar).click();
            //Thread.sleep(5000);
        } catch (Exception e){
            System.out.printf("Error al Continuar: " + e);
            throw new AssertionError("Error al Continuar: " + e);
        }

    }
    public void validarfinalizarOrden(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnFinalizar));
            driver.findElement(btnFinalizar).click();
            Thread.sleep(5000);
        } catch (Exception e){
            System.out.printf("Error al Finalizar orden: " + e);
            throw new AssertionError("Error al Finalizar orden: " + e);
        }

    }
    public void validarMensajeExcato(String mensaje){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(mnjFinalexacto));
            driver.findElement(mnjFinalexacto).isDisplayed();
            WebElement element = driver.findElement(mnjFinalexacto);
            String textoMsj = element.getText();

            System.out.println(" Este es el mensaje extraido : " + textoMsj);
             if (textoMsj.contains(mensaje)){
                 System.out.printf("El mensaje extraido es correcto : " + mensaje);

             }else {
                 System.out.printf("No coincide con el mensaje exacto: " + mensaje);
                 throw new RuntimeException("No coincide con el mensaje exacto: " + mensaje);
             }

        }catch (Exception e){
            System.out.printf("Error de mendaje exacto: " + e );
            throw new AssertionError("Error de mendaje exacto: " + e);

        }
    }

}
