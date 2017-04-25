package com.hackerrank;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 25/04/17.
 */
public class BreakingTheRecords {
    static int[] getRecord(int[] s) {
        int max = s[0];
        int maxCounter = 0;
        int min = s[0];
        int minCounter = 0;

        for (int val : s) {
            if (max < val) {
                maxCounter++;
                max = val;
            }
            if (min > val) {
                minCounter++;
                min = val;
            }
        }
        return new int[]{maxCounter, minCounter};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for (int s_i = 0; s_i < n; s_i++) {
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }
}
