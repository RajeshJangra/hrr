package com.hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            boolean balancedStack = true;
            String input = sc.next();
            Stack<Character> stack = new Stack();
            for (int counter = 0; counter < input.length(); counter++) {
                final char c = input.charAt(counter);
                if (c == '[' || c == '{' || c == '(') {
                    stack.push(c);
                } else if (stack.size() > 0) {
                    final Character pop = stack.pop();
                    if ((pop == '[' && c != ']') || (pop == '{' && c != '}') || (pop == '(' && c != ')')) {
                        balancedStack = false;
                        break;
                    }
                } else {
                    balancedStack = false;
                    break;
                }
            }
            if (stack.size() > 0) {
                balancedStack = false;
            }
            System.out.println(balancedStack);
        }
    }
}

/*
2
0
2
10
5
3
5
 */
