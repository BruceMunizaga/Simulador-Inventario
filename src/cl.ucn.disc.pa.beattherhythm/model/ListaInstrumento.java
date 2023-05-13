package cl.ucn.disc.pa.beattherhythm.model;

public class ListaInstrumento {

    private int cantidadActual = 0;

    private int cantidadMaxima;




    public ListaInstrumento(int cantidadMaxima){
        if (cantidadMaxima <= 0){
            throw new IllegalArgumentException("Ingrese una capacidad maxima valida");
        }
        this.cantidadMaxima = cantidadMaxima;


    }

    public int getCantidadActual(){
        return this.cantidadActual;
    }

    public int getCantidadMaxima(){
        return this.cantidadMaxima;
    }


}



