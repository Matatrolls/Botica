package Botica.PO;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaConfirmacion {
    public static final Target numeroPedido = Target.the("número de pedido")
            .locatedBy("[data-testid='numero-pedido']");
    public static final Target destinatario = Target.the("datos del destinatario").locatedBy(".destinatario");
    public static final Target resumen = Target.the("resumen de la compra").locatedBy(".lista-resumen");
    public static final Target continuarComprando = Target.the("seguir comprando")
            .locatedBy(".tarjeta-confirmacion a.btn-primario");
    public static final Target sinPedido = Target.the("mensaje sin pedido").locatedBy(".sin-pedido");
}
