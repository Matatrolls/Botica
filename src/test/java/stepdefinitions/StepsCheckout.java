package stepdefinitions;

import Botica.PO.PaginaCheckout;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Botica.Utils.RutasYConstantes.*;
import static Botica.task.ExplorarCatalogo.agregarPrimerProducto;
import static Botica.task.GestionarCarrito.irAPagar;
import static Botica.task.FinalizarCompra.conDatos;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.junit.Assert.assertTrue;

public class StepsCheckout {
    @Managed
    public WebDriver driver;

    @Given("the shopper opens checkout with an item in the cart")
    public void abrirCheckoutConProducto() {
        theActorInTheSpotlight().attemptsTo(
                Open.url(urlBoticaHome),
                agregarPrimerProducto(),
                Open.url(urlCarrito),
                irAPagar()
        );
        assertTrue("No se abrió el checkout", driver.getCurrentUrl().contains(urlCheckout));
    }

    @When("the shopper submits the checkout form without required information")
    public void enviarFormularioIncompleto() {
        theActorInTheSpotlight().attemptsTo(Click.on(PaginaCheckout.confirmarPedido));
    }

    @When("the shopper submits valid checkout information")
    public void enviarInformacionValida() {
        theActorInTheSpotlight().attemptsTo(conDatos(
                "Comprador de prueba", "comprador@example.test", "Calle de prueba 123", "Ciudad de prueba",
                "3001234567"));
    }

    @Then("the checkout form displays required-field errors")
    public void erroresCamposObligatorios() {
        assertTrue(driver.findElement(By.cssSelector("[data-testid='mensaje-checkout']")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("[data-campo='nombre']")).getText()
                .contains("obligatorio"));
    }

    @Then("the shopper reaches the order confirmation page")
    public void llegaConfirmacion() {
        assertTrue("No se redirigió a la confirmación",
                new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.urlContains(urlConfirmacion)));
    }
}
