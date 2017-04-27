package com.hackerrank;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 27/04/17.
 */
public class HurdleRace {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];
        for (int height_i = 0; height_i < n; height_i++) {
            height[height_i] = in.nextInt();
        }

        int drinksReq = findDrinksReq(n, k, height);
        System.out.println(drinksReq);
    }

    private static int findDrinksReq(final int n, final int k, final int[] height) {
        int drinksReq = 0;

        return drinksReq;
    }
}
