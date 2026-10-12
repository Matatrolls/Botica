package stepdefinitions;

import Botica.PO.PaginaConfirmacion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Botica.Utils.RutasYConstantes.*;
import static Botica.task.ExplorarCatalogo.agregarPrimerProducto;
import static Botica.task.ContinuarComprando.conLaCompra;
import static Botica.task.FinalizarCompra.conDatos;
import static Botica.task.GestionarCarrito.irAPagar;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StepsConfirmacion {
    @Managed
    public WebDriver driver;

    @Given("the shopper opens order confirmation")
    public void abrirConfirmacion() {
        theActorInTheSpotlight().attemptsTo(Open.url(urlConfirmacion));
    }

    @Given("the shopper completes a purchase")
    public void completarCompra() {
        theActorInTheSpotlight().attemptsTo(
                Open.url(urlBoticaHome),
                agregarPrimerProducto(),
                Open.url(urlCarrito),
                irAPagar()
        );
        assertTrue("No se abrió el checkout", driver.getCurrentUrl().contains(urlCheckout));
        theActorInTheSpotlight().attemptsTo(
                conDatos("Comprador de prueba", "comprador@example.test", "Calle de prueba 123",
                        "Ciudad de prueba", "3001234567")
        );
        assertTrue("No se abrió la confirmación",
                new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.urlContains(urlConfirmacion)));
    }

    @Then("the order confirmation details are displayed")
    public void detallesConfirmacion() {
        assertTrue(driver.findElement(By.cssSelector("[data-testid='numero-pedido']")).isDisplayed());
        assertFalse(driver.findElement(By.cssSelector("[data-testid='numero-pedido']")).getText().isEmpty());
        assertTrue(driver.findElement(By.cssSelector(".destinatario")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".lista-resumen")).isDisplayed());
    }

    @Then("the page reports that there is no recent order")
    public void sinPedidoReciente() {
        assertTrue(driver.findElement(By.cssSelector(".sin-pedido")).isDisplayed());
    }

    @When("the shopper chooses to continue shopping")
    public void continuarComprando() {
        theActorInTheSpotlight().attemptsTo(conLaCompra());
    }

    @Then("the shopper returns to the catalog")
    public void regresaCatalogo() {
        assertTrue(driver.getCurrentUrl().contains(urlBoticaHome));
    }
}
