package com.hackerrank.datastructure.disjointsets;

import java.util.Arrays;

/**
 * Created by rajeshkumar on 17/05/17.
 */
public class DisjointSetExample {


    public static void main(String[] args) {
        DisjointSet set = new DisjointSet();

        set.union(0, 2);
        set.union(3, 4);
        set.union(1, 4);
        System.out.println(set);
        System.out.println(set.find(1, 9));
    }

    static class DisjointSet {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        public void union(int a, int b) {
            array[a] = b;
        }

        public boolean find(int a, int b) {
            do {
                if (array[a] == array[b]) {
                    return true;
                }
                a = array[a];
                b = array[b];
            } while (a != array[a] && b != array[b]);
            return false;
        }

        @Override
        public String toString() {
            return "DisjointSet{" + "array=" + Arrays.toString(array) + '}';
        }
    }
}
