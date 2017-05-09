package com.hackerrank.jv;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 08/05/17.
 */
public class JavaGenerics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        int size = sc.nextInt();

        String min = "zzz";
        String max = "AAA";
        for (int counter = 0; counter < string.length() - size + 1; counter++) {
            String substring = string.substring(counter, counter + size);
            min = min.compareTo(substring) > 0 ? substring : min;
            max = max.compareTo(substring) > 0 ? max : substring;
        }
        System.out.println(min + "\n" + max);
    }

    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.println(element);
        }
    }
}
