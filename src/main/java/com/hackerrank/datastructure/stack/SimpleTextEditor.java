package com.hackerrank.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by rajeshkumar on 10/05/17.
 */
public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        edit(in, in.nextInt());
        in.close();
    }

    private static void edit(final Scanner in, int n) {
        StringBuilder current = new StringBuilder();
        Stack<String> histStack = new Stack();
        for (int i = 0; i < n; i++) {
            int queryType = in.nextInt();
            if (queryType == 1) {
                histStack.push("" + current);
                current.append(in.next());
            } else if (queryType == 2) {
                histStack.push("" + current);
                current = current.delete(current.length() - in.nextInt(), current.length());
            } else if (queryType == 3) {
                System.out.println(current.charAt(in.nextInt() - 1));
            } else if (queryType == 4) {
                current = new StringBuilder(histStack.pop());
            }
        }
    }
}

/*

8
1
abc
3
3
2
3
1
xy
3
2
4
4
3
1
 */
