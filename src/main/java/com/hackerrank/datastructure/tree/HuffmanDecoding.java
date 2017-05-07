package com.hackerrank.datastructure.tree;

/**
 * Created by rajeshkumar on 07/05/17.
 */
public class HuffmanDecoding {
    final static char PHI = '\u03d5';

    public static void main(String[] args) {
        Node root = new Node(PHI, 5);
        root.left = new Node(PHI, 2);
        root.right = new Node('A', 3);
        root.left.left = new Node('B', 1);
        root.left.right = new Node('C', 1);

        decode(root, "1001011");
    }

    static void decode(Node root, String S) {
        char[] source = S.toCharArray();
        Node current = root;

        for (int counter = 0; counter < source.length; counter++) {
            current = S.charAt(counter) == '0' ? current.left : current.right;
            if (current.left == null && current.right == null) {
                System.out.print(current.data);
                current = root;
            }
        }
    }

    static class Node {
        int freq;
        char data;
        Node left;
        Node right;

        public Node(final char data, final int freq) {
            this.freq = freq;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" + "freq=" + freq + ", data=" + data + '}';
        }
    }
}
