package Botica.PO;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaCarrito {
    public static final Target carritoVacio = Target.the("mensaje de carrito vacío")
            .locatedBy("[data-testid='carrito-vacio']");
    public static final Target cantidadPrimeraLinea = Target.the("cantidad de la primera línea")
            .locatedBy(".linea-carrito .cantidad-carrito");
    public static final Target actualizarPrimeraLinea = Target.the("actualizar primera línea")
            .locatedBy(".linea-carrito .btn-actualizar");
    public static final Target eliminarPrimeraLinea = Target.the("eliminar primera línea")
            .locatedBy(".linea-carrito .btn-eliminar");
    public static final Target primeraLinea = Target.the("primera línea del carrito")
            .locatedBy(".linea-carrito");
    public static final Target cupon = Target.the("código de cupón").locatedBy("[name='cupon']");
    public static final Target aplicarCupon = Target.the("aplicar cupón").locatedBy("#btn-aplicar-cupon");
    public static final Target mensajeCupon = Target.the("mensaje del cupón").locatedBy("#mensaje-cupon");
    public static final Target botonPagar = Target.the("ir a pagar").locatedBy(".btn-pagar");
}
