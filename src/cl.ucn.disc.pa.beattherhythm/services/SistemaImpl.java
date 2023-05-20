package cl.ucn.disc.pa.beattherhythm.services;

import cl.ucn.disc.pa.beattherhythm.model.InstrumentoCuerda;
import cl.ucn.disc.pa.beattherhythm.model.InstrumentoPercusion;
import cl.ucn.disc.pa.beattherhythm.model.InstrumentoViento;
import ucn.StdIn;
import ucn.StdOut;


import java.io.*;
import java.util.Objects;

/**
 * El Sistema
 *
 * @author Bruce Munizaga - Paolo Vera
 */
public final class SistemaImpl implements Sistema {


    // arreglos donde se alojaran los instrumentos dada su clasificacion
    private InstrumentoCuerda[]  instrumentosCuerda = new InstrumentoCuerda[0];
    private InstrumentoPercusion[]  instrumentosPercusion = new InstrumentoPercusion[0];
    private InstrumentoViento[]  instrumentosViento = new InstrumentoViento[0];

    // variable donde se alojará el instrumento a manipular
    private InstrumentoCuerda instrumentoCuerda;
    private InstrumentoPercusion instrumentoPercusion;
    private InstrumentoViento instrumentoViento;


    public SistemaImpl() throws IOException{

        // carga los datos.
        try {
            this.cargarInformacion();
        } catch (FileNotFoundException ex) {
            // no se encontraron datos, se agregar los por defecto.

            // creo un instrumento de cuerda
            this.instrumentosCuerda = Utils.append(this.instrumentosCuerda, new InstrumentoCuerda("Guitarra","Nylon",12,"madera","electrico","123",1000,100));

            // creo un instrumento de percusion
            this.instrumentosPercusion = Utils.append(this.instrumentosPercusion, new InstrumentoPercusion("Cajon","idiofono","madera",5.0,"124",500,12));

            // creo un instrumento de viento
            this.instrumentosViento = Utils.append(this.instrumentosViento, new InstrumentoViento("trompeta","metal","122",5000,23));


        }

    }

