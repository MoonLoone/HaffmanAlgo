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

    public static void transferEncodeText(Map<String, String> huffmanCode, StringBuilder encodedText,
                                          Node root, Path pathResult, double P, String textForEncode){

        StringBuilder huffmanCodes = new StringBuilder();
        for (Map.Entry<String, String> entry : huffmanCode.entrySet()) {
            huffmanCodes.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        for (int i=0;i<encodedText.length();i++){
            if (Math.random() <= P){
                switch (encodedText.charAt(i)) {
                    case '1' -> {
                        encodedText.replace(i, i+1, "0");
                    }
                    case '0' -> encodedText.replace(i, i+1, "1");
                }

            }
        }

        int size = 0;
        for (Map.Entry<String, String> entry : huffmanCode.entrySet()) {
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

        DecoderChanel.decodeText(encodedText, root, pathResult, textForEncode);
    }
}
