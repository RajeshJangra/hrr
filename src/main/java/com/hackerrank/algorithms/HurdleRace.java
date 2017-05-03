package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 27/04/17.
 */
public class HurdleRace {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] heights = new int[n];
        for (int height_i = 0; height_i < n; height_i++) {
            heights[height_i] = in.nextInt();
        }

        int drinksReq = findDrinksReq(k, heights);
        System.out.println(drinksReq);
    }

    private static int findDrinksReq(int k, final int[] heights) {
        int drinksReq = 0;

        for (int height : heights) {
            if (k < height) {
                drinksReq += height - k;
                k = height;
            }
        }
        return drinksReq;
    }
}
