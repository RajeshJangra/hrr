package com.hackerrank.datastructure.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rajeshkumar on 03/05/17.
 */
public class DynamicArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfSequences = in.nextInt();
        int noOfQueries = in.nextInt();
        List<List<Integer>> input = new ArrayList<>();

        for (int i = 0; i < noOfQueries; i++) {
            List<Integer> inputList = new ArrayList<>(3);
            inputList.add(in.nextInt());
            inputList.add(in.nextInt());
            inputList.add(in.nextInt());
            input.add(inputList);
        }

        findLastAnswers(input, noOfSequences, noOfQueries);
    }

    private static void findLastAnswers(List<List<Integer>> input, int noOfSequences, int noOfQueries) {
        int lastAns = 0;

        List<List<Integer>> seqList = new ArrayList<>();
        for (int j = 0; j < noOfSequences; j++) {
            seqList.add(new ArrayList<>());
        }

        for (int counter = 0; counter < noOfQueries; counter++) {

            int value = input.get(counter).get(0);
            int x = input.get(counter).get(1);
            int y = input.get(counter).get(2);

            List<Integer> seq = seqList.get((x ^ lastAns) % noOfSequences);
            if (value == 1) {
                seq.add(y);
            } else if (value == 2) {
                lastAns = seq.get(y % seq.size());
                System.out.println(lastAns);
            }
        }
    }
}

/*
2
5
1
0
5
1
1
7
1
0
3
2
1
0
2
1
1
 */
