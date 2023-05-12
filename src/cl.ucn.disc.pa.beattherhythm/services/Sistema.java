/**
 * El Sistema
 *
 * @author Bruce Munizaga
 */

package cl.ucn.disc.pa.beattherhythm.services;

import cl.ucn.disc.pa.beattherhythm.model.InstrumentoCuerda;
import cl.ucn.disc.pa.beattherhythm.model.InstrumentoPercusion;
import cl.ucn.disc.pa.beattherhythm.model.InstrumentoViento;
import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdOut;

import java.io.FileNotFoundException;
import java.io.IOException;

public final class Sistema {

    // arreglos donde se alojaran los instrumentos dada su clasificacion
    private InstrumentoCuerda[]  instrumentosCuerda = new InstrumentoCuerda[0];
    private InstrumentoPercusion[]  instrumentosPercusion = new InstrumentoPercusion[0];
    private InstrumentoViento[]  instrumentosViento = new InstrumentoViento[0];

    // variables donde se alojaran los instrumentos para luego trasladarlas a los arreglos
    private InstrumentoCuerda instrumentoCuerda;
    private InstrumentoPercusion instrumentoPercusion;
    private InstrumentoViento instrumentoViento;

    public Sistema() throws IOException{

        // no hay instrumentos en el sistema
        this.instrumentoCuerda = null;
        this.instrumentoPercusion = null;
        this.instrumentoViento = null;

        cargarInformacion();

    }

    private void cargarInformacion() throws IOException {

        ArchivoEntrada arch1 = new ArchivoEntrada("sucursales.txt");

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

                this.instrumentosCuerda = Utils.append(this.instrumentosCuerda,new InstrumentoCuerda
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
                String tipo = regEnt.getString();
                String codigo = regEnt.getString();
                int precio = regEnt.getInt();
                int stock = regEnt.getInt();
                double altura = regEnt.getDouble();

                this.instrumentosPercusion = Utils.append(this.instrumentosPercusion, new InstrumentoPercusion
                        (nombreInstrumento,tipoDePercusion,materialDeConstruccion,tipo,codigo,precio,stock, altura));
            }

            // Condicionales para saber si el instrumento es de viento
            if (nombreInstrumento.equalsIgnoreCase("Trompeta") ||
                    nombreInstrumento.equalsIgnoreCase("Saxofon") ||
                    nombreInstrumento.equalsIgnoreCase("Clarinete") ||
                    nombreInstrumento.equalsIgnoreCase("Flauta") ||
                    nombreInstrumento.equalsIgnoreCase("Traversa")){

                String materialDeConstruccion = regEnt.getString();
                String tipo = regEnt.getString();
                String codigo = regEnt.getString();
                int precio = regEnt.getInt();
                int stock = regEnt.getInt();

                this.instrumentosViento = Utils. append(this.instrumentosViento, new InstrumentoViento
                        (nombreInstrumento,materialDeConstruccion,tipo,codigo,precio,stock));
            }
        }
    }
}
