package com.hackerrank.datastructure.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rajeshkumar on 03/05/17.
 */
public class SparseArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inputSize = in.nextInt();
        String[] inputStrings = new String[inputSize];

        for (int counter = 0; counter < inputSize; counter++) {
            inputStrings[counter] = in.next();
        }

        int querySize = in.nextInt();
        String[] queries = new String[querySize];

        for (int counter = 0; counter < querySize; counter++) {
            queries[counter] = in.next();
        }

        final int[] occurrings = findOccurrings(inputStrings, queries);

        for (int val : occurrings) {
            System.out.println(val);
        }
    }

    private static int[] findOccurrings(final String[] inputStrings, final String[] queries) {
        Arrays.sort(inputStrings);
        final int[] occurrings = new int[queries.length];
        int counter = 0;

        for (String query : queries) {
            for (String inputString : inputStrings) {
                if (query.equals(inputString)) {
                    occurrings[counter]++;
                } else if (query.compareTo(inputString) < 0) {
                    break;
                }
            }
            counter++;
        }
        return occurrings;
    }
}
