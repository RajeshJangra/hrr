package com.hackerrank;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 26/04/17.
 */
public class DrawingBook {

    static int findTurnedPages(int n, int p) {
        final int pagesFromLeft = p / 2;
        final int pagesFromRight = n % 2 == 0 ? ((n + 1 - p) / 2) : (n - p) / 2;
        return pagesFromLeft <= pagesFromRight ? pagesFromLeft : pagesFromRight;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = findTurnedPages(n, p);
        System.out.println(result);
    }
}
