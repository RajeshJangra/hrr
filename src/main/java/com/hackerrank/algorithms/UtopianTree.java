package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 27/04/17.
 */
public class UtopianTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] cycles = new int[n];
        for (int cycles_i = 0; cycles_i < n; cycles_i++) {
            cycles[cycles_i] = in.nextInt();
        }

        int[] newHeights = findNewHeights(cycles);
        for (int newHeight : newHeights) {
            System.out.println(newHeight);
        }
    }

    private static int[] findNewHeights(final int[] cycles) {
        int[] newHeights = new int[cycles.length];
        int counter = 0;

        for (double cycle : cycles) {
            if (cycle == 0) {
                newHeights[counter] = 1;
            } else {
                double ceil = Math.ceil(cycle / 2) + 1;
                int value = (int) Math.pow(2, ceil);
                newHeights[counter] = cycle % 2 == 0 ? value - 1 : value - 2;
            }
            counter++;
        }

        return newHeights;
    }
}
