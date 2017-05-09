package com.hackerrank.datastructure.tree;

import java.util.*;

/**
 * Created by rajeshkumar on 05/05/17.
 */
public class BinaryTreeExample {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.left = new Node(6);

        LevelOrderQueue(root);

    }

/*    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }*/

    static void LevelOrderQueue(Node root) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            final Node current = nodeQueue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) {
                nodeQueue.add(current.left);
            }
            if (current.right != null) {
                nodeQueue.add(current.right);
            }
        }
    }

    static void LevelOrderRecursive(Node root) {
        final int height = height(root);
        for (int currentHeight = 0; currentHeight < height + 1; currentHeight++) {
            printGivenLevel(root, currentHeight);
        }
    }

    private static void printGivenLevel(final Node root, final int currentHeight) {
        if (root == null) {
            return;
        }
        if (currentHeight == 0) {
            System.out.print(root.data + " ");
        } else {
            printGivenLevel(root.left, currentHeight - 1);
            printGivenLevel(root.right, currentHeight - 1);
        }
    }

    static void topView(Node root) {
        if (root == null) {
            return;
        }
        List<Integer> arrRight = new ArrayList();
        List<Integer> arrLeft = new ArrayList();
        Node left = root.left;
        while (left != null) {
            arrLeft.add(left.data);
            left = left.left;
        }
        Collections.reverse(arrLeft);
        arrLeft.add(root.data);

        Node right = root.right;
        while (right != null) {
            arrRight.add(right.data);
            right = right.right;
        }

        arrLeft.addAll(arrRight);

        for (int val : arrLeft) {
            System.out.print(val + " ");
        }

    }

    static int height(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        final int left = height(root.left);
        final int right = height(root.right);
        return left > right ? left + 1 : right + 1;
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(final int data) {
            this.data = data;
        }
    }
}

/*
1
2
3
4
5
6
7
 */
