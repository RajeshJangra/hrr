package com.hackerrank;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 28/04/17.
 */
public class LibraryFine {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] dates = new int[6];
        for (int counter = 0; counter < 6; counter++) {
            dates[counter] = in.nextInt();
        }

        int fine = calculateFine(dates);
        System.out.println(fine);
    }

    private static int calculateFine(final int[] dates) {
        int fine = 0;
        if (dates[2] > dates[5]) {
            fine = 10000;
        } else if (dates[2] == dates[5] && dates[1] > dates[4]) {
            fine = (dates[1] - dates[4]) * 500;
        } else if (dates[2] == dates[5] && dates[1] == dates[4] && dates[0] > dates[3]) {
            fine = (dates[0] - dates[3]) * 15;
        }
        return fine;
    }
}
