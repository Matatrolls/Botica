package Botica.task;

import Botica.PO.PaginaCheckout;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FinalizarCompra implements Task {
    private final String nombre;
    private final String correo;
    private final String direccion;
    private final String ciudad;
    private final String telefono;

    public FinalizarCompra(String nombre, String correo, String direccion, String ciudad, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombre).into(PaginaCheckout.nombre),
                Enter.theValue(correo).into(PaginaCheckout.correo),
                Enter.theValue(direccion).into(PaginaCheckout.direccion),
                Enter.theValue(ciudad).into(PaginaCheckout.ciudad),
                Enter.theValue(telefono).into(PaginaCheckout.telefono),
                Click.on(PaginaCheckout.confirmarPedido)
        );
    }

    public static FinalizarCompra conDatos(String nombre, String correo, String direccion, String ciudad,
                                            String telefono) {
        return instrumented(FinalizarCompra.class, nombre, correo, direccion, ciudad, telefono);
    }
}
