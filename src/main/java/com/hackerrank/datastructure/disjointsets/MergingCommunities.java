package com.hackerrank.datastructure.disjointsets;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by rajeshkumar on 18/05/17.
 */
public class MergingCommunities {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DisjointSet set = new DisjointSet(in.nextInt());
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            final int choice = in.next().charAt(0);
            switch (choice) {
                case 'Q':
                    System.out.println(set.size[set.find(in.nextInt())]);
                    break;
                case 'M':
                    set.union(in.nextInt(), in.nextInt());
                    break;
            }
        }
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
/*
3
6
Q
1
M
1
2
Q
2
M
2
3
Q
3
Q
2

 */

/*
1000
38
Q
696
M
308
23
M
737
895
Q
928
Q
951
M
724
263
Q
173
Q
425
M
491
13
Q
377
M
820
946
M
911
25
M
606
950
Q
324
Q
914
M
561
2
M
863
242
Q
504
M
28
479
Q
904
Q
27
M
755
617
M
574
915
Q
291
M
592
648
M
915
493
M
837
406
Q
318
M
181
300
M
118
156
Q
183
M
820
94
M
788
839
M
702
670
M
993
343
Q
990
M
482
762
Q
820

 */
