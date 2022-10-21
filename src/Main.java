import huffman_algorithm_elements.Huffman;
import transfer_system_elements.DataSource;

import java.util.logging.Handler;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource("Huffman coding is a data compression algorithm.");
        dataSource.encode();
        Huffman.buildHuffmanTree("Huffman coding is a data compression algorithm.");
    }
}