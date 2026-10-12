package stepdefinitions;

import Botica.task.Logeo;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static Botica.Utils.RutasYConstantes.passwordPruebasCompra;
import static Botica.Utils.RutasYConstantes.urlBotica;
import static Botica.Utils.RutasYConstantes.usuarioPruebasCompra;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class HooksCompra {
    @Managed
    public WebDriver driver;

    @Before(value = "@compra", order = 10001)
    public void iniciarSesionParaPruebasDeCompra() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Comprador").can(BrowseTheWeb.with(driver));
        theActorInTheSpotlight().attemptsTo(
                Open.url(urlBotica),
                new Logeo(usuarioPruebasCompra, passwordPruebasCompra)
        );
    }
}
