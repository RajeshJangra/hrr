package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 27/04/17.
 */
public class ViralAdvertising {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int likePeople = findPeople(n);
        System.out.println(likePeople);
    }

    private static int findPeople(final int n) {
        int sendPeople = 5;
        int likePeople = 0;
        for (int counter = 1; counter <= n; counter++) {
            int floor = sendPeople / 2;
            likePeople += floor;
            sendPeople = floor * 3;
        }
        return likePeople;
    }
}
