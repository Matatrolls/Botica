package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Botica.task.FinalizarCompra.conDatos;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.junit.Assert.assertEquals;

public class StepsCheckoutDatosInvalidos {
    @Managed
    public WebDriver driver;

    @When("the shopper submits checkout details {string}, {string}, {string}, {string}, {string}")
    public void enviarDatosDeCheckout(String nombre, String correo, String direccion, String ciudad,
                                      String telefono) {
        theActorInTheSpotlight().attemptsTo(conDatos(nombre, correo, direccion, ciudad, telefono));
    }

    @Then("the checkout field {string} displays the error {string}")
    public void validarErrorDelCampo(String campo, String errorEsperado) {
        String selector = String.format("[data-campo='%s']", campo);
        assertEquals(errorEsperado, driver.findElement(By.cssSelector(selector)).getText());
    }
}
