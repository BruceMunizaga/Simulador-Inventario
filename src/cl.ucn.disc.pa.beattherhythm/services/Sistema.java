/**
 * El Sistema
 *
 * @author Bruce Munizaga
 */

package cl.ucn.disc.pa.beattherhythm.services;

import cl.ucn.disc.pa.beattherhythm.model.Instrumento;
import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdIn;
import ucn.StdOut;

import java.io.IOException;

public final class Sistema {

    // arreglos donde se alojaran los instrumentos dada su clasificacion
    private Instrumento[]  instrumentosCuerda = new Instrumento[0];
    private Instrumento[]  instrumentosPercusion = new Instrumento[0];
    private Instrumento[]  instrumentosViento = new Instrumento[0];

    // variable donde se alojará el instrumento a manipular
    private Instrumento instrumento;

    public Sistema() throws IOException{

        cargarInformacion();

    }

    /**
     * metodo que leera el archivo .txt
     *
     * @throws IOException en caso de que no haya un archivo que leer
     */
    public void cargarInformacion() throws IOException {

        ArchivoEntrada arch1 = new ArchivoEntrada("Inventario");

        // ciclo para leer los datos del archivo
        while (!arch1.isEndFile()){
            Registro regEnt = arch1.getRegistro();
            String nombreInstrumento = regEnt.getString();

            // Condicionales para saber si el instrumento es de cuerda
            if (nombreInstrumento.equalsIgnoreCase("Guitarra") ||
                    nombreInstrumento.equalsIgnoreCase("Bajo") ||
                    nombreInstrumento.equalsIgnoreCase("Violin") ||
                    nombreInstrumento.equalsIgnoreCase("Arpa")){

                String tipoDeCuerda = regEnt.getString();
                int numeroDeCuerda = regEnt.getInt();
                String materialDeConstruccion = regEnt.getString();
                String tipo = regEnt.getString();
                String codigo = regEnt.getString();
                int precio = regEnt.getInt();
                int stock = regEnt.getInt();

                // agrego el instrumento a la lista de instrumentos
                this.instrumentosCuerda = Utils.append(this.instrumentosCuerda,new Instrumento
                        (nombreInstrumento,tipoDeCuerda,numeroDeCuerda,materialDeConstruccion,tipo,codigo,precio,stock));
            }

            // Condicionales para saber si el instrumento es de percusion
            if (nombreInstrumento.equalsIgnoreCase("Bongo") ||
                    nombreInstrumento.equalsIgnoreCase("Cajon") ||
                    nombreInstrumento.equalsIgnoreCase("Campanas") ||
                    nombreInstrumento.equalsIgnoreCase("Tubulares") ||
                    nombreInstrumento.equalsIgnoreCase("Bombo")){

                String tipoDePercusion = regEnt.getString();
                String materialDeConstruccion = regEnt.getString();
                double altura = regEnt.getDouble();
                String codigo = regEnt.getString();
                int precio = regEnt.getInt();
                int stock = regEnt.getInt();

                // agrego el instrumento a la lista de instrumentos
                this.instrumentosPercusion = Utils.append(this.instrumentosPercusion, new Instrumento
                        (nombreInstrumento,tipoDePercusion,materialDeConstruccion,altura,codigo,precio,stock));
            }

            // Condicionales para saber si el instrumento es de viento
            if (nombreInstrumento.equalsIgnoreCase("Trompeta") ||
                    nombreInstrumento.equalsIgnoreCase("Saxofon") ||
                    nombreInstrumento.equalsIgnoreCase("Clarinete") ||
                    nombreInstrumento.equalsIgnoreCase("Flauta") ||
                    nombreInstrumento.equalsIgnoreCase("Traversa")){

                String materialDeConstruccion = regEnt.getString();
                String codigo = regEnt.getString();
                int precio = regEnt.getInt();
                int stock = regEnt.getInt();

                // agrego el instrumento a la lista de instrumentos
                this.instrumentosViento = Utils.append(this.instrumentosViento, new Instrumento
                        (nombreInstrumento,materialDeConstruccion,codigo,precio,stock));
            }
        }
        // cierro el archivo
        arch1.close();
    }

