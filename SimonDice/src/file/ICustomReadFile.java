package file;
import java.io.IOException;
import java.util.ArrayList;
import main.Persona;

public interface ICustomReadFile {
    public ArrayList<Persona> leerJugador();
    public void closeReadFile() throws IOException;
}
