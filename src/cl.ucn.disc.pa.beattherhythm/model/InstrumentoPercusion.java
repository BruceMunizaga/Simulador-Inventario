package cl.ucn.disc.pa.beattherhythm.model;

public class InstrumentoPercusion {
    /**
     * El nombre del instrumento
     */
    private String nombre;

    /**
     * Tipo de percusion del instrumento
     */
    private String tipoDePercusion;

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
     * Altura del instrumento (definida, indefinida)
     */
    private double altura;

    public InstrumentoPercusion(String nombre, String tipoDePercusion, String materialDeConstruccion, String tipo, String codigo, int precio, int stock, double altura) {
        //TODO: agregar validaciones
        this.nombre = nombre;
        this.tipoDePercusion = tipoDePercusion;
        this.materialDeConstruccion = materialDeConstruccion;
        this.tipo = tipo;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
        this.altura = altura;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getTipoDePercusion() {
        return this.tipoDePercusion;
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

    public double getAltura() {
        return this.altura;
    }
}