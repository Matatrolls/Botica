package stepdefinitions;

import Botica.PO.PaginaCatalogo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;

import static Botica.Utils.RutasYConstantes.urlBoticaHome;
import static Botica.task.ExplorarCatalogo.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StepsCatalogo {
    @Managed
    public WebDriver driver;

    @Given("the shopper opens the catalog")
    public void abrirCatalogo() {
        theActorInTheSpotlight().attemptsTo(Open.url(urlBoticaHome));
    }

    @When("the shopper searches for {string}")
    public void buscarProducto(String texto) {
        theActorInTheSpotlight().attemptsTo(buscar(texto));
    }

    @When("the shopper filters by category {string}")
    public void filtrarCategoria(String categoria) {
        theActorInTheSpotlight().attemptsTo(filtrarPor(categoria));
    }

    @When("the shopper adds the first available product")
    public void agregarProducto() {
        assertFalse("El catálogo no contiene productos", driver.findElements(
                org.openqa.selenium.By.cssSelector(".tarjeta-producto")).isEmpty());
        theActorInTheSpotlight().attemptsTo(agregarPrimerProducto());
    }

    @Then("the catalog shows matching products")
    public void mostrarProductosCoincidentes() {
        assertFalse("No hay productos visibles después de la búsqueda", driver.findElements(
                org.openqa.selenium.By.cssSelector(".tarjeta-producto")).isEmpty());
    }

    @Then("the catalog shows no matching products")
    public void mostrarSinCoincidencias() {
        assertTrue("Se esperaba el mensaje sin resultados",
                driver.findElement(org.openqa.selenium.By.cssSelector(".sin-resultados")).isDisplayed());
    }

    @Then("the catalog confirms that the product was added")
    public void confirmarProductoAgregado() {
        assertTrue("El catálogo no muestra el mensaje de agregado",
                driver.findElement(org.openqa.selenium.By.cssSelector("[data-testid='mensaje-catalogo']"))
                        .isDisplayed());
        assertTrue(driver.findElement(org.openqa.selenium.By.cssSelector("[data-testid='mensaje-catalogo']"))
                .getText().startsWith("Se agregó "));
    }
}
