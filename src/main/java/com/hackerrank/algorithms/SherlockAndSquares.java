package com.hackerrank.algorithms;

import java.util.Scanner;

import static java.lang.StrictMath.sqrt;

/**
 * Created by rajeshkumar on 28/04/17.
 */
public class SherlockAndSquares {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = in.nextInt();
            }
        }
        int[] squares = findSquares(c);
        for (int square : squares) {
            System.out.println(square);
        }
    }

    private static int[] findSquares(final int[][] c) {
        int[] squares = new int[c.length];
        for (int counter = 0; counter < c.length; counter++) {
            int bigger = c[counter][0] > c[counter][1] ? c[counter][0] : c[counter][1];
            int smaller = c[counter][0] < c[counter][1] ? c[counter][0] : c[counter][1];
            for (int i = (int) sqrt(smaller); i <= (int) sqrt(bigger); i++) {
                if (i * i >= smaller && i * i <= bigger) {
                    squares[counter]++;
                }
            }
        }
        return squares;
    }
}
