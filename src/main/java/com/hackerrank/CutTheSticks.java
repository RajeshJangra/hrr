package com.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rajeshkumar on 28/04/17.
 */
public class CutTheSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] sticksSize = new int[n];
        for (int counter = 0; counter < n; counter++) {
            sticksSize[counter] = in.nextInt();
        }

        int[] sticks = calculateSticks(sticksSize);
        for (int stick : sticks) {
            if (stick == 0) break;
            System.out.println(stick);
        }
    }

    private static int[] calculateSticks(final int[] sticksSize) {
        Arrays.sort(sticksSize);
        int[] sticks = new int[sticksSize.length];
        int sticksCounter = 0;

        for (int counter = 0; counter < sticksSize.length; counter++) {
            boolean cuttingStarted = false;
            int cutSize = 0;
            for (int i = 0; i < sticksSize.length; i++) {
                if (sticksSize[i] != 0 && cuttingStarted == false) {
                    cutSize = sticksSize[i];
                    cuttingStarted = true;
                }
                if (cutSize > 0) {
                    sticksSize[i] -= cutSize;
                    sticks[sticksCounter]++;
                }
            }
            sticksCounter++;
        }
        return sticks;
    }
}