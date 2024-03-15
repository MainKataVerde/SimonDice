package main;


import java.io.IOException;
import java.util.ArrayList;
import file.CustomReadFile;
import file.CustomWriteFile;

/**
 * @author Oscar Nzabarinda Mukeshimana
 */
public class Record {
    final int MAX_JUGADORES = 20;
    private Persona arryjugadores[];
    private int contador;

    public Record() {
        this.arryjugadores = new Persona[this.MAX_JUGADORES];
        this.contador = 0 ;
    }

    /**
     * Metodo en el que se añade el jugaor a la array de jugadores
     * 0(1)
     * @param jugador Jugador que queremos añadir
     */
    public void añadirJugador(Persona jugador) {
        if (this.contador < this.MAX_JUGADORES) {
            this.arryjugadores[contador] = jugador;
            this.contador++;   
        }else{
            this.arryjugadores[this.contador -1] = jugador;
        }
    }

    /**
     * Metodo que nos muestra el ranking ordenado del mejor al peor respecto a los
     * puntos
     * 0(n)
     * @throws IOException
     */
    public void showRanking() throws IOException {
        System.out.println("Jugadores : ");

        for (int i = 0; i < this.contador; i++) {
            System.out.println(this.arryjugadores[i].getPuntuacion() + " " + this.arryjugadores[i].getNombre());
        }
    }

    /**
     * Este metodo nos muestra el mejor o la mejor jugadora , si hay mas de uno con
     * la puntuacion igual y
     * que sean los que mas tienen los mostrara a los dos o mas que cumplan esta
     * condicion
     * 0(n)
     * @throws IOException
     */

    public void showBestRanking() throws IOException {
        System.out.println("Mejor(es) jugador(es) : ");
        int i = 0;
        while (this.arryjugadores[i].getPuntuacion() == this.arryjugadores[0].getPuntuacion() && i <= this.contador) {
            System.out.println(this.arryjugadores[i].getPuntuacion() + " " + this.arryjugadores[i].getNombre());
            i++;
        }
    }
    /**
     * Metodo que nos carga los jugadores en la array desde el fichero 
     * @param _fichero String con la direccion del fichero a leer
     * @throws IOException
     */
    public void cargarJugador(String _fichero) throws IOException{
        CustomReadFile read = new CustomReadFile(_fichero);

        ArrayList<Persona> jugadores = read.leerJugador();

        int i = 0 ; 

        while (i < jugadores.size() && i < this.MAX_JUGADORES) {
            añadirJugador(jugadores.get(i));
            i++;
        }

        read.closeReadFile();
    }
    /**
     * Metodo que nos escribe los jugadores en la array, en este mismo metodo tambien nos monta 
     * el string de jugadores
     * @param _fichero String donde esta la direccion del archivo
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    public void escribirJugador(String _fichero) throws IOException, CloneNotSupportedException{
        CustomWriteFile write = new CustomWriteFile(_fichero);
        String jugadores = "";

        for (int i = 0; i < this.contador; i++) {
            jugadores += arryjugadores[i].getPuntuacion() + " " + arryjugadores[i].getNombre() + "\n";
        }

        write.escribirJugador(jugadores);

        write.closeWriteFile();

    }

    /**
     * Metodo que utiliza un algoritmo de ordenacion (El algoritmo de la burbuja)
     * para ordenar de mayor
     * a menos los jugadores
     * 0(n²)
     */
    public void ordenarJugadores() {
        for (int i = 0; i < this.contador; i++) {
            for (int j = 0; j < (this.contador - i - 1); j++) {
                if (this.arryjugadores[j].getPuntuacion() < this.arryjugadores[j + 1].getPuntuacion()) {
                    Persona temp = this.arryjugadores[j + 1];
                    this.arryjugadores[j + 1] = this.arryjugadores[j];
                    this.arryjugadores[j] = temp;
                }
            }
        }
    }
    /**
     * Metodo en el que buscamos un jugador en la array de jugadores y lo devolvemos
     * 0(n)
     * @param _jugador Jugador que queremos buscar
     * @return
     */

    public Persona getPlayer(String _nombreJugador){
        int i = 0 ;
        Persona jugador = null;
        while(!(_nombreJugador.equals(this.arryjugadores[i].getNombre()))&& i < this.contador) {
            if (_nombreJugador.equals(this.arryjugadores[i].getNombre())) {
                jugador = this.arryjugadores[i];                
            }else{
                i++;
            }
        }
        return jugador;
    }
}
