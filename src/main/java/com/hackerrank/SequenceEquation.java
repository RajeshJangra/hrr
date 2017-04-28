package com.hackerrank;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 28/04/17.
 */
public class SequenceEquation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        int[] yArray = findPOfP(a);
        for (int y : yArray) {
            System.out.println(y + 1);
        }
    }

    private static int[] findPOfP(final int[] a) {
        int[] yArray = new int[a.length];
        for (int extCounter = 0; extCounter < a.length; extCounter++) {
            int index = extCounter + 1;
            int pOf = findIndex(a, index);
            int pOfP = findIndex(a, pOf + 1);
            yArray[extCounter] = pOfP;
        }
        return yArray;
    }

    private static int findIndex(final int[] a, int index) {
        for (int counter = 0; counter < a.length; counter++) {
            if (index == a[counter]) {
                return counter;
            }
        }
        return 0;
    }
}

/*
5
1
4
2
3
5
 */