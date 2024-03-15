package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CustomWriteFile extends FileWriter implements ICustomWriteFile{
    public CustomWriteFile (String _filename) throws IOException{
        super(_filename);
    }

    public void closeWhiteFile() throws IOException{
            this.close();
        
    }

    public void escribirJugador(String _textJugadores) throws IOException{
        this.write(_textJugadores);
    }
}
