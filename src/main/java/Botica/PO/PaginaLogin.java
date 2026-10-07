package Botica.PO;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaLogin {
    public static final Target usuario = Target.the("usuario").locatedBy("#usuario");
    public static final Target password = Target.the("password").locatedBy("#form-login > label:nth-child(3) > input[type=password]");
    public static final Target botonLogin = Target.the("boton login").locatedBy("#form-login > button[type=submit]");
    public static final Target mensajeError = Target.the("mensaje error").locatedBy("#form-login > p");

}
