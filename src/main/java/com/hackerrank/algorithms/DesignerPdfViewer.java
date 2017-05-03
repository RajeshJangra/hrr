package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 27/04/17.
 */
public class DesignerPdfViewer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for (int h_i = 0; h_i < 26; h_i++) {
            h[h_i] = in.nextInt();
        }
        String word = in.next();

        int highlightedArea = findHighlightedArea(h, word);
        System.out.println(highlightedArea);
    }

    private static int findHighlightedArea(final int[] h, final String word) {
        int maxLetterValue = findMaxLetterValue(h, word);
        return maxLetterValue * word.length();
    }

    private static int findMaxLetterValue(final int[] h, final String word) {
        int maxValue = 0;
        for (int counter = 0; counter < word.length(); counter++) {
            int c = word.charAt(counter) - 97;
            maxValue = maxValue > h[c] ? maxValue : h[c];
        }
        return maxValue;
    }
}

/*
1
3
1
3
1
4
1
3
2
5
5
5
5
5
5
5
5
5
5
5
5
5
5
5
5
5
abc
 */
