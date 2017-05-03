package com.hackerrank.algorithms;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by rajeshkumar on 28/04/17.
 */
public class ExtraLongFactorials {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger factorial = findfactorial(n);
        System.out.println(factorial.toString());
    }

    private static BigInteger findfactorial(final int n) {
        BigInteger factorial = BigInteger.ONE;

        for (int counter = 1; counter <= n; counter++) {
            factorial = factorial.multiply(new BigInteger(Integer.toString(counter)));
        }
        return factorial;
    }
}
