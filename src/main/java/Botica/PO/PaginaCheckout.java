package Botica.PO;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaCheckout {
    public static final Target nombre = Target.the("nombre completo").locatedBy("#nombreCompleto");
    public static final Target correo = Target.the("correo electrónico").locatedBy("[name='correo']");
    public static final Target direccion = Target.the("dirección").locatedBy("[data-testid='direccion']");
    public static final Target ciudad = Target.the("ciudad").locatedBy("[name='ciudad']");
    public static final Target telefono = Target.the("teléfono").locatedBy("[name='telefono']");
    public static final Target envioNormal = Target.the("envío normal").locatedBy("[name='envio'][value='normal']");
    public static final Target envioExpress = Target.the("envío express").locatedBy("[name='envio'][value='express']");
    public static final Target confirmarPedido = Target.the("confirmar pedido").locatedBy("#btn-confirmar");
    public static final Target mensaje = Target.the("mensaje del pago")
            .locatedBy("[data-testid='mensaje-checkout']");
    public static final Target errorNombre = Target.the("error del nombre").locatedBy("[data-campo='nombre']");
}
