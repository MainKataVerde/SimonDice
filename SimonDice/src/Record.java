import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Record {
    final int MAX_JUGADORES = 20 ;
    private Persona arryjugadores [] ;
    private int contador = 0 ; 

    public Record(){
        this.arryjugadores = new Persona[MAX_JUGADORES];
    }

    public void añadirJugador(Persona jugador){
        this.arryjugadores[contador] = jugador;
       // System.out.println("Añadimos al jugador : "+this.arryjugadores[contador].getNombre());
        this.contador++;
    }
    //CAMBIAR USANDO LA LECTURA DE ARCHIVOS
    public void showRanking(){
        ordenarJugadores();
        System.out.println("Jugadores : ");
        for (int i = 0; i < this.contador ; i++) {
            System.out.println(this.arryjugadores[i].getPuntuacion() + " " + this.arryjugadores[i].getNombre());
        }
    }
    //CAMBIAR CON LA LECTURA DE ARCHIVOS
    public void showBestRanking(){
        ordenarJugadores();
        int i = 0 ; 

        while (this.arryjugadores[i].getPuntuacion() == this.arryjugadores[0].getPuntuacion() && i <= contador) {
            System.out.println(this.arryjugadores[i].getPuntuacion() + " " + this.arryjugadores[i].getNombre());
            i++;
        }
    }

    public void ordenarJugadores (){
        for (int i = 0; i < this.contador; i++) {
            for (int j = 0; j < (this.contador - i -1) ; j++) {
                if (this.arryjugadores[j].getPuntuacion() < this.arryjugadores[ j + 1 ].getPuntuacion()) {
                    Persona temp = this.arryjugadores[ j + 1 ];
                    this.arryjugadores[j + 1] = this.arryjugadores[j];
                    this.arryjugadores[j] = temp;
                }
            }
        }
    }
    //escrbir en el fichero el ranking
    public void escribirRanking() throws IOException{
        try {
            FileWriter file = new FileWriter("./SimonDice/data/jugadores.txt");
            for (int i = 0; i < this.contador ; i++) {
               String jugadores =  this.arryjugadores[i].getPuntuacion() + " " + this.arryjugadores[i].getNombre() + "\n";
               file.write(jugadores);
            }
            file.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //leer el fichero del ranking
    public void cargarRanking() throws IOException{
        FileReader file = new FileReader("./SimonDice/data/jugadores.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

        file.close();
        sc.close();
    }
}
