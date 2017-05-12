package com.hackerrank.datastructure.queues;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by rajeshkumar on 12/05/17.
 */
public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Queue queue = new Queue();
        for (int i = 0; i < n; i++) {
            int choice = in.nextInt();
            if (choice == 1) {
                queue.enqueue(in.nextInt());
            } else if (choice == 2) {
                queue.dequeue();
            } else {
                System.out.println(queue.print());
            }
        }
    }

    static class Queue {
        Stack<Integer> input = new Stack<>();
        Stack<Integer> output = new Stack<>();

        public void enqueue(Integer value) {
            input.push(value);
        }

        public int dequeue() {
            fillOutput();
            return output.pop();
        }

        public int print() {
            fillOutput();
            return output.peek();
        }

        private void fillOutput() {
            if (output.isEmpty()) {
                final int size = input.size();
                for (int counter = 0; counter < size; counter++) {
                    output.push(input.pop());
                }
            }
        }
    }
}

/*
10
1
42
2
1
14
3
1
28
3
1
60
1
78
2
2
 */

/*
10
1
76
1
33
2
1
23
1
97
1
21
3
3
1
74
3
 */
