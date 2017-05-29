package com.hackerrank.datastructure.advanced;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Created by rajeshkumar on 25/05/17.
 */
public class MrXAndHisShots {
    public static void main(String[] args) throws IOException {
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        Node root = null;

        for (int i = 0; i < n; i++) {
            root = insert(root, new Interval(in.nextInt(), in.nextInt()));
        }

        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += overlapCount(root, new Interval(in.nextInt(), in.nextInt()));
        }
        bf.write(sum + "\n");
        bf.flush();
    }

    static int overlapCount(Node node, Interval interval) {
        int intervalCount = 0;
        if (node == null) {
            return 0;
        }
        if (node.interval.overlap(interval)) {
            intervalCount++;
        }
        if (node.left != null && node.left.max >= interval.start) {
            intervalCount += overlapCount(node.left, interval);
        }
        if (node.right != null) {
            intervalCount += overlapCount(node.right, interval);
        }
        return intervalCount;
    }

    static Node insert(Node root, Interval interval) {
        if (root == null) {
            final Node newNode = new Node();
            newNode.interval = interval;
            root = newNode;
        } else {
            Node current = root;
            if (current.interval.start < interval.start) {
                current.left = insert(current.left, interval);
            } else {
                current.right = insert(current.right, interval);
            }
        }
        root.max = root.max < interval.end ? interval.end : root.max;
        return root;
    }

    static class Node {
        Interval interval;
        int max;
        Node left;
        Node right;
    }

    static class Interval implements Comparable<Interval> {
        Integer start;
        Integer end;

        public Interval(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        boolean overlap(Interval ival) {
            return !(end < ival.start || start > ival.end);
        }


        @Override
        public int compareTo(final Interval interval) {
            if (this == interval || this.end == interval.end) {
                return 0;
            }
            if (this.end < interval.end) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}

/*
4 4
1 2
2 3
4 5
6 7
1 5
2 3
4 7
5 7

 */
