package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 27/04/17.
 */
public class PickingNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        int matchingSocks = findNumbers(a);
        System.out.println(matchingSocks);
    }

    private static int findNumbers(final int[] a) {
        int maxConsCounter = Integer.MIN_VALUE;

        for (int extCounter = 0; extCounter < a.length; extCounter++) {
            int posConsCounter = 0;
            int negConsCounter = 0;
            for (int internalCounter = 0; internalCounter < a.length; internalCounter++) {
                if (a[extCounter] - a[internalCounter] == 1 || a[extCounter] - a[internalCounter] == 0) {
                    posConsCounter++;
                }
                if (a[extCounter] - a[internalCounter] == -1 || a[extCounter] - a[internalCounter] == 0) {
                    negConsCounter++;
                }
            }
            maxConsCounter = (posConsCounter > negConsCounter && posConsCounter > maxConsCounter) ? posConsCounter : negConsCounter > maxConsCounter ? negConsCounter : maxConsCounter;
        }

        return maxConsCounter;
    }
}


