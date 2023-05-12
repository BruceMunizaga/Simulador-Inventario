package cl.ucn.disc.pa.beattherhythm.model;

public class InstrumentoViento {
    /**
     * El nombre del instrumento
     */
    private String nombre;

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

    public InstrumentoViento(String nombre, String materialDeConstruccion, String tipo, String codigo, int precio, int stock) {
       //TODO: agregar validaciones
        this.nombre = nombre;
        this.materialDeConstruccion = materialDeConstruccion;
        this.tipo = tipo;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return this.nombre;
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
