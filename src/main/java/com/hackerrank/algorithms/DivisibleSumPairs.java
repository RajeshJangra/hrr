package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 25/04/17.
 */
public class DivisibleSumPairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        int result = getDivisibleSumPairs(k, a);

        System.out.println(result);
    }

    private static int getDivisibleSumPairs(final int k, final int[] a) {
        int result = 0;
        for (int counter = 0; counter < a.length -1; counter++) {
            for (int innerCounter = counter + 1; innerCounter < a.length; innerCounter++) {
                if ((a[counter] + a[innerCounter]) % k == 0) {
                    result++;
                }
            }
        }

        return result;
    }
}
