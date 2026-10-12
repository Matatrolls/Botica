package Botica.task;

import Botica.PO.PaginaCarrito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GestionarCarrito implements Task {
    private final String accion;
    private final String valor;

    public GestionarCarrito(String accion, String valor) {
        this.accion = accion;
        this.valor = valor;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (accion) {
            case "cupon":
                actor.attemptsTo(
                        Enter.theValue(valor).into(PaginaCarrito.cupon),
                        Click.on(PaginaCarrito.aplicarCupon)
                );
                break;
            case "actualizar":
                actor.attemptsTo(
                        Enter.theValue(valor).into(PaginaCarrito.cantidadPrimeraLinea),
                        Click.on(PaginaCarrito.actualizarPrimeraLinea)
                );
                break;
            case "eliminar":
                actor.attemptsTo(Click.on(PaginaCarrito.eliminarPrimeraLinea));
                break;
            case "pagar":
                actor.attemptsTo(Click.on(PaginaCarrito.botonPagar));
                break;
            default:
                throw new IllegalArgumentException("Acción de carrito no admitida: " + accion);
        }
    }

    public static GestionarCarrito aplicarCupon(String codigo) {
        return instrumented(GestionarCarrito.class, "cupon", codigo);
    }

    public static GestionarCarrito actualizarPrimeraLinea(String cantidad) {
        return instrumented(GestionarCarrito.class, "actualizar", cantidad);
    }

    public static GestionarCarrito eliminarPrimeraLinea() {
        return instrumented(GestionarCarrito.class, "eliminar", "");
    }

    public static GestionarCarrito irAPagar() {
        return instrumented(GestionarCarrito.class, "pagar", "");
    }
}
