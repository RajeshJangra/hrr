package com.hackerrank.datastructure.advanced;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 22/05/17.
 */
public class KindergartenAdventures {
    public static void main(String[] args) {
        int OFFSET = 200000;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] times = new int[n];
        for (int i = 0; i < n; ++i) {
            times[i] = in.nextInt();
        }

        BinaryIndexedTree tree = new BinaryIndexedTree(2 * OFFSET);
        for (int i = 0; i < n; ++i) {
            tree.update(OFFSET + times[i] - i, 1);
        }

        int maxCount = tree.read(OFFSET);
        int result = 1;

        for (int i = 1; i < n; ++i) {
            tree.update(OFFSET + times[i - 1], -1);
            if (OFFSET + times[i - 1] - (n - 1) - i <= 0) {
                throw new RuntimeException("BAD");
            }
            tree.update(OFFSET + times[i - 1] - (n - 1) - i, 1);
            int temp = tree.read(OFFSET - i);
            if (maxCount < temp) {
                maxCount = temp;
                result = i + 1;
            }
        }
        System.out.println(result);
    }

    static class BinaryIndexedTree {
        private int size;
        private int[] bit;

        public BinaryIndexedTree(int size) {
            this.size = size;
            bit = new int[size + 1];
        }

        public int read(int index) {
            int result = 0;
            while (index > 0) {
                result += bit[index];
                index -= (index & -index);
            }
            return result;
        }

        public void update(int index, int value) {
            while (index <= size) {
                bit[index] += value;
                index += (index & -index);
            }
        }
    }
}

/*

3
1
0
0

 */
