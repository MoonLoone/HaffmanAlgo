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

    public static int decode(Node root, int index, StringBuilder sb, StringBuilder result) {
        if (root == null) return index;
        if (root.left == null && root.right == null) {
            result.append(root.ch);
            return index;
        }
        index++;
        if (sb.charAt(index) == '0') index = decode(root.left, index, sb, result);
        else index = decode(root.right, index, sb, result);
        return index;
    }


    public static Node buildHuffmanTree(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (!freq.containsKey(text.charAt(i))) {
                freq.put(text.charAt(i), 0);
            }
            freq.put(text.charAt(i), freq.get(text.charAt(i)) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((l, r) -> l.freq - r.freq);
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        while (pq.size() != 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            int sum = left.freq + right.freq;
            pq.add(new Node('\0', sum, left, right));
        }
        Node root = pq.peek();
        return root;
    }

}
