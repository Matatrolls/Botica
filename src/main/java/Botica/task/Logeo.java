package Botica.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static Botica.PO.PaginaLogin.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Logeo implements Task {
    private String usu;
    private String pass;

    public Logeo(String usuario, String password) {
        this.usu = usuario;
        this.pass = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(usuario, isVisible()).forNoMoreThan(10).seconds().then(SendKeys.of(usu).into(usuario)),
                WaitUntil.the(password, isVisible()).forNoMoreThan(10).seconds().then(SendKeys.of(pass).into(password)),
                Check.whether(WebElementQuestion.stateOf(botonLogin), WebElementStateMatchers.isVisible()).andIfSo(Click.on(botonLogin))
        );
        System.out.println("Se realiza login");
    }

    public static Logeo go() {
        return instrumented(Logeo.class);
    }
}
