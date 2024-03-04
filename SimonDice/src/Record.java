import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Oscar Nzabarinda Mukeshimana
 */
public class Record {
    final int MAX_JUGADORES = 20;
    private Persona arryjugadores[];
    private int contador = 0;

    public Record() {
        this.arryjugadores = new Persona[MAX_JUGADORES];
    }

    /**
     * Metodo en el que se añade el jugaor a la array de jugadores
     * 0(1)
     * @param jugador Jugador que queremos añadir
     */
    public void añadirJugador(Persona jugador) {
        this.arryjugadores[contador] = jugador;
        this.contador++;
    }

    /**
     * Metodo que nos muestra el ranking ordenado del mejor al peor respecto a los
     * puntos
     * 0(n)
     * @throws IOException
     */
    public void showRanking() throws IOException {
        ordenarJugadores();
        //escribirRanking();
        System.out.println("Jugadores : ");

        for (int i = 0; i < this.contador; i++) {
            System.out.println(this.arryjugadores[i].getPuntuacion() + " " + this.arryjugadores[i].getNombre());
        }

        //cargarRanking();
    }

    /**
     * Este metodo nos muestra el mejor o la mejor jugadora , si hay mas de uno con
     * la puntuacion igual y
     * que sean los que mas tienen los mostrara a los dos o mas que cumplan esta
     * condicion
     * 0(n)
     * @throws IOException
     */
    //cambiar esto
    public void showBestRanking() throws IOException {
        ordenarJugadores();
        System.out.println("Mejor(es) jugador(es) : ");
        int i = 0;
        while (this.arryjugadores[i].getPuntuacion() == this.arryjugadores[0].getPuntuacion() && i <= this.contador) {
            System.out.println(this.arryjugadores[i].getPuntuacion() + " " + this.arryjugadores[i].getNombre());
            i++;
        }

        /*escribirRanking();
        FileReader file = new FileReader("./SimonDice/data/jugadores.txt");
        Scanner sc = new Scanner(file);
        int i = 0;
        System.out.println("El(la)/los mejores  : ");
        while (this.arryjugadores[i].getPuntuacion() == this.arryjugadores[0].getPuntuacion() && i <= this.contador) {
            System.out.println(sc.nextLine());
            i++;
        }
        file.close();
        sc.close();*/
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

/* 
    public void escribirRanking() throws IOException {
        ordenarJugadores();
        try {
            FileWriter file = new FileWriter("./SimonDice/data/jugadores.txt");
            for (int i = 0; i < this.contador; i++) {
                String jugadores = this.arryjugadores[i].getPuntuacion() + " " + this.arryjugadores[i].getNombre()
                        + "\n";
                file.write(jugadores);
            }
            file.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
*/
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
/* 

    public void cargarRanking() throws IOException {
        ordenarJugadores();
        try {
            FileReader file = new FileReader("./SimonDice/data/jugadores.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

            file.close();
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
*/
}
