package transfer_system_elements;

import huffman_algorithm_elements.Huffman;
import huffman_algorithm_elements.Node;

import javax.xml.crypto.Data;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public abstract class DecoderChanel {
    public static void decodeText(StringBuilder sb, Node root, Path path, String textForEncode){
        StringBuilder decodedText = new StringBuilder();
        FileWriter writer = null;
        Path encodedTextPath = Path.of("encoded.txt");
        try {
            Files.delete(encodedTextPath);
            Files.createFile(encodedTextPath);
            writer = new FileWriter(encodedTextPath.toString(),true);
            writer.append(""+sb.toString()+ "\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int index = -1;
        while (index < sb.length() - 4) {
            index = Huffman.decode(root, index, sb, decodedText);
        }
        DestinationData.showResults(decodedText.toString(), path, textForEncode);
    }
}
