package file;

import java.io.IOException;

public interface ICustomWriteFile {
   public void closeWhiteFile() throws IOException;
   public void escribirJugador(String _textJugadores) throws IOException;
}
