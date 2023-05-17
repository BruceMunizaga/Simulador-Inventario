package cl.ucn.disc.pa.beattherhythm.services;

import cl.ucn.disc.pa.beattherhythm.model.InstrumentoCuerda;
import cl.ucn.disc.pa.beattherhythm.model.InstrumentoPercusion;
import cl.ucn.disc.pa.beattherhythm.model.InstrumentoViento;

import java.io.IOException;

public interface Sistema {

    /**
     * metodo que leera el archivo .txt
     * @throws IOException en caso de un error
     */
    void cargarInformacion() throws IOException;

    /**
     *  metodo que guardara los cambios ejecutados
     * @throws IOException en caso de un error
     */
    void guardarInformacion() throws IOException;

    /**
     * metodo que desplegara la informacion del .txt en pantalla
     */
    void desplegarInformacion();

    /**
     * metodo para vender un instrumento de cuerda en stock
     * @param opcion a ejecutar
     */
    void venderInstrumento(final String opcion);

    /**
     * metodo para agregar un instrumento al inventario
     * @param opcion tipo de instrumento a agregar
     * @param opcion1 existe el instrumento o no existe en el inventario
     */
    void agregarInstrumento(String opcion, String opcion1);

    /**
     * metodo para buscar un instrumento en base a su codigo unico
     * @param codigo a buscar
     * @return el instrumento
     */
    InstrumentoCuerda buscarInstrumentoCuerda(final String codigo);

    /**
     * metodo para buscar un instrumento en base a su codigo unico
     * @param codigo a buscar
     * @return el instrumento
     */
    InstrumentoPercusion buscarInstrumentoPercusion(final String codigo);

    /**
     * metodo para buscar un instrumento en base a su codigo unico
     * @param codigo a buscar
     * @return el instrumento
     */
    InstrumentoViento buscarInstrumentoViento(final String codigo);
}
