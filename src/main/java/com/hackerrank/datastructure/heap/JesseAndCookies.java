package com.hackerrank.datastructure.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by rajeshkumar on 14/05/17.
 */
public class JesseAndCookies {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfCookies = in.nextInt();
        int sweetness = in.nextInt();
        PriorityQueue<Integer> cookies = new PriorityQueue<>();
        for (int i = 0; i < noOfCookies; i++) {
            cookies.offer(in.nextInt());
        }
        final int operations = findOperations(cookies, sweetness);
        System.out.println(operations);
    }

    private static int findOperations(final PriorityQueue<Integer> cookies, final int sweetness) {
        int days = 0;
        while (cookies.size() > 0) {
            if (cookies.peek() >= sweetness) {
                return days;
            }
            if (cookies.size() < 2) {
                break;
            }
            cookies.offer(cookies.poll() + 2 * cookies.poll());
            days++;
        }
        return -1;
    }
}

/*

6
7
1
2
3
9
10
12
 */

/*
8
90
13
47
74
12
89
74
18
38
 */
