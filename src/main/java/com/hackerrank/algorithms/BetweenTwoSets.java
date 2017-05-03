package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 25/04/17.
 */
public class BetweenTwoSets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for (int b_i = 0; b_i < m; b_i++) {
            b[b_i] = in.nextInt();
        }

        int hcf1 = a[0];
        int lcm1 = a[0];
        for (int i = 1; i < a.length; i++) {
            hcf1 = findHcf(hcf1, a[i]);
            lcm1 = (lcm1 * a[i]) / findHcf(lcm1, a[i]);
        }

        int hcf2 = b[0];
        for (int i = 1; i < b.length; i++) {
            hcf2 = findHcf(hcf2, b[i]);
        }

        int value = 0;
        if( hcf2 % lcm1 == 0){
            for (int i = 1; i <= hcf2 / lcm1; i++) {
                if(hcf2%(i * lcm1) == 0) {
                    value++;
                }else{
                    System.out.println("i + \" \" + hcf2 + \" \" + lcm1 = " + i + " " + hcf2 + " " + lcm1);
                }
            }
        }

        System.out.println("lcm1 + \" \" + hcf2 = " + lcm1 + " " + hcf2);
        System.out.println("value = " + value);
    }

    private static int findHcf(int firstVal, int secondVal) {
        return firstVal > secondVal ? findHcf2(firstVal, secondVal) : (firstVal < secondVal ? findHcf2(secondVal, firstVal) : firstVal);
    }

    private static int findHcf2(int bigVal, int smallVal) {
        int div;

        do {
            div = bigVal % smallVal;
            if (div != 0) {
                bigVal = smallVal;
                smallVal = div;
            }
        } while (div != 0);

        return smallVal;
    }
}
