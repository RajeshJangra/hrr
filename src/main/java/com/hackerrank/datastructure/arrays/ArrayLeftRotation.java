package com.hackerrank.datastructure.arrays;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 03/05/17.
 */
public class ArrayLeftRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arraySize = in.nextInt();
        int noOfRotation = in.nextInt();
        int[] array = new int[arraySize];

        for (int counter = 0; counter < arraySize; counter++) {
            array[counter] = in.nextInt();
        }

        final int[] rotatedArray = leftRotate(array, noOfRotation);

        for (int val : rotatedArray) {
            System.out.print(val + " ");
        }
    }

    private static int[] leftRotate(final int[] array, int noOfRotation) {
        int[] rotatedArray = new int[array.length];
        for (int counter = 0; counter < array.length; counter++) {
            int index = (counter - noOfRotation) >= 0 ? (counter - noOfRotation) : array.length + (counter - noOfRotation) % array.length;
            rotatedArray[index] = array[counter];
        }
        return rotatedArray;
    }
}


/*
5
4
1
2
3
4
5
 */