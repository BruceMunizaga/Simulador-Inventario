package cl.ucn.disc.pa.beattherhythm.model;

public class InstrumentoViento {

    /**
     * El nombre del instrumento
     */
    private String nombreInstrumento;

    /**
     * Material de construccion del instrumento
     */
    private String materialDeConstruccion;

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
     * Constructor del instrumento en caso de ser de tipo viento
     *
     * @param nombreInstrumento del instrumento
     * @param materialDeConstruccion del instrumento
     * @param codigo del instrumento
     * @param precio del instrumento
     * @param stock del instrumento
     */
    public InstrumentoViento(String nombreInstrumento, String materialDeConstruccion, String codigo, int precio, int stock) {

        this.nombreInstrumento = nombreInstrumento;
        this.materialDeConstruccion = materialDeConstruccion;
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
     * @return el material de construccion del instrumento
     */
    public String getMaterialDeConstruccion() {
        return this.materialDeConstruccion;
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
