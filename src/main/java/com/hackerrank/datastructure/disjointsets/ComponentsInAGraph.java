package com.hackerrank.datastructure.disjointsets;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by rajeshkumar on 19/05/17.
 */
public class ComponentsInAGraph {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        DisjointSet set = new DisjointSet(n * 2);
        for (int i = 0; i < n; i++) {
            set.union(in.nextInt(), in.nextInt());
        }
        findMinMax(set);
    }

    private static void findMinMax(DisjointSet set) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int counter = 0; counter < set.array.length; counter++) {
            if (set.array[counter] == counter && set.size[counter] > 1) {
                min = min > set.size[counter] ? set.size[counter] : min;
                max = max < set.size[counter] ? set.size[counter] : max;
            }
        }

        System.out.println(min + " " + max);
    }

    static class DisjointSet {
        int[] array;
        int[] size;

        public DisjointSet(int n) {
            array = new int[n + 1];
            size = new int[n + 1];
            IntStream.rangeClosed(0, n).forEach(i -> {
                array[i] = i;
                size[i] = 1;
            });
        }

        public void union(int i, int j) {
            int irep = find(i);
            int jrep = find(j);
            if (irep == jrep) {
                return;
            }
            array[irep] = jrep;
            size[jrep] += size[irep];
        }


        public int find(int i) {
            if (array[i] == i) {
                return i;
            } else {
                int result = find(array[i]);
                array[i] = result;
                return result;
            }
        }
    }
}
