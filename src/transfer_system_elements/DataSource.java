package transfer_system_elements;

import huffman_algorithm_elements.Huffman;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class DataSource {
    public DataSource(String textForEncode, Path pathResult, double P){
        try {
            Files.writeString(pathResult,"Source text is: \n"+ textForEncode + "\n", StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CoderChanel.encodeText(textForEncode, pathResult, P, textForEncode);
    }
}
