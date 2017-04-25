package com.hackerrank;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 25/04/17.
 */
public class BirthdayChocolates {
    static int getWays(int[] squares, int d, int m) {
        int ways = 0;
        for (int counter = 0; counter <= squares.length - m; counter++) {
            int intSum = 0;
            for (int intCounter = counter; intCounter < m + counter; intCounter++) {
                intSum += squares[intCounter];
            }
            if (d == intSum) {
                ways++;
            }
        }
        return ways;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for (int s_i = 0; s_i < n; s_i++) {
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = getWays(s, d, m);
        System.out.println(result);
    }
}
