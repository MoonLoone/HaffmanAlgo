package huffman_algorithm_elements;

public class Node {
    String ch;
    int freq;
    Node left = null, right = null;

    public String getCh() {
        return ch;
    }

    public int getFreq() {
        return freq;
    }

    Node(String ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
    public Node(String ch, int freq, Node left, Node right) {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
};

