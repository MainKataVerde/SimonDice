package file;
import java.io.IOException;
import java.util.ArrayList;
import main.Persona;
/**
 * Interfaz que va a aplicar CustomReadFile
 */
public interface ICustomReadFile {
    public ArrayList<Persona> leerJugador();
    public void closeReadFile() throws IOException;
}