    /**
     * metodo que desplegara la informacion del .txt en pantalla
     */
    public void desplegarInformacion() {

        StdOut.println("Actualmente se encuentran estos instrumentos de cuerda guardados:");
        for (int i = 0; i < instrumentosCuerda.length; i++) {
            instrumento = instrumentosCuerda[i];
            StdOut.println("["+ (i+1)+"]");
            StdOut.println("Nombre: "+instrumento.getNombreInstrumento());
            StdOut.println("Tipo de cuerdas: "+instrumento.getTipoDeCuerda());
            StdOut.println("Numero de cuerdas: "+instrumento.getNumeroDecuerdas());
            StdOut.println("Material de construccion: "+instrumento.getMaterialDeConstruccion());
            StdOut.println("Tipo: "+instrumento.getTipo());
            StdOut.println("Codigo: "+instrumento.getCodigo());
            StdOut.println("Precio: $"+instrumento.getPrecio());
            StdOut.println("Stock: "+instrumento.getStock());
            StdOut.println();
        }
        StdOut.println();

        StdOut.println("Actualmente se encuentran estos instrumentos de percusion guardados:");
        for (int i = 0; i < instrumentosPercusion.length; i++) {
            instrumento = instrumentosPercusion[i];
            StdOut.println("["+ (i+1)+"]");
            StdOut.println("Nombre: "+instrumento.getNombreInstrumento());
            StdOut.println("Tipo de Percusion: "+instrumento.getTipoDePercusion());
            StdOut.println("Material de construccion: "+instrumento.getMaterialDeConstruccion());
            StdOut.println("Altura: "+instrumento.getAltura());
            StdOut.println("Codigo: "+instrumento.getCodigo());
            StdOut.println("Precio: $"+instrumento.getPrecio());
            StdOut.println("Stock: "+instrumento.getStock());
            StdOut.println();
        }
        StdOut.println();

        StdOut.println("Actualmente se encuentran estos instrumentos de viento guardados:");
        for (int i = 0; i < instrumentosViento.length; i++) {
            instrumento = instrumentosViento[i];
            StdOut.println("["+ (i+1)+"]");
            StdOut.println("Nombre: "+instrumento.getNombreInstrumento());
            StdOut.println("Material de construccion: "+instrumento.getMaterialDeConstruccion());
            StdOut.println("Codigo: "+instrumento.getCodigo());
            StdOut.println("Precio: $"+instrumento.getPrecio());
            StdOut.println("Stock: "+instrumento.getStock());
            StdOut.println();
        }
        StdOut.println();
    }

    /**
     * metodo para vender un instrumento de cuerda en stock
     */
    public void venderInstrumentoCuerda() {
        boolean verificador = true;
        Instrumento instrumento = null;
        do{
            StdOut.print("Inserte el codigo del instrumento:");
            String codigo = StdIn.readLine();

            // recorro el arreglo de los instrumentos de cuerda
            for (Instrumento instrumento1 : this.instrumentosCuerda){
                // si lo encontré, lo ejecuto
                if (instrumento1.getCodigo().equals(codigo)){
                    verificador = true;
                    instrumento = instrumento1;
                    StdOut.print("Inserte la cantidad a vender:");
                    int cantidadVender = StdIn.readInt();

                } else{
                    StdOut.println("Codigo no encontrado, intente nuevamente.");
                    verificador = false;
                }
            }
        }while (!verificador);

    }

    public void venderInstrumentoPercusion() {
    }

    public void venderInstrumentoViento() {
    }

    public void agregarInstrumento(String opcion, String opcion1) {
        String codigo;

        if (opcion.equals("1")){
            if (opcion1.equals("1")){
                StdOut.print("Ingrese el codigo del instrumento a agregar: ");
                codigo = StdIn.readLine();
                instrumento = this.buscarInstrumento(codigo);
                if (instrumento == null);{
                    throw new IllegalArgumentException("Instrumento no encontrado.");
                }
            }
        }
    }
    public Instrumento buscarInstrumento(final String codigo) {
        //recorro el arreglo de instrumentos de cuerda
        for (Instrumento instrumento1: this.instrumentosCuerda){
            // si lo encontré, lo retorno
            if (instrumento1.getCodigo().equals(codigo)){
                return instrumento1;
            }
        }
        // si no lo encontre, retorno null
        return null;
    }
}
