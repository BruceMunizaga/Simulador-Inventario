package cl.ucn.disc.pa.beattherhythm.model;

public class InstrumentoCuerda {
    /**
     * El nombre del instrumento
     */
    private String nombre;

    /**
     * El tipo de cuerda
     */
    private String tipoDeCuerda;

    /**
     * El numero de cuerdas
     */
    private int numeroDeCuerda;

    /**
     * Material de construccion del instrumento
     */
    private String materialDeConstruccion;

    /**
     * Tipo de instrumento
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

    public InstrumentoCuerda(String nombre, String tipoDeCuerda, int numeroDeCuerda, String materialDeConstruccion, String tipo, String codigo, int precio, int stock) {
        // TODO: agregar validaciones
        this.nombre = nombre;
        this.tipoDeCuerda = tipoDeCuerda;
        this.numeroDeCuerda = numeroDeCuerda;
        this.materialDeConstruccion = materialDeConstruccion;
        this.tipo = tipo;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getTipoDeCuerda() {
        return this.tipoDeCuerda;
    }

    public int getNumeroDeCuerda() {
        return this.numeroDeCuerda;
    }

    public String getMaterialDeConstruccion() {
        return this.materialDeConstruccion;
    }

    public String getTipo() {
        return this.tipo;
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
}
