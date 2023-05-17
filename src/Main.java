/**
 * El Main
 */

import cl.ucn.disc.pa.beattherhythm.services.SistemaImpl;
import edu.princeton.cs.stdlib.StdIn;
import edu.princeton.cs.stdlib.StdOut;
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
        SistemaImpl sistemaImpl = new SistemaImpl();

        StdOut.println("[*] BIENVENIDO AL INVENTARIO DE BEAT THE RHYTHM [*]");
        String opcion = null;
        while (!Objects.equals(opcion,"4")){
            StdOut.println("""
                    
                    [1] Ver inventario.
                    [2] Agregar instrumento al inventario.
                    [3] Vender Instrumento.
                    [4] Guardar cambios y cerrar el programa.
                    """);
            StdOut.print("Inserte su opcion aqui: ");
            opcion = StdIn.readLine();

            switch (opcion){
                case "1" -> verInventario(sistemaImpl);
                case "2" -> agregarInstrumento(sistemaImpl);
                case "3" -> menuVentaInstrumento(sistemaImpl);
                case "4" -> actualizarInventario();
                default -> StdOut.println("Opcion no valida, intente nuevamente");

            }
        }
    }
    private static void actualizarInventario() throws IOException {
        StdOut.println("¡Hasta pronto!");
    }

    /**
     * metodo para ver el inventario que se tiene actualmente
     *
     * @param sistemaImpl del sistema
     * @throws IOException en caso de que no hayan datos
     */
    private static void verInventario(SistemaImpl sistemaImpl) throws IOException {
        StdOut.println("Usted esta viendo el inventario que hay actualmente:");

        sistemaImpl.desplegarInformacion();
    }

    /**
     * metodo para agregar un instrumento
     * @param sistemaImpl a ejecutar
     */
    private static void agregarInstrumento(SistemaImpl sistemaImpl) {
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

            if (!Objects.equals(opcion,"1")&& !Objects.equals(opcion,"2") && !Objects.equals(opcion,"3")
                    && !Objects.equals(opcion,"5")){
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
                            sistemaImpl.agregarInstrumento(opcion,opcion1);
                        }
                    }
                }
            }
        }
    }

    /**
     * menu para escoger que tipo de instrumento vender
     * @param sistemaImpl a ejecutar
     * @throws IOException en caso de error
     */
    private static void menuVentaInstrumento(SistemaImpl sistemaImpl) throws IOException {
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
                    sistemaImpl.venderInstrumento(opcion);
                }
            }
        }
    }
}
