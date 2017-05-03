package com.hackerrank.datastructure.arrays;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 03/05/17.
 */
public class AlgorithmicCrush {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inputSize = in.nextInt();
        int operations = in.nextInt();
        long[] array = new long[inputSize + 1];

        for (int counter = 0; counter < operations; counter++) {
            int start = in.nextInt();
            int end = in.nextInt();
            long value = in.nextLong();
            array[start - 1] += value;
            if (end < array.length) {
                array[end] -= value;
            }

        }
        System.out.println(findMax(array));
    }

    private static long findMax(final long[] array) {
        long max = 0;
        long sum = 0;
        for (int counter = 0; counter < array.length; counter++) {
            max = max > (sum += array[counter]) ? max : sum;
        }
        return max;
    }
}

/*
5
3
1
2
100
2
5
100
3
4
100
 */
