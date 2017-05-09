package com.hackerrank.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by rajeshkumar on 09/05/17.
 */
public class MaximumElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();

        Stack<Long> stack = new Stack();
        Stack<Long> maxStack = new Stack();
        while (queries-- > 0) {
            long queryType = in.nextLong();
            if (queryType == 1) {
                final long val = in.nextLong();
                if (maxStack.isEmpty() || maxStack.peek() <= val) {
                    maxStack.push(val);
                }
                stack.push(val);
            } else if (queryType == 2) {
                if (!stack.isEmpty()) {
                    if (maxStack.peek().equals(stack.pop())) {
                        maxStack.pop();
                    }
                }
            } else if (queryType == 3) {
                if (!maxStack.isEmpty()) {
                    System.out.println(maxStack.peek());
                }
            }
        }
    }
}

/*
809288903
967650885
975612397
975612397
967650885
967650885
809288903
809288903
954933086
115967602

 */

/*

42
1
809288903
3
1
55967040
1
967650885
1
21752006
3
2
1
61250743
1
975612397
3
3
2
3
2
3
2
2
3
3
2
1
784642399
2
1
810795573
1
365458420
2
2
1
419730027
2
1
403398558
1
371801162
2
2
1
950586579
2
1
954933086
3
2
1
247132075
2
1
115967602
3
3
 */
