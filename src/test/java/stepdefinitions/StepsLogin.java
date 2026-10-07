package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static Botica.Utils.RutasYConstantes.*;
import static Botica.PO.PaginaLogin.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepsLogin {
    @Managed
    public WebDriver driver;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("User");
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        theActorInTheSpotlight().can(BrowseTheWeb.with(driver));
        theActorInTheSpotlight().attemptsTo(Open.url(urlBotica));
    }

    @When("the user enters their credentials and clicks the login button")
    public void theUserEntersTheirEmailAndPassword() {
        theActorInTheSpotlight().attemptsTo(
                net.serenitybdd.screenplay.actions.Enter.theValue("alquimista").into(Botica.PO.PaginaLogin.usuario),
                net.serenitybdd.screenplay.actions.Enter.theValue("pocion123").into(Botica.PO.PaginaLogin.password),
                net.serenitybdd.screenplay.actions.Click.on(Botica.PO.PaginaLogin.botonLogin)
        );
    }

    @Then("the user should be redirected to their dashboard")
    public void theUserShouldBeRedirectedToTheirDashboard() {
       theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(actor -> Objects.equals(driver.getCurrentUrl(), Botica.Utils.RutasYConstantes.urlBoticaHome)
                )
        );
    }

    @When("the user enters their email {string} and password {string}")
    public void theUserEntersTheirEmailAndPassword(String email, String password) {
        theActorInTheSpotlight().attemptsTo(
                net.serenitybdd.screenplay.actions.Enter.theValue(email).into(Botica.PO.PaginaLogin.usuario),
                net.serenitybdd.screenplay.actions.Enter.theValue(password).into(Botica.PO.PaginaLogin.password),
                net.serenitybdd.screenplay.actions.Click.on(Botica.PO.PaginaLogin.botonLogin)
        );
    }

    @Then("they should see the error message")
    public void theyShouldSeeTheErrorMessage() {
        GivenWhenThen.seeThat(
                actor -> Objects.equals(Text.of(mensajeError).answeredBy(actor), "Usuario o contraseña incorrectos")
        );
    }
}
