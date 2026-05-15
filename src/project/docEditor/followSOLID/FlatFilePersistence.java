package project.docEditor.followSOLID;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FlatFilePersistence implements PersistenceManager{
    public void save(String data)  {
        Path file = Path.of("doc.txt");
        try {
            Files.writeString(file, data);
        }catch (IOException e){
            System.out.println("Error while saving to file "+e.getMessage());
        }
    }
}
