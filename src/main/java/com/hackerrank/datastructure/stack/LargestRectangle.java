package com.hackerrank.datastructure.stack;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 10/05/17.
 */
public class LargestRectangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = in.nextInt();
        }
        System.out.println(findLargestRectangle(heights));
        in.close();
    }

    private static int findLargestRectangle(final int[] heights) {
        int maxArea = 0;

        for (int counter = 0; counter < heights.length; counter++) {
            int totalCounter = 1;

            //Right side buildings
            int tempCounter = counter + 1;
            while (tempCounter < heights.length && heights[counter] <= heights[tempCounter]) {
                totalCounter++;
                tempCounter++;
            }

            //Left side buildings
            tempCounter = counter - 1;
            while (tempCounter >= 0 && heights[counter] <= heights[tempCounter]) {
                totalCounter++;
                tempCounter--;
            }
            final int area = totalCounter * heights[counter];
            maxArea = maxArea > area ? maxArea : area;
        }
        return maxArea;
    }
}

/*
10
8979
4570
6436
5083
7780
3269
5400
7579
2324
2116
 */
