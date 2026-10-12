package Botica.PO;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaCatalogo {
    public static final Target buscar = Target.the("búsqueda del catálogo").locatedBy("#buscar");
    public static final Target categoria = Target.the("categoría del catálogo").locatedBy("[name='categoria']");
    public static final Target primerProducto = Target.the("primer producto").locatedBy(".tarjeta-producto");
    public static final Target cantidadPrimerProducto = Target.the("cantidad del primer producto")
            .locatedBy(".tarjeta-producto .cantidad");
    public static final Target agregarPrimerProducto = Target.the("agregar primer producto")
            .locatedBy(".tarjeta-producto .btn-agregar");
    public static final Target mensaje = Target.the("mensaje del catálogo")
            .locatedBy("[data-testid='mensaje-catalogo']");
    public static final Target productos = Target.the("productos del catálogo").locatedBy(".tarjeta-producto");
    public static final Target sinResultados = Target.the("mensaje sin resultados").locatedBy(".sin-resultados");
}
