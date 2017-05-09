package com.hackerrank.jv;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by rajeshkumar on 08/05/17.
 */
public class BalancedStack {
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
