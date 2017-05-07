package com.hackerrank.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by rajeshkumar on 07/05/17.
 */
public class SwapNodesAlgo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfNodes = in.nextInt();
        Node root = new Node(1, 1);
        Node currentNode = root;
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(currentNode);
        while (noOfNodes > 0) {
            currentNode = nodeQueue.poll();
            int lVal = in.nextInt();
            int rVal = in.nextInt();
            currentNode.left = (lVal != -1) ? new Node(lVal, currentNode.depth + 1) : null;
            currentNode.right = (rVal != -1) ? new Node(rVal, currentNode.depth + 1) : null;
            if (lVal != -1) {
                nodeQueue.offer(currentNode.left);
            }
            if (rVal != -1) {
                nodeQueue.offer(currentNode.right);
            }
            noOfNodes--;
        }

        int swaps = in.nextInt();
        for (int i = 0; i < swaps; i++) {
            swap(root, in.nextInt());
            inOrder(root);
            System.out.println();
        }
    }

    public static void swap(Node currentNode, int swapLevel) {
        if (currentNode == null) {
            return;
        }
        if (currentNode.depth % swapLevel == 0) {
            Node temp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = temp;
        }
        swap(currentNode.left, swapLevel);
        swap(currentNode.right, swapLevel);
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
        int depth;
        Node left;
        Node right;

        public Node(final int data, final int depth) {
            this.data = data;
            this.depth = depth;
        }
    }
}

/*
3
2
3
-1
-1
-1
-1
2
1
1
 */

/*
17
2
3
4
5
6
-1
-1
7
8
9
10
11
12
13
-1
14
-1
-1
15
-1
16
17
-1
-1
-1
-1
-1
-1
-1
-1
-1
-1
-1
-1
2
2
3
 */

/*

11
2
3
4
-1
5
-1
6
-1
7
8
-1
9
-1
-1
10
11
-1
-1
-1
-1
-1
-1
2
2
4

 */
