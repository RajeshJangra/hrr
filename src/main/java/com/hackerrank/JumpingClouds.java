package com.hackerrank;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 28/04/17.
 */
public class JumpingClouds {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }
        int remainingEnergy = findRemainingEnergy(c, k);
        System.out.println(remainingEnergy);
    }

    private static int findRemainingEnergy(final int[] c, final int k) {
        int remainingEnergy = 100;
        boolean continueJumping = true;
        int counter = 0;

        while (continueJumping) {
            counter = (counter + k) % (c.length);
            remainingEnergy = remainingEnergy - (c[counter] == 1 ? 3 : 1);
            if (counter == 0) continueJumping = false;
        }
        return remainingEnergy;
    }
}

/*
8
2
0
0
1
0
0
1
1
0

 */

/*
19
19
1
1
0
1
0
1
0
1
0
1
0
1
1
0
1
1
1
1
1
 */
