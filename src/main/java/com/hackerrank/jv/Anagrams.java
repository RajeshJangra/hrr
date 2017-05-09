package com.hackerrank.jv;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rajeshkumar on 09/05/17.
 */
public class Anagrams {

    public static void main(String[] args) {
        isAnagram("aa", "bb");
    }

    static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        if (a.length() != b.length()) {
            return false;
        }

        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();
        for (int counter = 0; counter < a.length(); counter++) {
            final char keyA = a.charAt(counter);
            final char keyB = b.charAt(counter);
            if (mapA.get(keyA) == null) {
                mapA.put(keyA, 1);
            } else {
                mapA.computeIfPresent(keyA, (k, v) -> v + 1);
            }
            if (mapB.get(keyB) == null) {
                mapB.put(keyB, 1);
            } else {
                mapB.computeIfPresent(keyB, (k, v) -> v + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : mapA.entrySet()) {
            if (mapB.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
