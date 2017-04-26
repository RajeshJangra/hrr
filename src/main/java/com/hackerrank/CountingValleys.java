package com.hackerrank;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 26/04/17.
 */
public class CountingValleys {

    private static int countValleys(final String steps) {
        int currentLevel = 0;
        int totalValleys = 0;

        for (int counter = 0; counter < steps.length(); counter++) {
            currentLevel = steps.charAt(counter) == 'U' ? currentLevel + 1 : currentLevel - 1;
            totalValleys = currentLevel == 0 && steps.charAt(counter) == 'U' ? totalValleys + 1 : totalValleys;
        }
        return totalValleys;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String steps = in.next();
        int totalValleys = countValleys(steps);
        System.out.println(totalValleys);
    }
}
