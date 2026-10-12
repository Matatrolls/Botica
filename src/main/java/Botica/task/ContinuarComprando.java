package Botica.task;

import Botica.PO.PaginaConfirmacion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ContinuarComprando implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PaginaConfirmacion.continuarComprando));
    }

    public static ContinuarComprando conLaCompra() {
        return instrumented(ContinuarComprando.class);
    }
}
