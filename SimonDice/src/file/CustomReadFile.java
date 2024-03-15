package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import main.Persona;

public class CustomReadFile extends FileReader implements ICustomReadFile{
    Scanner sc ;

    public CustomReadFile(String _file) throws FileNotFoundException {
        super(_file);
        sc = new Scanner(this);
    }
    
    public void closeReadFile() throws IOException{
        this.close();
    }

    public ArrayList<Persona> leerJugador(){
        ArrayList<Persona> jugadores = new ArrayList<Persona>();
        while (this.sc.hasNextLine()) {
            int puntos = this.sc.nextInt();
            String nombre = this.sc.next();
            Persona jugador = new Persona(nombre, puntos);
            jugadores.add(jugador);
            this.sc.nextLine();
        }
        return jugadores;
    }
}