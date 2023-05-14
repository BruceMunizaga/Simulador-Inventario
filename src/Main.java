/**
 * El Main
 */

import cl.ucn.disc.pa.beattherhythm.services.Sistema;
import ucn.StdIn;
import ucn.StdOut;

import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(final String[] args) throws IOException {
        menuPrincipal();
    }

    /**
     * menu principal del programa
     * @throws IOException en caso de un error
     */
    private static void menuPrincipal() throws IOException {
        StdOut.println();
        Sistema sistema = new Sistema();

        StdOut.println("[*] BIENVENIDO AL INVENTARIO DE BEAT THE RHYTHM[*]");
        String opcion = null;
        while (!Objects.equals(opcion,"4")){
            StdOut.println("""
                    Selecicione una opcion:
                    
                    [1] Ver inventario.
                    [2] Agregar instrumento al inventario.
                    [3] Vender Instrumento.
                    [4] Guardar cambios y cerrar el programa.
                    """);
            StdOut.print("Inserte su opcion aqui:");
            opcion = StdIn.readLine();

            switch (opcion){
                case "1" -> verInventario(sistema);
                case "2" -> agregarInstrumento(sistema);
                case "3" -> menuVentaInstrumento(sistema);
                case "4" -> StdOut.println("¡Hasta Pronto!");
                default -> StdOut.println("Opcion no valida, intente nuevamente");

            }
        }
    }

    /**
     * metodo para ver el inventario que se tiene actualmente
     *
     * @param sistema del sistema
     * @throws IOException en caso de que no hayan datos
     */
    private static void verInventario(Sistema sistema) throws IOException {
        StdOut.println("Usted esta viendo el inventario que hay actualmente:");

        sistema.desplegarInformacion();
    }

    /**
     * metodo para agregar un instrumento
     * @param sistema a ejecutar
     */
    private static void agregarInstrumento(Sistema sistema) {
        String opcion = null;
        while (!Objects.equals(opcion,"5")){
            StdOut.println("""
                    Escoja que tipo de instrumento es el que quiere agregar:
                    
                    [1] Instrumento de cuerda.
                    [2] Instrumento de percusion.
                    [3] Instrumento de viento.
                    
                    [5] Volver al menu principal
                    """);
            StdOut.print("Ingrese su opcion aqui: ");
            opcion = StdIn.readLine();

            if (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3") && !opcion.equals("5")){
                StdOut.println("Opcion no valida, intente nuevamente");
            }else{
                if (opcion.equals("5")){
                    StdOut.println("Regresando al menu anterior...");
                }else{
                    String opcion1 = null;
                    while (!Objects.equals(opcion1,"1") && !Objects.equals(opcion1,"2")){

                        StdOut.println("""
                                El tipo de instrumento que escogio,¿Se encuentra alojado en el inventario?:
                                
                                [1] Si
                                [2] No
                                """);

                        StdOut.print("Coloque su opcion aqui: ");
                        opcion1 = StdIn.readLine();

                        if (!Objects.equals(opcion1,"1") && !Objects.equals(opcion1,"2")){
                            StdOut.println("Opcion no valida, intente nuevamente");
                        }else{
                            sistema.agregarInstrumento(opcion,opcion1);
                        }
                    }
                }
            }
        }
    }

    /**
     * menu para escoger que tipo de instrumento vender
     * @param sistema a ejecutar
     * @throws IOException en caso de error
     */
    private static void menuVentaInstrumento(Sistema sistema) throws IOException {
        String opcion = null;
        while (!Objects.equals(opcion,"5")){
            StdOut.println("""
                    Escoja que tipo de instrumento es el que quiere vender:
                    
                    [1] Instrumento de cuerda.
                    [2] Instrumento de percusion.
                    [3] Instrumento de viento.
                    
                    [5] Volver al menu principal
                    """);
            StdOut.print("Ingrese su opcion aqui: ");
            opcion = StdIn.readLine();

            if (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3") && !opcion.equals("5")){
                StdOut.println("Opcion no valida, intente nuevamente");
            }else{
                if (opcion.equals("5")){
                    StdOut.println("Regresando al menu anterior...");
                }else{
                    sistema.venderInstrumento(opcion);
                }
            }
        }
    }
}
