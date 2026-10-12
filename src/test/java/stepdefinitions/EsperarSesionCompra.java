package stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Botica.Utils.RutasYConstantes.urlBoticaHome;

public class EsperarSesionCompra {
    @Managed
    public WebDriver driver;

    @Before(value = "@compra", order = 10002)
    public void esperarInicioSesionYCatalogo() {
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(30));
        espera.withMessage("El login no terminó redirigiendo al catálogo");
        espera.until(ExpectedConditions.urlToBe(urlBoticaHome));
        espera.withMessage("El catálogo abrió, pero su campo de búsqueda no quedó visible");
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#buscar")));
    }
}
