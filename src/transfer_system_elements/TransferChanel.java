package transfer_system_elements;

import huffman_algorithm_elements.Node;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class TransferChanel {

    public static void transferEncodeText(Map<Character, String> huffmanCode, StringBuilder encodedText, Node root, Path pathResult){

        StringBuilder huffmanCodes = new StringBuilder();
        for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
            huffmanCodes.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        int size = 0;
        for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
            size += entry.getValue().length();
        }
        double averageBinaryCode = (double)size / huffmanCode.size();

        long ones = encodedText.chars().filter(ch -> ch == '1').count();
        long zeros = encodedText.chars().filter(ch -> ch == '0').count();

        try {
            FileWriter writer = new FileWriter(pathResult.toString(),true);
            writer.write("Huffman Codes are : \n"+ huffmanCodes+"\n");
            writer.append("\nBinary symbols count: ").append(String.valueOf(encodedText.length())).append("\n");
            writer.append("Zeros count: ").append(String.valueOf(zeros)).append(" Ones count: ").append(String.valueOf(ones)).append("\n");
            writer.append("Average binary code: ").append(String.valueOf(averageBinaryCode)).append("\n").append("\n");
            writer.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        DecoderChanel.decodeText(encodedText, root, pathResult);
    }
}
