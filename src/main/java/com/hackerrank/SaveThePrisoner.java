package com.hackerrank;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 27/04/17.
 */
public class SaveThePrisoner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][3];

        for (int arr_i = 0; arr_i < n; arr_i++) {
            for (int arr_j = 0; arr_j < 3; arr_j++) {
                arr[arr_i][arr_j] = in.nextInt();
            }
        }

        int[] prisonerIds = findPrisonerId(arr);
        for (int prisonerId : prisonerIds) {
            System.out.println(prisonerId);
        }
    }

    private static int[] findPrisonerId(final int[][] arr) {
        int[] prisonerIds = new int[arr.length];

        for (int extCounter = 0; extCounter < arr.length; extCounter++) {
            prisonerIds[extCounter] = (arr[extCounter][1] + arr[extCounter][2] - 2) % arr[extCounter][0] + 1;
        }
        return prisonerIds;
    }
}
