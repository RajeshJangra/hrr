package com.hackerrank.algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rajeshkumar on 26/04/17.
 */
public class SockMerchant {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }

        int matchingSocks = findSocks(c);
        System.out.println(matchingSocks);
    }

    private static int findSocks(int c[]) {
        Arrays.sort(c);
        int total = 0;
        int previous = 0;
        for (int counter = 0; counter < c.length; counter++) {
            if (previous == c[counter]) {
                total++;
                previous = 0;
            } else {
                previous = c[counter];
            }
        }
        return total;
    }
}