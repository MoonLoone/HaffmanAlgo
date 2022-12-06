package huffman_algorithm_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {


    public static void encode(Node root, String str, Map<String, String> huffmanCode) {
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
        Map<String, Integer> freq = new HashMap<>();
        StringBuilder subText = new StringBuilder(text);
        if (subText.length() % 2 == 1) subText.append(" ");
        for (int i = 0; i < subText.length()-1; i = i+2) {
            if (!freq.containsKey(subText.substring(i, i+2))) {
                freq.put(subText.substring(i, i+2), 0);
            }
            freq.put(subText.substring(i, i+2), freq.get(subText.substring(i, i+2)) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((l, r) -> l.freq - r.freq);
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        while (pq.size() != 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            int sum = left.freq + right.freq;
            pq.add(new Node("\u0000", sum, left, right));
        }

        Node root = pq.peek();
        return root;
    }

}
