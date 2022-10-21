package transfer_system_elements;

import huffman_algorithm_elements.Huffman;
import huffman_algorithm_elements.Node;

import javax.xml.crypto.Data;
import java.util.Map;

public abstract class DecoderChanel {

    public static void decodeText(StringBuilder sb, Node root){
        StringBuilder decodedText = new StringBuilder();
        System.out.println("Encoded text is: \n"+sb.toString()+ "\n");

        int index = -1;
        while (index < sb.length() - 2) {
            index = Huffman.decode(root, index, sb, decodedText);
        }
        DestinationData.showResults(decodedText.toString());
    }
}
