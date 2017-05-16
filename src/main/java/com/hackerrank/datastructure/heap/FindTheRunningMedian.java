package com.hackerrank.datastructure.heap;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by rajeshkumar on 15/05/17.
 */
public class FindTheRunningMedian {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.0");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Integer> max = new PriorityQueue<>();
        PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            final int value = in.nextInt();
            float median = findMedian(min, max, value);
            System.out.println(df.format(median));
        }
    }

    private static float findMedian(final PriorityQueue<Integer> min, final PriorityQueue<Integer> max, final int value) {
        final float median;
        if (min.size() == max.size()) {
            if (min.isEmpty() || (min.peek() > value)) {
                min.offer(value);
                median = min.peek();
            } else {
                max.offer(value);
                median = max.peek();
            }
        } else if (min.size() > max.size()) {
            if ((max.isEmpty() && min.peek() < value) || (!max.isEmpty() && min.peek() < value)) {
                max.offer(value);
            } else {
                max.offer(min.poll());
                min.offer(value);
            }
            median = (min.peek() + max.peek()) / 2.0f;
        } else {
            if (max.peek() > value) {
                min.offer(value);
            } else {
                min.offer(max.poll());
                max.offer(value);
            }
            median = (min.peek() + max.peek()) / 2.0f;
        }
        return median;
    }
}
/*
3
94455
20555
20535
 */
