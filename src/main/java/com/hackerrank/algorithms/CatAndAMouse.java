package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 26/04/17.
 */
public class CatAndAMouse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        int[][] posArray = new int[q][3];
        for (int counter = 0; counter < q; counter++) {
            int[] positions = new int[3];
            positions[0] = in.nextInt();
            positions[1] = in.nextInt();
            positions[2] = in.nextInt();
            posArray[counter] = positions;
        }

        String[] whoWinsArr = findWhoWins(posArray);
        for (String whoWins : whoWinsArr) {
            System.out.println(whoWins);
        }
    }

    private static String[] findWhoWins(final int[][] posArray) {
        String[] whoWinsArr = new String[posArray.length];
        int counter = 0;
        for (int[] positions : posArray) {
            int catA = Math.abs(positions[0] - positions[2]);
            int catB = Math.abs(positions[1] - positions[2]);
            whoWinsArr[counter++] = catA < catB ? "Cat A" : catA > catB ? "Cat B" : "Mouse C";
        }
        return whoWinsArr;
    }
}
