package stepdefinitions;

import Botica.PO.PaginaCarrito;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Botica.Utils.RutasYConstantes.urlCarrito;
import static Botica.Utils.RutasYConstantes.urlBoticaHome;
import static Botica.task.ExplorarCatalogo.agregarPrimerProducto;
import static Botica.task.GestionarCarrito.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepsCarrito {
    @Managed
    public WebDriver driver;

    @Given("the shopper opens the cart")
    public void abrirCarrito() {
        theActorInTheSpotlight().attemptsTo(Open.url(urlCarrito));
    }

    @Given("the cart contains a product")
    public void carritoConProducto() {
        theActorInTheSpotlight().attemptsTo(Open.url(urlBoticaHome), agregarPrimerProducto(), Open.url(urlCarrito));
    }

    @When("the shopper updates the first item quantity to {string}")
    public void actualizarCantidad(String cantidad) {
        theActorInTheSpotlight().attemptsTo(actualizarPrimeraLinea(cantidad));
    }

    @When("the shopper removes the first item")
    public void eliminarPrimero() {
        theActorInTheSpotlight().attemptsTo(eliminarPrimeraLinea());
    }

    @When("the shopper applies the invalid coupon {string}")
    public void aplicarCuponInvalido(String codigo) {
        theActorInTheSpotlight().attemptsTo(aplicarCupon(codigo));
    }

    @Then("the cart is empty")
    public void carritoVacio() {
        assertTrue(driver.findElement(By.cssSelector("[data-testid='carrito-vacio']")).isDisplayed());
    }

    @Then("the first item quantity is {string}")
    public void cantidadActualizada(String cantidad) {
        assertEquals(cantidad, driver.findElement(By.cssSelector(".linea-carrito .cantidad-carrito"))
                .getAttribute("value"));
    }

    @Then("the coupon is rejected")
    public void cuponRechazado() {
        String mensaje = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mensaje-cupon")))
                .getText();
        assertEquals("Cupón no válido", mensaje);
    }
}
