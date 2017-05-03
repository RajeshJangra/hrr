package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 25/04/17.
 */
public class GradingStudents {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for (int grades_i = 0; grades_i < n; grades_i++) {
            grades[grades_i] = in.nextInt();
        }
        solve(grades);
    }

    private static void solve(final int[] grades) {
        for (int grade : grades) {
            if (grade >= 40 && grade % 5 >= 3) {
                grade += (5 - grade % 5);
            } else if (grade < 40 && grade + 2 >= 40) {
                grade = 40;
            }
            System.out.println(grade);
        }

    }
}
