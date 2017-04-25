package com.hackerrank;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Created by rajeshkumar on 25/04/17.
 */
public class ApplesAndOranges {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for (int apple_i = 0; apple_i < m; apple_i++) {
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for (int orange_i = 0; orange_i < n; orange_i++) {
            orange[orange_i] = in.nextInt();
        }

        final AtomicInteger appleCounter = new AtomicInteger(0);
        final AtomicInteger orangeCounter = new AtomicInteger(0);
        IntStream.range(0, m > n ? m : n).forEach(counter -> {
            if (counter < m && (apple[counter] + a >= s && apple[counter] + a <= t)) {
                appleCounter.incrementAndGet();
            }
            if (counter < n && (orange[counter] + b >= s && orange[counter] + b <= t)) {
                orangeCounter.incrementAndGet();
            }
        });
        System.out.println(appleCounter);
    }
}
