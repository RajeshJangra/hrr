package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 28/04/17.
 */
public class FindDigits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }
        int[] digits = findDigits(c);
        for (int digit : digits) {
            System.out.println(digit);
        }
    }

    private static int[] findDigits(final int[] c) {
        int[] digits = new int[c.length];
        for (int counter = 0; counter < c.length; counter++) {
            int inputVal = c[counter];
            while (inputVal > 0) {
                if (inputVal % 10 != 0 && c[counter] % (inputVal % 10) == 0) {
                    digits[counter]++;
                }
                inputVal = inputVal / 10;
            }
        }
        return digits;
    }
}
