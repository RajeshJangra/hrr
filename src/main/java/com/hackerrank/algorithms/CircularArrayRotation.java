package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 27/04/17.
 */
public class CircularArrayRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();

        int[] array = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            array[a_i] = in.nextInt();
        }

        int[] indexArray = new int[q];
        for (int a0 = 0; a0 < q; a0++) {
            indexArray[a0] = in.nextInt();
        }

        int[] rotatedArray = rotateArray(array, k);
        for (int indexValue : indexArray) {
            System.out.println(rotatedArray[indexValue]);
        }
    }

    private static int[] rotateArray(final int[] array, final int k) {
        int[] rotatedArray = new int[array.length];
        for (int counter = 0; counter < array.length; counter++) {
            int rotatedIndex = counter + k < array.length ? counter + k : (counter + k) % array.length;
            rotatedArray[rotatedIndex] = array[counter];
        }
        return rotatedArray;
    }
}
