package huffman_algorithm_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {

    private Map<Character, String> savedHuffman = new HashMap<>();

    public static void encode(Node root, String str, Map<Character, String> huffmanCode) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            huffmanCode.put(root.ch, str);
        }
        encode(root.left, str + "0", huffmanCode);
        encode(root.right, str + "1", huffmanCode);
    }

    public static int decode(Node root, int index, StringBuilder sb) {
        if (root == null) return index;

        // found a leaf node
        if (root.left == null && root.right == null) {
            System.out.print(root.ch);
            return index;
        }

        index++;

        if (sb.charAt(index) == '0') index = decode(root.left, index, sb);
        else index = decode(root.right, index, sb);

        return index;
    }


    public static void buildHuffmanTree(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (!freq.containsKey(text.charAt(i))) {
                freq.put(text.charAt(i), 0);
            }
            freq.put(text.charAt(i), freq.get(text.charAt(i)) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((l, r) -> l.freq - r.freq);

        // Create a leaf node for each character and add it
        // to the priority queue.
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        // do till there is more than one node in the queue
        while (pq.size() != 1) {
            // Remove the two nodes of highest priority
            // (lowest frequency) from the queue
            Node left = pq.poll();
            Node right = pq.poll();

            // Create a new internal node with these two nodes as children
            // and with frequency equal to the sum of the two nodes
            // frequencies. Add the new node to the priority queue.
            int sum = left.freq + right.freq;
            pq.add(new Node('\0', sum, left, right));
        }

        // root stores pointer to root of Huffman Tree
        Node root = pq.peek();

        // traverse the Huffman tree and store the Huffman codes in a map
        Map<Character, String> huffmanCode = new HashMap<>();
        encode(root, "", huffmanCode);

        // print the Huffman codes
        System.out.println("Huffman Codes are :\n");
        for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("\nOriginal string was :\n" + text);

        // print encoded string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append(huffmanCode.get(text.charAt(i)));
        }

        System.out.println("\nEncoded string is :\n" + sb);

        // traverse the Huffman Tree again and this time
        // decode the encoded string
        int index = -1;
        System.out.println("\nDecoded string is: \n");
        while (index < sb.length() - 2) {
            index = decode(root, index, sb);
        }
    }

}
