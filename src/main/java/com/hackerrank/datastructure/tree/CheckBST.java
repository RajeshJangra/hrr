package com.hackerrank.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajeshkumar on 08/05/17.
 */
public class CheckBST {
    public static void main(String[] args) {
        Node root = new Node(1);
        Insert(root, 2);
        Insert(root, 3);
        Insert(root, 4);
        Insert(root, 5);
        Insert(root, 6);
        Insert(root, 7);
        final ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
/*        int prev = 0;
        for (int val : list) {
            if (prev == 0 || prev < val) {
                prev = val;
            } else{
                return false;
            }
        }
        return true;*/
    }

    static boolean checkBST(Node root) {
        if (root != null) {
            return checkBST(root, root.data, root.data);
        }
        return true;
    }

    static boolean checkBST(Node root, int min, int max) {
        boolean binaryTree = true;

        if (root.left != null) {
            binaryTree = min > root.left.data ? checkBST(root.left, root.left.data, min) : false;
        }
        if (binaryTree && root.right != null) {
            binaryTree = max < root.right.data ? checkBST(root.right, max, root.right.data) : false;
        }
        return binaryTree;
    }

    static void inOrder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
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
