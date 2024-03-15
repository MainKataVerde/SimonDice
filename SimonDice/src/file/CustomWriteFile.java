package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CustomWriteFile extends FileWriter implements ICustomWriteFile{
    /**
     * Constructora que hereda de FileWriter
     * @param _filename String en el que pone la direccion del archivo
     * @throws IOException
     */
    public CustomWriteFile (String _filename) throws IOException{
        super(_filename);
    }

    /**
     * Metodo que cierra el flujo de escritura
     * @throws IOException
     */
    public void closeWriteFile() throws IOException{
            this.close();
    }

    /**
     * Metodo que escribe un string previamente montado en nuestro fichero
     * @param _textJugadores String montado de jugadores listo para solo escribirlo dentro del
     * fichero
     * @throws IOException
     */

    public void escribirJugador(String _textJugadores) throws IOException{
        this.write(_textJugadores);
    }
}
