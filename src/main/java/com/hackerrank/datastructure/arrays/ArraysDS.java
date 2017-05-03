package com.hackerrank.datastructure.arrays;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 29/04/17.
 */
public class ArraysDS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            array[i] = in.nextInt();
        }

        for (int val : array) {
            System.out.print(val + " ");
        }
    }
}
