package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 26/04/17.
 */
public class MagicSquareForming {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for (int s_i = 0; s_i < 3; s_i++) {
            for (int s_j = 0; s_j < 3; s_j++) {
                s[s_i][s_j] = in.nextInt();
            }
        }
        int minimumCost = findSmallest(s);
        System.out.println(minimumCost);
    }

    private static int findSmallest(final int[][] s) {
        int[][][] sArray3d = {{{8, 1, 6}, {3, 5, 7}, {4, 9, 2}}, {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}}, {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}}, {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}}, {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}}, {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}, {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}}, {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}}};

        int smallestTotal = Integer.MAX_VALUE;
        for (int[][] sArr2d : sArray3d) {
            int total = 0;
            for (int extCounter = 0; extCounter < sArr2d.length; extCounter++) {
                for (int intCounter = 0; intCounter < sArr2d.length; intCounter++) {
                    int difference = Math.abs(sArr2d[extCounter][intCounter] - s[extCounter][intCounter]);
                    total = total + difference;
                }
            }
            smallestTotal = total < smallestTotal ? total : smallestTotal;
        }
        return smallestTotal;
    }
}
