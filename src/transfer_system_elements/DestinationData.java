package transfer_system_elements;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public abstract class DestinationData {

    public static void showResults(String decodedText, Path path){
        try {
            FileWriter writer = new FileWriter(path.toString(),true);
            writer.append("\nDecoded text is: \n"+decodedText+ "\n");
            writer.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
