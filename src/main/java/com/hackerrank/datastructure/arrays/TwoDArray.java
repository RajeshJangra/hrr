package com.hackerrank.datastructure.arrays;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 29/04/17.
 */
public class TwoDArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] array = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                array[i][j] = in.nextInt();
            }
        }

        int sum = findHourglassSum(array);
        System.out.print(sum);
    }

    private static int findHourglassSum(final int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum = array[i][j] + array[i][j + 1] + array[i][j + 2] + array[i + 1][j + 1] + array[i + 2][j] + array[i + 2][j + 1] + array[i + 2][j + 2];
                max = max > sum ? max : sum;
            }
        }
        return max;
    }
}

/*

-1 -1  0 -9 -2 -2
-2 -1 -6 -8 -2 -5
-1 -1 -1 -2 -3 -4
-1 -9 -2 -4 -4 -5
-7 -3 -3 -2 -9 -9
-1 -3 -1 -2 -4 -5

-1
-1
0
-9
-2
-2
-2
-1
-6
-8
-2
-5
-1
-1
-1
-2
-3
-4
-1
-9
-2
-4
-4
-5
-7
-3
-3
-2
-9
-9
-1
-3
-1
-2
-4
-5

 */
