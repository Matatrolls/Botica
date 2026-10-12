package Botica.task;

import Botica.PO.PaginaCatalogo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExplorarCatalogo implements Task {
    private final String accion;
    private final String valor;

    public ExplorarCatalogo(String accion, String valor) {
        this.accion = accion;
        this.valor = valor;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (accion) {
            case "buscar":
                actor.attemptsTo(Enter.theValue(valor).into(PaginaCatalogo.buscar));
                break;
            case "filtrar":
                actor.attemptsTo(SelectFromOptions.byVisibleText(valor).from(PaginaCatalogo.categoria));
                break;
            case "agregar":
                actor.attemptsTo(
                        Enter.theValue("1").into(PaginaCatalogo.cantidadPrimerProducto),
                        Click.on(PaginaCatalogo.agregarPrimerProducto)
                );
                break;
            default:
                throw new IllegalArgumentException("Acción de catálogo no admitida: " + accion);
        }
    }

    public static ExplorarCatalogo buscar(String texto) {
        return instrumented(ExplorarCatalogo.class, "buscar", texto);
    }

    public static ExplorarCatalogo filtrarPor(String categoria) {
        return instrumented(ExplorarCatalogo.class, "filtrar", categoria);
    }

    public static ExplorarCatalogo agregarPrimerProducto() {
        return instrumented(ExplorarCatalogo.class, "agregar", "");
    }
}
