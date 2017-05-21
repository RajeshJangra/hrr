package com.hackerrank.datastructure.balancedtress;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by rajeshkumar on 21/05/17.
 */
public class MedianUpdates {
    static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Long> max = new PriorityQueue<>();
        PriorityQueue<Long> min = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            final int choice = in.next().charAt(0);
            switch (choice) {
                case 'r':
                    removeValue(min, max, in.nextLong());
                    break;
                case 'a':
                    addValue(min, max, in.nextLong());
                    break;
            }
        }
        bf.flush();
    }

    private static void addValue(final PriorityQueue<Long> min, final PriorityQueue<Long> max, final long value) throws IOException {
        final double median;

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
            median = (min.peek() + max.peek()) / 2.0d;
        } else {
            if (max.peek() > value) {
                min.offer(value);
            } else {
                min.offer(max.poll());
                max.offer(value);
            }
            median = (min.peek() + max.peek()) / 2.0d;
        }
        bf.write(format(median) + "\n");
    }

    private static void removeValue(final PriorityQueue<Long> min, final PriorityQueue<Long> max, final long value) throws IOException {
        if (wrongCases(min, max, value)) {
            return;
        }

        double median = 0d;
        if (min.size() == max.size()) {
            median = (min.peek() + max.peek()) / 2.0d;
        } else if (min.size() > max.size()) {
            if (min.size() - max.size() > 1) {
                max.offer(min.poll());
                median = (min.peek() + max.peek()) / 2.0d;
            } else {
                median = min.peek();
            }
        } else if (max.size() > min.size()) {
            if (max.size() - min.size() > 1) {
                min.offer(max.poll());
                median = (min.peek() + max.peek()) / 2.0d;
            } else {
                median = max.peek();
            }
        }
        bf.write(format(median) + "\n");
    }

    private static boolean wrongCases(final PriorityQueue<Long> min, final PriorityQueue<Long> max, final long value) throws IOException {
        if ((min.isEmpty() && max.isEmpty())) {
            bf.write("Wrong!\n");
            return true;
        } else if (!min.isEmpty() && value <= min.peek()) {
            if (!min.remove(value) || (min.isEmpty() && max.isEmpty())) {
                bf.write("Wrong!\n");
                return true;
            }
        } else if (!max.isEmpty() && value >= max.peek()) {
            if (!max.remove(value) || (min.isEmpty() && max.isEmpty())) {
                bf.write("Wrong!\n");
                return true;
            }
        } else {
            bf.write("Wrong!\n");
            return true;
        }
        return false;
    }

    public static String format(double d) {
        if (d == (long) d) {
            return String.format("%d", (long) d);
        } else {
            return String.format("%s", new DecimalFormat("#.##").format(d));
        }
    }
}

/*
7
r
1
a
1
a
2
a
1
r
1
r
2
r
1

 */

/*
5
a -2147483648
a -2147483648
a -2147483647
r -2147483648
a 2147483647

 */
