package com.hackerrank.datastructure.balancedtress;

/**
 * Created by rajeshkumar on 20/05/17.
 */
public class SelfBalancedTrees {
    public static void main(String[] args) {

    }

    static Node insert(Node node, int key) {
        if (node == null) {
            Node newNode = new Node();
            newNode.val = key;
            newNode.ht = 0;
            return newNode;
        }
        if (key < node.val) {
            node.left = insert(node.left, key);
        } else if (key > node.val) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }

        node.ht = height(node.left) > height(node.right) ? height(node.left) + 1 : height(node.right) + 1;

        return rotateIfUnbalanced(node, key);
    }

    private static Node rotateIfUnbalanced(final Node node, final int key) {
        final int balance = getBalance(node);

        if (balance > 1 && key < node.left.val) {
            return rotateRight(node);
        }

        if (balance < -1 && key > node.right.val) {
            return rotateLeft(node);
        }

        if (balance > 1 && key > node.left.val) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && key < node.right.val) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    static Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.ht = height(y.left) > height(y.right) ? height(y.left) + 1 : height(y.right) + 1;
        x.ht = height(x.left) > height(x.right) ? height(x.left) + 1 : height(x.right) + 1;
        return x;
    }

    static Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.ht = height(x.left) > height(x.right) ? height(x.left) + 1 : height(x.right) + 1;
        y.ht = height(y.left) > height(y.right) ? height(y.left) + 1 : height(y.right) + 1;

        return y;
    }

    static int getBalance(Node node) {
        return node != null ? height(node.left) - height(node.right) : 0;
    }

    static int height(Node node) {
        return node != null ? node.ht : -1;
    }

    static class Node {
        int val;   //Value
        int ht;      //Height
        Node left;   //Left child
        Node right;   //Right child
    }

}
