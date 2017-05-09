package com.hackerrank.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by rajeshkumar on 09/05/17.
 */
public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
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
            System.out.println(balancedStack ? "YES" : "NO");
        }
    }
}
