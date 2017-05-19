package com.hackerrank.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by rajeshkumar on 20/05/17.
 */
public class EqualizeAnArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] inputArray = new int[n];
        IntStream.range(0, n).forEach(i -> inputArray[i] = in.nextInt());
        System.out.println(findNoOfElemToDelete(inputArray));
    }

    public static int findNoOfElemToDelete(int[] inputArray) {
        int maxFreq = 1;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int val : inputArray) {
            if (freqMap.containsKey(val)) {
                int currentFreq = freqMap.get(val);
                freqMap.put(val, ++currentFreq);
                maxFreq = maxFreq < currentFreq ? currentFreq : maxFreq;
            } else {
                freqMap.put(val, 1);
            }
        }
        return inputArray.length - maxFreq;
    }
}

/*
5
3
3
2
1
3

 */
