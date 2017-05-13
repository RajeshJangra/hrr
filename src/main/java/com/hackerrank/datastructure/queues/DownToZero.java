package com.hackerrank.datastructure.queues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by rajeshkumar on 13/05/17.
 */
public class DownToZero {
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        IntStream.range(0, in.nextInt()).forEach(number -> System.out.println(findStepsDownToZero(in.nextInt())));
        //map.forEach((x, y) -> System.out.println(x + "->" + y));
    }

    private static int findStepsDownToZero(int number) {
        //System.out.println("\t" + number + " -> ");
        while (number > 0) {
            final Integer existingSteps = map.get(number);
            if (existingSteps != null) {
                return existingSteps;
            }
            int sqrt = (int) Math.sqrt(number);
            sqrt = sqrt > 1 ? sqrt : 2;
            final int[] factors = IntStream.rangeClosed(sqrt, number / 2).filter(i -> number % i == 0).toArray();
            if (factors.length > 0) {
                int[] stepsArr = new int[factors.length];
                for (int i = 0; i < factors.length; i++) {
                    stepsArr[i] = findStepsDownToZero(factors[i]);
                }
                Arrays.sort(stepsArr);
                map.put(number, stepsArr[0] + 1);
                return stepsArr[0] + 1;
            } else {
                final int steps = findStepsDownToZero(number - 1) + 1;
                map.put(number, steps);
                return steps;
            }
        }
        return 0;
    }
}
