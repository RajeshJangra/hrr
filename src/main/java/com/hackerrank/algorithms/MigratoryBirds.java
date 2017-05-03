package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 25/04/17.
 */
public class MigratoryBirds {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] types = new int[n];
        for (int types_i = 0; types_i < n; types_i++) {
            types[types_i] = in.nextInt();
        }

        int result = findMaxCategory(types);

        System.out.println(result);
    }

    private static int findMaxCategory(final int[] types) {
        int maxCounter = 0;
        int id = 0;
        int[] catArray = new int[types.length];

        for (int val : types) {
            catArray[val]++;
        }

        for (int counter = 0; counter < catArray.length; counter++) {
            if (catArray[counter] > maxCounter) {
                maxCounter = catArray[counter];
                id = counter;
            }
        }
        return id;
    }
}
