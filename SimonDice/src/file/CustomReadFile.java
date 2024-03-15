package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import main.Persona;

public class CustomReadFile extends FileReader implements ICustomReadFile {
    Scanner sc;

    /**
     * Constuctora que utiliza la herecia de la constuctora de FileReader
     * en esta misma inicializadmos el scanner para que cargue el archivo
     * 
     * @param _file
     * @throws FileNotFoundException
     */
    public CustomReadFile(String _file) throws FileNotFoundException {
        super(_file);
        sc = new Scanner(this);
    }

    /**
     * Metodo para cerrar el el archivo que se esta leyendo
     */
    public void closeReadFile() throws IOException {
        this.close();
    }

    /**
     * Metodo para leer los jugadores del fichero en el que almacenamos en un
     * ArrayList
     * 
     * @return ArrayList de jugadores que estaban en el fichero
     */
    public ArrayList<Persona> leerJugador() {
        ArrayList<Persona> jugadores = new ArrayList<Persona>();
        while (this.sc.hasNextLine()) {
            try {
                int puntos = this.sc.nextInt();
                String nombre = this.sc.next();
                Persona jugador = new Persona(nombre, puntos);
                jugadores.add(jugador);
                this.sc.nextLine();
            } catch (NoSuchElementException e) {
                System.err.println(e);
            }
        }
        return jugadores;
    }
}