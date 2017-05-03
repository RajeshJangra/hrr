package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 28/04/17.
 */
public class AppendAndDelete {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source = in.next();
        String destination = in.next();
        int steps = in.nextInt();

        String canDo = findCanAlter(source, destination, steps);
        System.out.println(canDo);
    }

    private static String findCanAlter(final String source, final String destination, final int steps) {

        int commonStringSize = 0;
        int sLength = source.length();
        int dLength = destination.length();
        if (sLength + dLength <= steps) return "Yes";
        int smallerSize = sLength < dLength ? sLength : dLength;

        for (int counter = 0; counter < smallerSize; counter++) {
            if (source.charAt(counter) != destination.charAt(counter)) break;
            commonStringSize++;
        }
        if (source.contains(destination) && ((steps - (sLength - dLength)) % 2 == 0)) {
            return "Yes";
        }
        if (destination.contains(source) && ((steps - (dLength - sLength)) % 2 == 0)) {
            return "Yes";
        }
        int stepsRequired = (sLength - commonStringSize) + (dLength - commonStringSize);
        return steps == stepsRequired ? "Yes" : "No";
    }
}
