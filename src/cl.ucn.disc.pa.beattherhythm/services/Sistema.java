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
import java.util.Objects;

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

                // variables donde se alojaran los datos
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

                // variables donde se alojaran los datos
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

                // variables donde se alojaran los datos
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
        // ciclo para recorrer el arreglo y desplegarlo
        for (int i = 0; i < instrumentosCuerda.length; i++) {
            //asigno el instrumento a desplegar
            instrumento = instrumentosCuerda[i];
            // lo despliego
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
        // ciclo para recorrer el arreglo y desplegarlo
        for (int i = 0; i < instrumentosPercusion.length; i++) {
            //asigno el instrumento a desplegar
            instrumento = instrumentosPercusion[i];
            // lo despliego
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
        // ciclo para recorrer el arreglo y desplegarlo
        for (int i = 0; i < instrumentosViento.length; i++) {
            //asigno el instrumento a desplegar
            instrumento = instrumentosViento[i];
            // lo despliego
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
     * @param opcion a ejecutar
     */
    public void venderInstrumento(final String opcion) {
        // variable que alojara el codigo a buscar
        String codigo;

        // si escogio la opcion 1 en el menu de ventas
        if (Objects.equals(opcion,"1")){
            StdOut.print("Ingrese el codigo del instrumento a vender: ");
            codigo = StdIn.readLine();
            this.instrumento = this.buscarInstrumentoCuerda(codigo);

            // si no hay un instrumento de ese tipo con ese codigo
            if (instrumento == null) {
                StdOut.println("Instrumento no encontrado, intente nuevamente");
            }else{
                int consultarStock = this.instrumento.getStock();

                // si no hay stock del instrumento encontrado, se despliega el mensaje
                if (consultarStock <= 0){
                    StdOut.println("Lo sentimos, actualmente no contamos con stock suficiente para vender este instrumento");
                }else{
                    StdOut.print("¿Cuantos instrumentos desea vender?: ");
                    int cantdidadVender = StdIn.readInt();

                    // si la cantidad que queremos vender es negativa, se rechaza la venta
                    if (cantdidadVender < 0){
                        StdOut.println("Lo sentimos, numeros menores que cero no son permitidos.");
                    }else{
                        if (cantdidadVender >= 0){

                            // si la cantidad a vender supera el stock, se rechaza la venta
                            if (cantdidadVender > consultarStock){
                                StdOut.println("Lo sentimos, actualmente no contamos con esa cantidad de stock disponible para vender");
                            }else{

                                // si no hay rechazos, se ejecutan las operaciones y se despliega la boleta de venta
                                cantdidadVender = cantdidadVender * -1;
                                this.instrumento.setStock(cantdidadVender);
                                cantdidadVender = cantdidadVender * -1;
                                StdOut.println("Instrumento vendido");
                                StdOut.println("[*][*] Boleta de venda [*][*]");
                                StdOut.println("Nombre del instrumento: " + this.instrumento.getNombreInstrumento());
                                StdOut.println("Unidades vendidas: " + cantdidadVender);
                                StdOut.println("Total precio: $" + cantdidadVender * this.instrumento.getPrecio());
                                StdOut.println("[*][*][*][*][*][*][*][*][*][*]");
                            }
                        }else {
                            // si el caracter ingresado no es un numero, se despliega un error con el motivo
                            throw new IllegalArgumentException("El caracter ingresado no corresponde a un dato numerico");
                        }
                    }
                }
            }
        }else{
            // si escogio la opcion 2 en el menu de ventas
            if (Objects.equals(opcion,"2")){
                StdOut.print("Ingrese el codigo del instrumento a vender: ");
                codigo = StdIn.readLine();
                this.instrumento = this.buscarInstrumentoPercusion(codigo);

                // si no hay un instrumento de ese tipo con ese codigo
                if (instrumento == null) {
                    StdOut.println("Instrumento no encontrado, intente nuevamente");
                }else{
                    int consultarStock = this.instrumento.getStock();

                    // si no hay stock del instrumento encontrado, se despliega el mensaje
                    if (consultarStock <= 0){
                        StdOut.println("Lo sentimos, actualmente no contamos con stock suficiente para vender este instrumento");
                    }else{
                        StdOut.print("¿Cuantos instrumentos desea vender?: ");
                        int cantdidadVender = StdIn.readInt();

                        // si la cantidad que queremos vender es negativa, se rechaza la venta
                        if (cantdidadVender < 0){
                            StdOut.println("Lo sentimos, numeros menores que cero no son permitidos.");
                        }else{
                            if (cantdidadVender >= 0){

                                // si la cantidad a vender supera el stock, se rechaza la venta
                                if (cantdidadVender > consultarStock){
                                    StdOut.println("Lo sentimos, actualmente no contamos con esa cantidad de stock disponible para vender");
                                }else{

                                    // si no hay rechazos, se ejecutan las operaciones y se despliega la boleta de venta
                                    cantdidadVender = cantdidadVender * -1;
                                    this.instrumento.setStock(cantdidadVender);
                                    cantdidadVender = cantdidadVender * -1;
                                    StdOut.println("Instrumento vendido");
                                    StdOut.println("[*][*] Boleta de venda [*][*]");
                                    StdOut.println("Nombre del instrumento: " + this.instrumento.getNombreInstrumento());
                                    StdOut.println("Unidades vendidas: " + cantdidadVender);
                                    StdOut.println("Total precio: $" + cantdidadVender * this.instrumento.getPrecio());
                                    StdOut.println("[*][*][*][*][*][*][*][*][*][*]");
                                }
                            }else {

                                // si el caracter ingresado no es un numero, se despliega un error con el motivo
                                throw new IllegalArgumentException("El caracter ingresado no corresponde a un dato numerico");
                            }
                        }
                    }
                }
            }else{
                // si escogio la opcion 3 en el menu de ventas
                StdOut.print("Ingrese el codigo del instrumento a vender: ");
                codigo = StdIn.readLine();
                this.instrumento = this.buscarInstrumentoViento(codigo);

                // si no hay un instrumento de ese tipo con ese codigo
                if (instrumento == null) {
                    StdOut.println("Instrumento no encontrado, intente nuevamente");
                }else{
                    int consultarStock = this.instrumento.getStock();

                    // si no hay stock del instrumento encontrado, se despliega el mensaje
                    if (consultarStock <= 0){
                        StdOut.println("Lo sentimos, actualmente no contamos con stock suficiente para vender este instrumento");
                    }else{
                        StdOut.print("¿Cuantos instrumentos desea vender?: ");
                        int cantdidadVender = StdIn.readInt();

                        // si la cantidad que queremos vender es negativa, se rechaza la venta
                        if (cantdidadVender < 0){
                            StdOut.println("Lo sentimos, numeros menores que cero no son permitidos.");
                        }else{
                            if (cantdidadVender >= 0){

                                // si la cantidad a vender supera el stock, se rechaza la venta
                                if (cantdidadVender > consultarStock){
                                    StdOut.println("Lo sentimos, actualmente no contamos con esa cantidad de stock disponible para vender");
                                }else{

                                    // si no hay rechazos, se ejecutan las operaciones y se despliega la boleta de venta
                                    cantdidadVender = cantdidadVender * -1;
                                    this.instrumento.setStock(cantdidadVender);
                                    cantdidadVender = cantdidadVender * -1;
                                    StdOut.println("Instrumento vendido");
                                    StdOut.println("[*][*] Boleta de venda [*][*]");
                                    StdOut.println("Nombre del instrumento: " + this.instrumento.getNombreInstrumento());
                                    StdOut.println("Unidades vendidas: " + cantdidadVender);
                                    StdOut.println("Total precio: $" + cantdidadVender * this.instrumento.getPrecio());
                                    StdOut.println("[*][*][*][*][*][*][*][*][*][*]");
                                }
                            }else {

                                // si el caracter ingresado no es un numero, se despliega un error con el motivo
                                throw new IllegalArgumentException("El caracter ingresado no corresponde a un dato numerico");
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * metodo para agregar un instrumento al inventario
     * @param opcion tipo de instrumento a agregar
     * @param opcion1 existe el instrumento o no existe en el inventario
     */
    public void agregarInstrumento(String opcion, String opcion1) {
        final String codigo;

        if (Objects.equals(opcion,"1")){
            if (Objects.equals(opcion1,"1")){
                StdOut.print("Ingrese el codigo del instrumento a agregar: ");
                codigo = StdIn.readLine();
                this.instrumento = this.buscarInstrumentoCuerda(codigo);
                if (instrumento == null) {
                   StdOut.println("Instrumento no encontrado, intente nuevamente");
                }else{
                    StdOut.print("¿Cuantos instrumentos desea agregar?: ");
                    int cantidadAgregar = StdIn.readInt();
                    if (cantidadAgregar < 0){
                        StdOut.println("Lo sentimos, numeros menores que cero no son permitidos.");
                    }else{
                        if (cantidadAgregar >= 0){
                            this.instrumento.setStock(cantidadAgregar);
                            StdOut.println("Cantidad agregada al instrumento");
                        }else {
                            throw new IllegalArgumentException("El caracter ingresado no corresponde a un dato numerico");
                        }
                    }
                }
            } else{
                if (Objects.equals(opcion1,"2")){
                    String nombreInstrumento;
                    String tipoDeCuerda;
                    int numeroDeCuerda;
                    String materialDeConstruccion;
                    String tipo;
                    String codigoInstrumento;
                    int precio;
                    int stock;
                    do {
                        StdOut.print("Ingrese el nombre del instrumento: ");
                        nombreInstrumento = StdIn.readLine();

                        if (!nombreInstrumento.equalsIgnoreCase("Guitarra")
                                && !nombreInstrumento.equalsIgnoreCase("Bajo")
                                && !nombreInstrumento.equalsIgnoreCase("Violin")
                                && !nombreInstrumento.equalsIgnoreCase("Arpa")){
                            StdOut.println("""
                                Lo sentimos, ese instrumento no esta permitido. Instrumentos permitidos:
                                 -Guitarra
                                 -Bajo
                                 -Violin
                                 -Arpa
                            """);
                        }
                    }while (!nombreInstrumento.equalsIgnoreCase("Guitarra")
                            && !nombreInstrumento.equalsIgnoreCase("Bajo")
                            && !nombreInstrumento.equalsIgnoreCase("Violin")
                            && !nombreInstrumento.equalsIgnoreCase("Arpa"));

                    do {
                        StdOut.print("Ingrese el tipo de cuerda del instrumento: ");
                        tipoDeCuerda = StdIn.readLine();

                        if (!tipoDeCuerda.equalsIgnoreCase("Nylon")
                                && !tipoDeCuerda.equalsIgnoreCase("Acero")
                                && !tipoDeCuerda.equalsIgnoreCase("Tripa")){
                            StdOut.println("""
                               Lo sentimos, ese tipo de cuerda no esta permitido. Tipo de cuerdas permitidos:
                                -Nylon
                                -Acero
                                -Tripa
                            """);

                        }
                    }while (!tipoDeCuerda.equalsIgnoreCase("Nylon")
                            && !tipoDeCuerda.equalsIgnoreCase("Acero")
                            && !tipoDeCuerda.equalsIgnoreCase("Tripa"));
                    do {
                        StdOut.print("Ingrese el numero de cuerdas del instrumento: ");
                        numeroDeCuerda = StdIn.readInt();

                        if (numeroDeCuerda < 0){
                            StdOut.println("Lo sentimos, solo se aceptan cantidades positivas");

                        }
                    }while (numeroDeCuerda < 0);

                    do {
                        StdOut.print("Ingrese el material de construccion del instrumento: ");
                        materialDeConstruccion = StdIn.readLine();

                        if (!materialDeConstruccion.equalsIgnoreCase("Madera")
                                && !materialDeConstruccion.equalsIgnoreCase("Metal")){
                            StdOut.println("""
                               Lo sentimos, ese material de construccion no esta permitido. Material de construccion permitidos:
                                -Madera
                                -Metal
                            """);

                        }
                    }while (!materialDeConstruccion.equalsIgnoreCase("Madera")
                            && !materialDeConstruccion.equalsIgnoreCase("Metal"));

                    do {
                        StdOut.print("Ingrese el tipo del instrumento: ");
                        tipo = StdIn.readLine();

                        if (!tipo.equalsIgnoreCase("acustico")
                                && !tipo.equalsIgnoreCase("electrico")){
                            StdOut.println("""
                               Lo sentimos, solo se aceptan estos tipos:
                                -Acustico
                                -Electrico
                            """);

                        }
                    }while (!tipo.equalsIgnoreCase("acustico")
                            && !tipo.equalsIgnoreCase("electrico"));

                    Instrumento instrumento1;

                    do {
                        StdOut.print("Ingrese el codigo del instrumento: ");
                        codigoInstrumento = StdIn.readLine();
                        instrumento1 = this.buscarInstrumentoCuerda(codigoInstrumento);

                        if (instrumento1 != null){
                            StdOut.println("Lo sentimos, el codgio ingresado ya existe.");
                        }
                    }while (instrumento1 != null);

                    do {
                        StdOut.print("Ingrese el precio del instrumento: ");
                        precio = StdIn.readInt();

                        if (precio < 0){
                            StdOut.println("Lo sentimos, solo se aceptan cantidades positivas");

                        }
                    }while (precio < 0);

                    do {
                        StdOut.print("Ingrese el stock del instrumento: ");
                        stock = StdIn.readInt();

                        if (stock < 0){
                            StdOut.println("Lo sentimos, solo se aceptan cantidades positivas");

                        }
                    }while (stock < 0);

                    this.instrumentosCuerda = Utils.append(this.instrumentosCuerda,new Instrumento
                            (nombreInstrumento,tipoDeCuerda,numeroDeCuerda,materialDeConstruccion,tipo,codigoInstrumento,precio,stock));

                    StdOut.println("Instrumento agregado al inventario");
                }
            }
        }else{
            if (Objects.equals(opcion,"2")){
                if (Objects.equals(opcion1,"1")){
                    StdOut.print("Ingrese el codigo del instrumento a agregar: ");
                    codigo = StdIn.readLine();
                    this.instrumento = this.buscarInstrumentoPercusion(codigo);
                    if (instrumento == null) {
                        StdOut.println("Instrumento no encontrado, intente nuevamente");
                    }else{
                        StdOut.print("¿Cuantos instrumentos desea agregar?: ");
                        int cantidadAgregar = StdIn.readInt();
                        if (cantidadAgregar < 0){
                            StdOut.println("Lo sentimos, numeros menores que cero no son permitidos.");
                        }else{
                            if (cantidadAgregar >= 0){
                                this.instrumento.setStock(cantidadAgregar);


                                StdOut.println("Cantidad agregada al instrumento");
                            }else {
                                throw new IllegalArgumentException("El caracter ingresado no corresponde a un dato numerico");
                            }
                        }
                    }
                }else{
                    if (Objects.equals(opcion1,"2")){
                        String nombreInstrumento;
                        String tipoDePercusion;
                        String materialDeConstruccion;
                        double altura;
                        String codigoInstrumento;
                        int precio;
                        int stock;
                        do {
                            StdOut.print("Ingrese el nombre del instrumento: ");
                            nombreInstrumento = StdIn.readLine();

                            if (!nombreInstrumento.equalsIgnoreCase("Bongo")
                                    && !nombreInstrumento.equalsIgnoreCase("Cajon")
                                    && !nombreInstrumento.equalsIgnoreCase("Campanas")
                                    && !nombreInstrumento.equalsIgnoreCase("Tubulares")
                                    && !nombreInstrumento.equalsIgnoreCase("Bombo")){
                                StdOut.println("""
                                Lo sentimos, ese instrumento no esta permitido. Instrumentos permitidos:
                                 -Bongo
                                 -Cajon
                                 -Campanas
                                 -Tubulares
                                 -Bombo
                            """);
                            }
                        }while (!nombreInstrumento.equalsIgnoreCase("Bongo")
                                && !nombreInstrumento.equalsIgnoreCase("Cajon")
                                && !nombreInstrumento.equalsIgnoreCase("Campanas")
                                && !nombreInstrumento.equalsIgnoreCase("Tubulares")
                                && !nombreInstrumento.equalsIgnoreCase("Bombo"));

                        do {
                            StdOut.print("Ingrese el tipo de cuerda del instrumento: ");
                            tipoDePercusion = StdIn.readLine();

                            if (!tipoDePercusion.equalsIgnoreCase("Membranofono")
                                    && !tipoDePercusion.equalsIgnoreCase("Idiofono")){
                                StdOut.println("""
                               Lo sentimos, ese tipo de percusion no esta permitido. Tipo de percusion permitidos:
                                -Membranofono
                                -Idiofono
                            """);

                            }
                        }while (!tipoDePercusion.equalsIgnoreCase("Membranofono")
                                && !tipoDePercusion.equalsIgnoreCase("Idiofono"));

                        do {
                            StdOut.print("Ingrese el material de construccion del instrumento: ");
                            materialDeConstruccion = StdIn.readLine();

                            if (!materialDeConstruccion.equalsIgnoreCase("Madera")
                                    && !materialDeConstruccion.equalsIgnoreCase("Metal")
                                    && !materialDeConstruccion.equalsIgnoreCase("Piel")){
                                StdOut.println("""
                               Lo sentimos, ese material de construccion no esta permitido. Material de construccion permitidos:
                                -Madera
                                -Metal
                                -Piel
                            """);

                            }
                        }while (!materialDeConstruccion.equalsIgnoreCase("Madera")
                                && !materialDeConstruccion.equalsIgnoreCase("Metal")
                                && !materialDeConstruccion.equalsIgnoreCase("Piel"));

                        do {
                            StdOut.print("Ingrese la altura del instrumento (en metros): ");
                            altura = StdIn.readDouble();

                            if ( altura < 0.0){
                                StdOut.println("Lo sentimos, solo numeros positivos.");

                            }
                        }while (altura < 0.0);

                        Instrumento instrumento1;

                        do {
                            StdOut.print("Ingrese el codigo del instrumento: ");
                            codigoInstrumento = StdIn.readLine();
                            instrumento1 = this.buscarInstrumentoPercusion(codigoInstrumento);

                            if (instrumento1 != null){
                                StdOut.println("Lo sentimos, el codgio ingresado ya existe.");
                            }
                        }while (instrumento1 != null);

                        do {
                            StdOut.print("Ingrese el precio del instrumento: ");
                            precio = StdIn.readInt();

                            if (precio < 0){
                                StdOut.println("Lo sentimos, solo se aceptan cantidades positivas");

                            }
                        }while (precio < 0);

                        do {
                            StdOut.print("Ingrese el stock del instrumento: ");
                            stock = StdIn.readInt();

                            if (stock < 0){
                                StdOut.println("Lo sentimos, solo se aceptan cantidades positivas");

                            }
                        }while (stock < 0);
                        this.instrumentosPercusion = Utils.append(this.instrumentosPercusion, new Instrumento
                                (nombreInstrumento,tipoDePercusion,materialDeConstruccion,altura,codigoInstrumento,precio,stock));

                        StdOut.println("Instrumento agregado al inventario");
                    }
                }
            }else{
                if (Objects.equals(opcion,"3")){
                    if (Objects.equals(opcion1,"1")){
                        StdOut.print("Ingrese el codigo del instrumento a agregar: ");
                        codigo = StdIn.readLine();
                        this.instrumento = this.buscarInstrumentoViento(codigo);
                        if (instrumento == null) {
                            StdOut.println("Instrumento no encontrado, intente nuevamente");
                        }else{
                            StdOut.print("¿Cuantos instrumentos desea agregar?: ");
                            int cantidadAgregar = StdIn.readInt();
                            if (cantidadAgregar < 0){
                                StdOut.println("Lo sentimos, numeros menores que cero no son permitidos.");
                            }else{
                                if (cantidadAgregar >= 0){
                                    this.instrumento.setStock(cantidadAgregar);


                                    StdOut.println("Cantidad agregada al instrumento");
                                }else {
                                    throw new IllegalArgumentException("El caracter ingresado no corresponde a un dato numerico");
                                }
                            }
                        }
                    }else{
                        if (Objects.equals(opcion1,"2")){
                            String nombreInstrumento;
                            String materialDeConstruccion;
                            String codigoInstrumento;
                            int precio;
                            int stock;
                            do {
                                StdOut.print("Ingrese el nombre del instrumento: ");
                                nombreInstrumento = StdIn.readLine();

                                if (!nombreInstrumento.equalsIgnoreCase("Trompeta")
                                        && !nombreInstrumento.equalsIgnoreCase("Saxofon")
                                        && !nombreInstrumento.equalsIgnoreCase("Clarinete")
                                        && !nombreInstrumento.equalsIgnoreCase("Flauta")
                                        && !nombreInstrumento.equalsIgnoreCase("Traversa")){
                                    StdOut.println("""
                                Lo sentimos, ese instrumento no esta permitido. Instrumentos permitidos:
                                 -Trompeta
                                 -Saxofon
                                 -Clarinete
                                 -Flauta
                                 -Traversa
                            """);
                                }
                            }while (!nombreInstrumento.equalsIgnoreCase("Trompeta")
                                    && !nombreInstrumento.equalsIgnoreCase("Saxofon")
                                    && !nombreInstrumento.equalsIgnoreCase("Clarinete")
                                    && !nombreInstrumento.equalsIgnoreCase("Flauta")
                                    && !nombreInstrumento.equalsIgnoreCase("Traversa"));

                            do {
                                StdOut.print("Ingrese el material de construccion del instrumento: ");
                                materialDeConstruccion = StdIn.readLine();

                                if (!materialDeConstruccion.equalsIgnoreCase("Madera")
                                        && !materialDeConstruccion.equalsIgnoreCase("Metal")){
                                    StdOut.println("""
                               Lo sentimos, ese material de construccion no esta permitido. Material de construccion permitidos:
                                -Madera
                                -Metal
                            """);

                                }
                            }while (!materialDeConstruccion.equalsIgnoreCase("Madera")
                                    && !materialDeConstruccion.equalsIgnoreCase("Metal"));

                            Instrumento instrumento1;

                            do {
                                StdOut.print("Ingrese el codigo del instrumento: ");
                                codigoInstrumento = StdIn.readLine();
                                instrumento1 = this.buscarInstrumentoViento(codigoInstrumento);

                                if (instrumento1 != null){
                                    StdOut.println("Lo sentimos, el codgio ingresado ya existe.");
                                }
                            }while (instrumento1 != null);

                            do {
                                StdOut.print("Ingrese el precio del instrumento: ");
                                precio = StdIn.readInt();

                                if (precio < 0){
                                    StdOut.println("Lo sentimos, solo se aceptan cantidades positivas");

                                }
                            }while (precio < 0);

                            do {
                                StdOut.print("Ingrese el stock del instrumento: ");
                                stock = StdIn.readInt();

                                if (stock < 0){
                                    StdOut.println("Lo sentimos, solo se aceptan cantidades positivas");

                                }
                            }while (stock < 0);
                            this.instrumentosViento = Utils.append(this.instrumentosViento, new Instrumento
                                    (nombreInstrumento,materialDeConstruccion,codigoInstrumento,precio,stock));
                            StdOut.println("Instrumento agregado al inventario");
                        }
                    }
                }
            }
        }
    }

    /**
     * metodo para buscar un instrumento en base a su codigo unico
     * @param codigo a buscar
     * @return el instrumento
     */
    public Instrumento buscarInstrumentoCuerda(final String codigo) {
        //recorro el arreglo de instrumentos de cuerda
        for (Instrumento instrumento: this.instrumentosCuerda){
            // si lo encontré, lo retorno
            if (instrumento.getCodigo().equals(codigo)){
                return instrumento;
            }
        }
        // si no lo encontre, retorno null
        return null;
    }

    /**
     * metodo para buscar un instrumento en base a su codigo unico
     * @param codigo a buscar
     * @return el instrumento
     */
    public Instrumento buscarInstrumentoPercusion(final String codigo) {
        //recorro el arreglo de instrumentos de percusion
        for (Instrumento instrumento: this.instrumentosPercusion){
            // si lo encontré, lo retorno
            if (instrumento.getCodigo().equals(codigo)){
                return instrumento;
            }
        }
        return null;
    }

    /**
     * metodo para buscar un instrumento en base a su codigo unico
     * @param codigo a buscar
     * @return el instrumento
     */
    public Instrumento buscarInstrumentoViento(final String codigo) {
        //recorro el arreglo de instrumentos de viento
        for (Instrumento instrumento: this.instrumentosViento){
            // si lo encontré, lo retorno
            if (instrumento.getCodigo().equals(codigo)){
                return instrumento;
            }
        }
        return null;
    }

}
