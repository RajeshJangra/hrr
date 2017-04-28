package com.hackerrank;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 29/04/17.
 */
public class CamelCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.next();

        int wordCount = countWords(string);
        System.out.println(wordCount);
    }

    private static int countWords(final String string) {
        int wordCount = string.length() > 0 ? 1 : 0;
        for (int counter = 0; counter < string.length(); counter++) {
            if (string.charAt(counter) >= 65 && string.charAt(counter) <= 90) {
                wordCount++;
            }
        }
        return wordCount;
    }
}
