package com.hackerrank.jv;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by rajeshkumar on 08/05/17.
 */
public class JavaHashSet {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        HashSet hashSet = new HashSet();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        for (int i = 0; i < t; i++) {
            hashSet.add(pair_left[i] + " " + pair_right[i]);
            System.out.println(hashSet.size());
        }
    }
}
