package file;

import java.io.IOException;
/**
 * Interfaz para que va a implementar CustomWriterFile
 */
public interface ICustomWriteFile {
   public void closeWriteFile() throws IOException;
   public void escribirJugador(String _textJugadores) throws IOException;
}
