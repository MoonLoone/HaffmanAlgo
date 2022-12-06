package transfer_system_elements;

import huffman_algorithm_elements.Huffman;
import huffman_algorithm_elements.Node;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public abstract class CoderChanel {
    public static void encodeText(String text, Path pathResult, double P, String textForEncode){
       Node root = Huffman.buildHuffmanTree(text);
       Map<String, String> huffmanCode = new HashMap<>();
       Huffman.encode(root, "", huffmanCode);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length()-2; i = i+2) {
            sb.append(huffmanCode.get(text.substring(i,i+2)));
        }
       TransferChanel.transferEncodeText(huffmanCode, sb, root, pathResult, P, textForEncode);
    }
}
