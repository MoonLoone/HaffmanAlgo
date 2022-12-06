package transfer_system_elements;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public abstract class DestinationData {

    public static void showResults(String decodedText, Path path, String startText){

        int matches = 0;
        int minLength = Math.min(startText.length(), decodedText.length());
        for (int i = 0; i<minLength;i++){
            if (decodedText.charAt(i) == startText.charAt(i)) matches++;
        }

        Path encodedTextPath = Path.of("decoded.txt");
        try {
            Files.delete(encodedTextPath);
            Files.createFile(encodedTextPath);
            FileWriter writer = new FileWriter(encodedTextPath.toString(),true);
            writer.append(""+decodedText+ "\n");
            writer.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
