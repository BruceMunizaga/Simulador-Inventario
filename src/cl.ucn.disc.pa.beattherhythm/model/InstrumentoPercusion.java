package cl.ucn.disc.pa.beattherhythm.model;

public class InstrumentoPercusion {

    /**
     * El nombre del instrumento
     */
    private String nombreInstrumento;

    /**
     * Tipo de percusion del instrumento
     */
    private String tipoDePercusion;

    /**
     * Material de construccion del instrumento
     */
    private String materialDeConstruccion;

    /**
     * Altura del instrumento (definida, indefinida)
     */
    private double altura;

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
     * Constructor del instrumento en caso de ser de tipo percusion
     *
     * @param nombreInstrumento del instrumento
     * @param tipoDePercusion del instrumento
     * @param materialDeConstruccion del instrumento
     * @param altura del instrumento
     * @param codigo del instrumento
     * @param precio del instrumento
     * @param stock del instrumento
     */
    public InstrumentoPercusion(String nombreInstrumento, String tipoDePercusion, String materialDeConstruccion, double altura, String codigo, int precio, int stock) {

        this.nombreInstrumento = nombreInstrumento;
        this.tipoDePercusion = tipoDePercusion;
        this.materialDeConstruccion = materialDeConstruccion;
        this.altura = altura;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
    }


    public String getNombreInstrumento() {
        return this.nombreInstrumento;
    }

    public String getTipoDePercusion() {
        return this.tipoDePercusion;
    }

    public String getMaterialDeConstruccion() {
        return this.materialDeConstruccion;
    }

    public double getAltura() {
        return this.altura;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public int getPrecio() {
        return this.precio;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = this.stock + stock;
    }
}
