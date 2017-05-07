package com.hackerrank.datastructure.tree;

/**
 * Created by rajeshkumar on 07/05/17.
 */
public class BSTExample {

    public static void main(String[] args) {
        Node root = new Node(8);
        Insert(root, 4);
        Insert(root, 9);
        Insert(root, 1);
        Insert(root, 2);
        Insert(root, 3);
        Insert(root, 6);
        Insert(root, 5);
        System.out.println(lca(root, 1, 2));
    }

    static Node lca(Node root, int v1, int v2) {
        Node current = root;
        while (true) {
            if ((current.data > v1 && current.data > v2)) {
                current = current.left;
            } else if (current.data < v1 && current.data < v2) {
                current = current.right;
            } else {
                return current;
            }
        }
    }

    static Node Insert(Node root, int value) {
        if (root == null) {
            final Node newNode = new Node(value);
            return newNode;
        }
        Node current = root;
        if (current.data >= value) {
            current.left = Insert(current.left, value);
        } else {
            current.right = Insert(current.right, value);
        }
        return root;
    }

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        System.out.print(root.data + " ");
        preOrder(root.right);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(final int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + '}';
        }
    }
}
