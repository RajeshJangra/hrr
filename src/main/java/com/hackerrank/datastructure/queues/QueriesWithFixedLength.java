package com.hackerrank.datastructure.queues;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.IntStream;

/**
 * Created by rajeshkumar on 13/05/17.
 */
public class QueriesWithFixedLength {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int q = in.nextInt();

        int[] a = new int[n];
        IntStream.range(0, n).forEach(number -> a[number] = (in.nextInt()));

        IntStream.range(0, q).forEach(number -> System.out.println(findMinMax(a, in.nextInt())));
    }

    static private int findMinMax(int[] a, int d) {
        int min = Integer.MAX_VALUE;
        Stack<Integer> maxStack = new Stack<>();
        Queue<Integer> maxQueue = new ArrayBlockingQueue<>(d);
        for (int i = 0; i < a.length; i++) {
            maxQueue.offer(a[i]);
            if (maxStack.isEmpty() || maxStack.peek().compareTo(a[i]) < 0) {
                maxStack.push(a[i]);
            }
            if (maxQueue.size() == d) {
                int max = maxStack.peek();
                min = max < min ? max : min;
                if (maxQueue.poll().equals(max)) {
                    maxStack.clear();
                    final Optional<Integer> newMax = maxQueue.stream().max(Comparator.naturalOrder());
                    if (newMax.isPresent()) {
                        maxStack.push(newMax.get());
                    }
                }
            }
        }
        return min;
    }
}
/*
5
1
33
11
44
11
55
1

 */
