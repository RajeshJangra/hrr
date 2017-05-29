package com.hackerrank.datastructure.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by rajeshkumar on 29/05/17.
 */
public class SampleTrie {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Trie trie = new Trie();
        int n = in.nextInt();
        int q = in.nextInt();

        for (int i = 0; i < n; i++) {
            trie.insert(in.next(), in.nextInt());
        }

        for (int i = 0; i < q; i++) {
            System.out.println(trie.findWeight(in.next()));
        }
    }

    static class Trie {
        Node root = new Node();

        public Node insert(String string, int weight) {
            Node current = root;
            for (char charVal : string.toCharArray()) {
                if (!current.children.containsKey(charVal)) {
                    final Node node = new Node();
                    current.children.put(charVal, node);
                }
                current = current.children.get(charVal);
                current.weight = current.weight > weight ? current.weight : weight;
            }
            return root;
        }

        public int findWeight(String string) {
            Node current = root;
            for (char charVal : string.toCharArray()) {
                final Node node = current.children.get(charVal);
                if (node != null) {
                    current = node;
                } else {
                    return -1;
                }
            }
            return current.weight;
        }
    }

    static class Node {
        int weight;
        Map<Character, Node> children = new HashMap();
    }
}