    @Override
    public void cargarInformacion() throws IOException {
        String archivoCsv = "Inventario.csv"; // Ruta al archivo CSV
        String linea;
        String delimitador = ","; // Delimitador del CSV

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCsv))) {
            while ((linea = br.readLine()) != null) {
                String[] instrumento = linea.split(delimitador);
                String nombreInstrumento = instrumento[0];
                if (nombreInstrumento.equalsIgnoreCase("Guitarra") ||
                        nombreInstrumento.equalsIgnoreCase("Bajo") ||
                        nombreInstrumento.equalsIgnoreCase("Violin") ||
                        nombreInstrumento.equalsIgnoreCase("Arpa")){
                    String tipoDeCuerda = instrumento[1];
                    String numeroDeCuerdas = instrumento[2];
                    String materialDeConstruccion = instrumento[3];
                    String tipo = instrumento[4];
                    String codigo = instrumento[5];
                    String precio = instrumento[6];
                    String stock = instrumento[7];

                    this.instrumentosCuerda = Utils.append(this.instrumentosCuerda, new InstrumentoCuerda(nombreInstrumento,tipoDeCuerda,Integer.parseInt(numeroDeCuerdas),materialDeConstruccion,tipo,codigo,Integer.parseInt(precio),Integer.parseInt(stock)));
                }else{
                    if (nombreInstrumento.equalsIgnoreCase("Bongo") ||
                            nombreInstrumento.equalsIgnoreCase("Cajon") ||
                            nombreInstrumento.equalsIgnoreCase("Campanas") ||
                            nombreInstrumento.equalsIgnoreCase("Tubulares")||
                            nombreInstrumento.equalsIgnoreCase("Bombo")){
                        String tipoDePercusion = instrumento[1];
                        String materialDeConstruccion = instrumento[2];
                        String strAltura = instrumento[3];
                        double altura = Double.parseDouble(strAltura);
                        String codigo = instrumento[4];
                        String precio = instrumento[5];
                        String stock = instrumento[6];

                        this.instrumentosPercusion = Utils.append(this.instrumentosPercusion, new InstrumentoPercusion(nombreInstrumento,tipoDePercusion,materialDeConstruccion,altura,codigo,Integer.parseInt(precio),Integer.parseInt(stock)));
                    }else{
                        String materialDeConstruccion = instrumento[1];
                        String codigo = instrumento[2];
                        String precio = instrumento[3];
                        String stock = instrumento[4];

                        this.instrumentosViento = Utils.append(this.instrumentosViento, new InstrumentoViento(nombreInstrumento,materialDeConstruccion,codigo,Integer.parseInt(precio),Integer.parseInt(stock)));
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void desplegarInformacion() throws IOException {

        StdOut.println("Actualmente se encuentran estos instrumentos de cuerda guardados:");
        // ciclo para recorrer el arreglo y desplegarlo
        for (int i = 0; i < instrumentosCuerda.length; i++) {
            //asigno el instrumento a desplegar
            instrumentoCuerda = instrumentosCuerda[i];
            // lo despliego
            StdOut.println("["+ (i+1)+"]");
            StdOut.println("Nombre: "+instrumentoCuerda.getNombreInstrumento());
            StdOut.println("Tipo de cuerdas: "+instrumentoCuerda.getTipoDeCuerda());
            StdOut.println("Numero de cuerdas: "+instrumentoCuerda.getNumeroDecuerdas());
            StdOut.println("Material de construccion: "+instrumentoCuerda.getMaterialDeConstruccion());
            StdOut.println("Tipo: "+instrumentoCuerda.getTipo());
            StdOut.println("Codigo: "+instrumentoCuerda.getCodigo());
            StdOut.println("Precio: $"+instrumentoCuerda.getPrecio());
            StdOut.println("Stock: "+instrumentoCuerda.getStock());
            StdOut.println();
        }
        StdOut.println();

        StdOut.println("Actualmente se encuentran estos instrumentos de percusion guardados:");
        // ciclo para recorrer el arreglo y desplegarlo
        for (int i = 0; i < instrumentosPercusion.length; i++) {
            //asigno el instrumento a desplegar
            instrumentoPercusion = instrumentosPercusion[i];
            // lo despliego
            StdOut.println("["+ (i+1)+"]");
            StdOut.println("Nombre: "+instrumentoPercusion.getNombreInstrumento());
            StdOut.println("Tipo de Percusion: "+instrumentoPercusion.getTipoDePercusion());
            StdOut.println("Material de construccion: "+instrumentoPercusion.getMaterialDeConstruccion());
            StdOut.println("Altura: "+instrumentoPercusion.getAltura());
            StdOut.println("Codigo: "+instrumentoPercusion.getCodigo());
            StdOut.println("Precio: $"+instrumentoPercusion.getPrecio());
            StdOut.println("Stock: "+instrumentoPercusion.getStock());
            StdOut.println();
        }
        StdOut.println();

        StdOut.println("Actualmente se encuentran estos instrumentos de viento guardados:");
        // ciclo para recorrer el arreglo y desplegarlo
        for (int i = 0; i < instrumentosViento.length; i++) {
            //asigno el instrumento a desplegar
            instrumentoViento = instrumentosViento[i];
            // lo despliego
            StdOut.println("["+ (i+1)+"]");
            StdOut.println("Nombre: "+instrumentoViento.getNombreInstrumento());
            StdOut.println("Material de construccion: "+instrumentoViento.getMaterialDeConstruccion());
            StdOut.println("Codigo: "+instrumentoViento.getCodigo());
            StdOut.println("Precio: $"+instrumentoViento.getPrecio());
            StdOut.println("Stock: "+instrumentoViento.getStock());
            StdOut.println();
        }
        StdOut.println();
    }

    @Override
    public void venderInstrumento(final String opcion) {
        // variable que alojara el codigo a buscar
        String codigo;

        // si escogio la opcion 1 en el menu de ventas
        if (Objects.equals(opcion,"1")){
            StdOut.print("Ingrese el codigo del instrumento a vender: ");
            codigo = StdIn.readLine();
            this.instrumentoCuerda = this.buscarInstrumentoCuerda(codigo);

            // si no hay un instrumento de ese tipo con ese codigo
            if (instrumentoCuerda == null) {
                StdOut.println("Instrumento no encontrado, intente nuevamente");
            }else{
                int consultarStock = this.instrumentoCuerda.getStock();

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
                                this.instrumentoCuerda.setStock(cantdidadVender);
                                cantdidadVender = cantdidadVender * -1;
                                StdOut.println("Instrumento vendido");
                                StdOut.println("[*][*] Boleta de venta [*][*]");
                                StdOut.println("Nombre del instrumento: " + this.instrumentoCuerda.getNombreInstrumento());
                                StdOut.println("Unidades vendidas: " + cantdidadVender);
                                StdOut.println("Total precio: $" + cantdidadVender * this.instrumentoCuerda.getPrecio());
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
                this.instrumentoPercusion = this.buscarInstrumentoPercusion(codigo);

                // si no hay un instrumento de ese tipo con ese codigo
                if (instrumentoPercusion == null) {
                    StdOut.println("Instrumento no encontrado, intente nuevamente");
                }else{
                    int consultarStock = this.instrumentoPercusion.getStock();

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
                                    this.instrumentoPercusion.setStock(cantdidadVender);
                                    cantdidadVender = cantdidadVender * -1;
                                    StdOut.println("Instrumento vendido");
                                    StdOut.println("[*][*] Boleta de venta [*][*]");
                                    StdOut.println("Nombre del instrumento: " + this.instrumentoPercusion.getNombreInstrumento());
                                    StdOut.println("Unidades vendidas: " + cantdidadVender);
                                    StdOut.println("Total precio: $" + cantdidadVender * this.instrumentoPercusion.getPrecio());
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
                this.instrumentoViento = this.buscarInstrumentoViento(codigo);

                // si no hay un instrumento de ese tipo con ese codigo
                if (instrumentoViento == null) {
                    StdOut.println("Instrumento no encontrado, intente nuevamente");
                }else{
                    int consultarStock = this.instrumentoViento.getStock();

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
                                    this.instrumentoViento.setStock(cantdidadVender);
                                    cantdidadVender = cantdidadVender * -1;
                                    StdOut.println("Instrumento vendido");
                                    StdOut.println("[*][*] Boleta de venta [*][*]");
                                    StdOut.println("Nombre del instrumento: " + this.instrumentoViento.getNombreInstrumento());
                                    StdOut.println("Unidades vendidas: " + cantdidadVender);
                                    StdOut.println("Total precio: $" + cantdidadVender * this.instrumentoViento.getPrecio());
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

    @Override
    public void agregarInstrumento(String opcion, String opcion1) {

        // variable que contendra el codigo del instrumento a agregar
        final String codigo;

        // si el instrumento es de cuerda
        if (Objects.equals(opcion,"1")){

            // si el instrumento existe
            if (Objects.equals(opcion1,"1")){
                StdOut.print("Ingrese el codigo del instrumento a agregar: ");
                codigo = StdIn.readLine();

                // se busca el instrumento en base al codigo unico de este
                this.instrumentoCuerda = this.buscarInstrumentoCuerda(codigo);

                // si no lo encontre, despliego un mensaje
                if (instrumentoCuerda == null) {
                   StdOut.println("Instrumento no encontrado, intente nuevamente");

                   // si lo encontre, sigo con el programa
                }else{
                    StdOut.print("¿Cuantos instrumentos desea agregar?: ");
                    int cantidadAgregar = StdIn.readInt();

                    // si es una cantidad menor que cero, despliego el error
                    if (cantidadAgregar < 0){
                        StdOut.println("Lo sentimos, numeros menores que cero no son permitidos.");
                    }else{

                        // si esta correcta la cantidad, agrego al stock de instrumentos
                        if (cantidadAgregar >= 0){
                            this.instrumentoCuerda.setStock(cantidadAgregar);
                            StdOut.println("Cantidad agregada al instrumento");

                            // si el caracter no es un dato numerico, despliego un error con el motivo
                        }else {
                            throw new IllegalArgumentException("El caracter ingresado no corresponde a un dato numerico");
                        }
                    }
                }
            } else{

                // si es un instrumento de cuerda, pero no esta en el inventario
                if (Objects.equals(opcion1,"2")){

                    // variables que contendran los datos del instrumento
                    String nombreInstrumento;
                    String tipoDeCuerda;
                    int numeroDeCuerda;
                    String materialDeConstruccion;
                    String tipo;
                    String codigoInstrumento;
                    int precio;
                    int stock;

                    // ciclo para validar el nombre del instrumento en base a los aceptados
                    do {
                        StdOut.print("Ingrese el nombre del instrumento: ");
                        nombreInstrumento = StdIn.readLine();

                        // si no corresponde a los aceptados, ingresamos a esta condicion
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

                    // ciclo para validar el tipo de cuerda del instrumento en base a los aceptados
                    do {
                        StdOut.print("Ingrese el tipo de cuerda del instrumento: ");
                        tipoDeCuerda = StdIn.readLine();

                        //si no corresponde a los aceptados, ingresamos a esta condicion
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

                    // ciclo para validar el numero de cuerdas del instrumento en base a los aceptados
                    do {
                        StdOut.print("Ingrese el numero de cuerdas del instrumento: ");
                        numeroDeCuerda = StdIn.readInt();

                        // si el dato es menor que cero, ingresamos a la condicion
                        if (numeroDeCuerda < 0){
                            StdOut.println("Lo sentimos, solo se aceptan cantidades positivas");

                        }
                    }while (numeroDeCuerda < 0);

                    // ciclo para validar el material de construccion del instrumento en base a los aceptados
                    do {
                        StdOut.print("Ingrese el material de construccion del instrumento: ");
                        materialDeConstruccion = StdIn.readLine();

                        // si no corresponde a los aceptados, ingresamos a la condicion
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

                    InstrumentoCuerda instrumento1;

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

                    this.instrumentosCuerda = Utils.append(this.instrumentosCuerda,new InstrumentoCuerda
                            (nombreInstrumento,tipoDeCuerda,numeroDeCuerda,materialDeConstruccion,tipo,codigoInstrumento,precio,stock));

                    try {
                        File f = new File("./Inventario.csv");
                        FileWriter fw = new FileWriter(f, true);
                        BufferedWriter bw = new BufferedWriter(fw);

                        for(InstrumentoCuerda instrumentoCuerda : instrumentosCuerda){
                            String dataCuerda = instrumentoCuerda.getNombreInstrumento() + ", " + instrumentoCuerda.getTipoDeCuerda() + ", " +
                                    instrumentoCuerda.getNumeroDecuerdas() + ", " +  instrumentoCuerda.getMaterialDeConstruccion() + ", " +
                                    instrumentoCuerda.getTipo() + ", " + instrumentoCuerda.getCodigo() +", " + instrumentoCuerda.getPrecio() + ", " +
                                    instrumentoCuerda.getStock();
                            bw.write(dataCuerda + "\n");
                        }
                        bw.close();

                    }catch(Exception e){
                        StdOut.println("Error al inscribir el archivo");
                    }




                }
            }
        }else{

            // si es instrumento de percusion
            if (Objects.equals(opcion,"2")){
                if (Objects.equals(opcion1,"1")){
                    StdOut.print("Ingrese el codigo del instrumento a agregar: ");
                    codigo = StdIn.readLine();
                    this.instrumentoPercusion = this.buscarInstrumentoPercusion(codigo);
                    if (instrumentoPercusion == null) {
                        StdOut.println("Instrumento no encontrado, intente nuevamente");
                    }else{
                        StdOut.print("¿Cuantos instrumentos desea agregar?: ");
                        int cantidadAgregar = StdIn.readInt();
                        if (cantidadAgregar < 0){
                            StdOut.println("Lo sentimos, numeros menores que cero no son permitidos.");
                        }else{
                            if (cantidadAgregar >= 0){
                                this.instrumentoPercusion.setStock(cantidadAgregar);


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
                            StdOut.print("Ingrese el tipo de percusion del instrumento: ");
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

                        InstrumentoPercusion instrumento1;

                        do {
                            StdOut.print("Ingrese el codigo del instrumento: ");
                            codigoInstrumento = StdIn.readLine();
                            instrumento1 = this.buscarInstrumentoPercusion(codigoInstrumento);

                            if (instrumento1 != null){
                                StdOut.println("Lo sentimos, el codigo ingresado ya existe.");
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
                        this.instrumentosPercusion = Utils.append(this.instrumentosPercusion, new InstrumentoPercusion
                                (nombreInstrumento,tipoDePercusion,materialDeConstruccion,altura,codigoInstrumento,precio,stock));

                        try {
                            File f = new File("./instrumentosPercusion.csv");
                            FileWriter fw = new FileWriter(f, true);
                            BufferedWriter bw = new BufferedWriter(fw);

                            for(InstrumentoPercusion instrumentoPercusion : instrumentosPercusion){
                                String dataPercusion = instrumentoPercusion.getNombreInstrumento() + ", " + instrumentoPercusion.getTipoDePercusion() + ", " +
                                        instrumentoPercusion.getMaterialDeConstruccion() + ", " + instrumentoPercusion.getAltura() + ", "
                                        + instrumentoPercusion.getCodigo() +", " + instrumentoPercusion.getPrecio() + ", " +
                                        instrumentoPercusion.getStock();
                                bw.write(dataPercusion + "\n");
                            }
                            bw.close();

                        }catch(Exception e){
                            StdOut.println("Error al inscribir el archivo");
                        }

                        StdOut.println("Instrumento agregado al inventario");
                    }
                }
            }else{

                // si es un instrumento de viento
                if (Objects.equals(opcion,"3")){
                    if (Objects.equals(opcion1,"1")){
                        StdOut.print("Ingrese el codigo del instrumento a agregar: ");
                        codigo = StdIn.readLine();
                        this.instrumentoViento = this.buscarInstrumentoViento(codigo);
                        if (instrumentoViento == null) {
                            StdOut.println("Instrumento no encontrado, intente nuevamente");
                        }else{
                            StdOut.print("¿Cuantos instrumentos desea agregar?: ");
                            int cantidadAgregar = StdIn.readInt();
                            if (cantidadAgregar < 0){
                                StdOut.println("Lo sentimos, numeros menores que cero no son permitidos.");
                            }else{
                                if (cantidadAgregar >= 0){
                                    this.instrumentoViento.setStock(cantidadAgregar);


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

                            InstrumentoViento instrumento1;

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
                            this.instrumentosViento = Utils.append(this.instrumentosViento, new InstrumentoViento
                                    (nombreInstrumento,materialDeConstruccion,codigoInstrumento,precio,stock));

                            try {
                                File f = new File("./instrumentosViento.csv");
                                FileWriter fw = new FileWriter(f, true);
                                BufferedWriter bw = new BufferedWriter(fw);

                                for(InstrumentoViento instrumentoViento : instrumentosViento){
                                    String dataViento = instrumentoViento.getNombreInstrumento() + ", "  +
                                            instrumentoViento.getMaterialDeConstruccion() + ", "
                                            + instrumentoViento.getCodigo() +", " + instrumentoViento.getPrecio() + ", " +
                                            instrumentoViento.getStock();
                                    bw.write(dataViento + "\n");
                                }
                                bw.close();

                            }catch(Exception e){
                                StdOut.println("Error al inscribir el archivo");
                            }

                            StdOut.println("Instrumento agregado al inventario");
                        }
                    }
                }
            }
        }
    }

    @Override
    public InstrumentoCuerda buscarInstrumentoCuerda(final String codigo) {
        //recorro el arreglo de instrumentos de cuerda
        for (InstrumentoCuerda instrumento: this.instrumentosCuerda){
            // si lo encontré, lo retorno
            if (instrumento.getCodigo().equals(codigo)){
                return instrumento;
            }
        }
        // si no lo encontre, retorno null
        return null;
    }

    @Override
    public InstrumentoPercusion buscarInstrumentoPercusion(final String codigo) {
        //recorro el arreglo de instrumentos de percusion
        for (InstrumentoPercusion instrumento: this.instrumentosPercusion){
            // si lo encontré, lo retorno
            if (instrumento.getCodigo().equals(codigo)){
                return instrumento;
            }
        }
        return null;
    }

    @Override
    public InstrumentoViento buscarInstrumentoViento(final String codigo) {
        //recorro el arreglo de instrumentos de viento
        for (InstrumentoViento instrumento: this.instrumentosViento){
            // si lo encontré, lo retorno
            if (instrumento.getCodigo().equals(codigo)){
                return instrumento;
            }
        }
        return null;
    }

    @Override
    public void guardarInformacion() {
        String archivoCsv = "Inventario.csv"; // Ruta al archivo CSV

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCsv));

            // Sobrescribir la información en el archivo CSV
            for (int i = 0; i < instrumentosCuerda.length; i++) {
                //asigno el instrumento a desplegar
                instrumentoCuerda = instrumentosCuerda[i];
                String nombreInstrumento = instrumentoCuerda.getNombreInstrumento();
                String tipoDeCuerda = instrumentoCuerda.getTipoDeCuerda();
                int numeroDeCuerdas = instrumentoCuerda.getNumeroDecuerdas();
                String strNumeroDeCuerdas = Integer.toString(numeroDeCuerdas);
                String materialDeConstruccion = instrumentoCuerda.getMaterialDeConstruccion();
                String tipo = instrumentoCuerda.getTipo();
                String codigo = instrumentoCuerda.getCodigo();
                int precio = instrumentoCuerda.getPrecio();
                String strPrecio = Integer.toString(precio);
                int stock = instrumentoCuerda.getStock();
                String strStock = Integer.toString(stock);
                writer.write(nombreInstrumento);
                writer.write(",");
                writer.write(tipoDeCuerda);
                writer.write(",");
                writer.write(strNumeroDeCuerdas);
                writer.write(",");
                writer.write(materialDeConstruccion);
                writer.write(",");
                writer.write(tipo);
                writer.write(",");
                writer.write(codigo);
                writer.write(",");
                writer.write(strPrecio);
                writer.write(",");
                writer.write(strStock);
                writer.newLine();
            }

            for (int i = 0; i < instrumentosPercusion.length; i++) {
                //asigno el instrumento a desplegar
                instrumentoPercusion = instrumentosPercusion[i];
                String nombreInstrumento = instrumentoPercusion.getNombreInstrumento();
                String tipoDePercusion = instrumentoPercusion.getTipoDePercusion();
                String materialDeConstruccion = instrumentoPercusion.getMaterialDeConstruccion();
                double altura = instrumentoPercusion.getAltura();
                String strAltura = String.valueOf(altura);
                String codigo = instrumentoPercusion.getCodigo();
                int precio = instrumentoPercusion.getPrecio();
                String strPrecio = Integer.toString(precio);
                int stock = instrumentoPercusion.getStock();
                String strStock = Integer.toString(stock);
                writer.write(nombreInstrumento);
                writer.write(",");
                writer.write(tipoDePercusion);
                writer.write(",");
                writer.write(materialDeConstruccion);
                writer.write(",");
                writer.write(strAltura);
                writer.write(",");
                writer.write(codigo);
                writer.write(",");
                writer.write(strPrecio);
                writer.write(",");
                writer.write(strStock);
                writer.newLine();
            }

            for (int i = 0; i < instrumentosViento.length; i++) {
                //asigno el instrumento a desplegar
                instrumentoViento = instrumentosViento[i];
                String nombreInstrumento = instrumentoViento.getNombreInstrumento();
                String materialDeConstruccion = instrumentoViento.getMaterialDeConstruccion();
                String codigo = instrumentoViento.getCodigo();
                int precio = instrumentoViento.getPrecio();
                String strPrecio = Integer.toString(precio);
                int stock = instrumentoViento.getStock();
                String strStock = Integer.toString(stock);
                writer.write(nombreInstrumento);
                writer.write(",");
                writer.write(materialDeConstruccion);
                writer.write(",");
                writer.write(codigo);
                writer.write(",");
                writer.write(strPrecio);
                writer.write(",");
                writer.write(strStock);
                writer.newLine();
            }
            writer.close();

            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
