package com.hackerrank.datastructure.stack;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 09/05/17.
 */
public class GameOfTwoStacks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for (int a0 = 0; a0 < g; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = in.nextInt();
            }
            System.out.println(findValuesPopped(a, b, x));
        }
        in.close();
    }

    public static int findValuesPopped(final int[] a, final int[] b, final int x) {
        int maxNumsPopped = 0;
        int sum = 0;
        int aCount;
        for (aCount = 0; aCount < a.length; aCount++) {
            if (sum + a[aCount] > x) {
                break;
            }
            sum += a[aCount];
            maxNumsPopped++;
        }
        aCount--;
        int bCount;
        int numsPopped = maxNumsPopped;
        for (bCount = 0; bCount < b.length; bCount++) {
            if (sum + b[bCount] <= x) {
                sum += b[bCount];
                numsPopped++;
            } else if (aCount < 0) {
                break;
            } else if (sum + b[bCount] - a[aCount] <= x) {
                sum += (b[bCount] - a[aCount]);
                aCount--;
            } else {
                sum += b[bCount];
                while (aCount >= 0) {
                    sum -= a[aCount--];
                    numsPopped--;
                    if (sum <= x) {
                        numsPopped++;
                        break;
                    }

                }
            }
            maxNumsPopped = maxNumsPopped > numsPopped ? maxNumsPopped : numsPopped;
        }
        return maxNumsPopped;
    }
}

/*
1
3
13
60
17
5
0
10
8
2
1
13
1
14
18
9
18
16
19
5
 */

/*
1
5
4
10
4
2
4
6
1
2
1
8
5
 */

/*
1
17
26
62
7
15
12
0
5
18
17
2
10
15
4
2
9
15
13
12
16
12
16
6
8
16
15
18
3
11
0
17
7
6
11
14
13
15
6
18
6
16
12
16
11
16
11
 */

/*
1
32
32
19
14
0
15
12
15
6
15
0
18
19
16
1
3
9
5
19
0
10
10
2
14
12
1
4
6
6
10
16
7
2
14
2
2
2
6
9
0
1
1
18
12
17
11
16
18
8
7
18
19
17
13
13
2
14
10
8
0
0
4
0
2
11
2
16

 */
