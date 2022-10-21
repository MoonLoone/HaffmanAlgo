package transfer_system_elements;

import huffman_algorithm_elements.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class TransferChanel {

    public static void transferEncodeText(Map<Character, String> huffmanCode, StringBuilder encodedText, Node root){
        System.out.println("Huffman Codes are :");
        for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        int size = 0;
        for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
            size += entry.getValue().length();
        }
        double averageBinaryCode = (double)size / huffmanCode.size();

        System.out.println("\nBinary symbols count: "+encodedText.length());
        long ones = encodedText.chars().filter(ch -> ch == '1').count();
        long zeros = encodedText.chars().filter(ch -> ch == '0').count();
        System.out.println("Zeros count: "+zeros+" Ones count: "+ones);
        System.out.println("Average binary code: "+averageBinaryCode+"\n");
        DecoderChanel.decodeText(encodedText, root);
    }

}
