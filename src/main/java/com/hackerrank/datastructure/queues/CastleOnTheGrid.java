package com.hackerrank.datastructure.queues;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by rajeshkumar on 12/05/17.
 */
public class CastleOnTheGrid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] board = new int[n][n];

        IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> board[i][j] = in.nextInt()));

        Node root = new Node(board[0][0]);
        Node current = root;
        for (int i = 0; i < board.length; i++) {
            current = current != null ? current.left : new Node(board[i][0]);
            for (int j = 1; j < board[i].length; j++) {
                if (!(i == 0 && j == 0)) {
                    setNode(board, current, i, j);
                }
            }
        }

        //Point start = new Point(in.nextInt(), in.nextInt());
        //Point end = new Point(in.nextInt(), in.nextInt());

    }

    private static boolean setNode(final int[][] board, final Node current, final int i, final int j) {
        if (current.right == null) {
            current.right = new Node(board[i][j]);
        } else if (current.left == null) {
            current.left = new Node(board[i][j]);
        } else {
            if (setNode(board, current.right, i, j)) {
                return true;
            } else {
                return setNode(board, current.left, i, j);
            }
        }
        return true;
    }

    static class Point {
        int x;
        int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
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
3
.
X
.
.
X
.
.
.
.
0
0
0
2
 */
