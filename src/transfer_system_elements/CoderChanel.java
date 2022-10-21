package transfer_system_elements;

import huffman_algorithm_elements.Huffman;

public abstract class CoderChanel {
    public static void encodeText(String text){
        Huffman.buildHuffmanTree(text);
        TransferChanel.transferEncodeText();
    }
}
