package com.hackerrank.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rajeshkumar on 10/05/17.
 */
public class PoisenousPlants {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> heights = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            heights.add(in.nextInt());
        }

        final int noOfDays = killPlants(heights);
        System.out.println(noOfDays);
    }

    private static int killPlants(final List<Integer> heights) {
        int noOfDays = 0;
        boolean keepKilling = true;

        while (keepKilling) {
            int previous = Integer.MIN_VALUE;
            keepKilling = false;
            for (int i = heights.size() - 1; i >= 0; i--) {
                final Integer val = heights.get(i);
                if (previous > val) {
                    heights.remove(i + 1);
                    keepKilling = true;
                }
                previous = val;
            }
            noOfDays = keepKilling ? noOfDays + 1 : noOfDays;
        }
        return noOfDays;
    }
}

/*
17
20
5
6
15
2
2
17
2
11
5
14
5
10
9
19
12
5

 */

/*
8
6
5
8
4
7
10
9
5
 */

/*
7
6
5
8
4
7
10
9
 */
