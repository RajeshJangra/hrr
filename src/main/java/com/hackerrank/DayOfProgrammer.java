package com.hackerrank;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 25/04/17.
 */
public class DayOfProgrammer {

    static String solve(int year) {
        return year == 1918 ? "26.09." + year : isLeap(year) ? "12.09." + year : "13.09." + year;
    }

    private static boolean isLeap(int year) {
        return (year < 1918) && (year % 4 == 0) ? true : (year < 1918) && (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) ? true : false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
}
