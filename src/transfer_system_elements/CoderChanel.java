package transfer_system_elements;

import huffman_algorithm_elements.Huffman;
import huffman_algorithm_elements.Node;

import java.util.HashMap;
import java.util.Map;

public abstract class CoderChanel {
    public static void encodeText(String text){
       Node root = Huffman.buildHuffmanTree(text);
       Map<Character, String> huffmanCode = new HashMap<>();
       Huffman.encode(root, "", huffmanCode);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append(huffmanCode.get(text.charAt(i)));
        }

       TransferChanel.transferEncodeText(huffmanCode, sb, root);
    }
}
