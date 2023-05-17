package cl.ucn.disc.pa.beattherhythm.model;

public class InstrumentoCuerda {
    /**
     * El nombre del instrumento
     */
    private String nombreInstrumento;

    /**
     * Tipo de percusion del instrumento
     */
    private String tipoDeCuerda;

    /**
     * El numero de cuerdas del instrumento
     */
    private int numeroDecuerdas;

    /**
     * Material de construccion del instrumento
     */
    private String materialDeConstruccion;

    /**
     * Que tipo de instrumento es
     */
    private String tipo;

    /**
     * El codigo del instrumento
     */
    private String codigo;

    /**
     * El precio del instrumento
     */
    private int precio;

    /**
     * Stock del instrumento
     */
    private int stock;


    /**
     * Constructor del instrumento en caso de ser de tipo cuerda
     *
     * @param nombreInstrumento del instrumento
     * @param tipoDeCuerda del instrumento
     * @param numeroDecuerdas del instrumento
     * @param materialDeConstruccion del instrumento
     * @param tipo del instrumento
     * @param codigo del instrumento
     * @param precio del instrumento
     * @param stock del instrumento
     */
    public InstrumentoCuerda(String nombreInstrumento, String tipoDeCuerda, int numeroDecuerdas, String materialDeConstruccion, String tipo, String codigo, int precio, int stock) {

        //TODO: agregar validaciones
        this.nombreInstrumento = nombreInstrumento;
        this.tipoDeCuerda = tipoDeCuerda;
        this.numeroDecuerdas = numeroDecuerdas;
        this.materialDeConstruccion = materialDeConstruccion;
        this.tipo = tipo;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     *
     * @return el nombre del instrumento
     */
    public String getNombreInstrumento() {
        return this.nombreInstrumento;
    }

    /**
     *
     * @return el tipo de cuerda del instrumento en caso de tenerlas
     */
    public String getTipoDeCuerda() {
        return this.tipoDeCuerda;
    }

    /**
     *
     * @return el numero de cuerdas en caso de tenerlas
     */
    public int getNumeroDecuerdas() {
        return this.numeroDecuerdas;
    }

    /**
     *
     * @return el material de construccion del instrumento
     */
    public String getMaterialDeConstruccion() {
        return this.materialDeConstruccion;
    }

    /**
     *
     * @return el tipo de instrumento
     */
    public String getTipo() {
        return this.tipo;
    }

    /**
     *
     * @return el codigo del instrumento
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     *
     * @return el precio del instrumento
     */
    public int getPrecio() {
        return this.precio;
    }

    /**
     *
     * @return el stock del instrumento
     */
    public int getStock() {
        return this.stock;
    }

    /**
     *
     * @param stock para setear
     */
    public void setStock(int stock) {
        this.stock = this.stock + stock;
    }
}