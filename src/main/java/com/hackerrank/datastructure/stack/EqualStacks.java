package com.hackerrank.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by rajeshkumar on 09/05/17.
 */
public class EqualStacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int height1 = 0;
        int height2 = 0;
        int height3 = 0;
        List<Integer> list = new ArrayList();
        Stack<Integer> stack1 = new Stack<>();
        while (n1-- > 0) {
            list.add(in.nextInt());
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            final Integer val = list.get(i);
            stack1.push(val);
            height1 += val;
        }
        list.clear();
        Stack<Integer> stack2 = new Stack<>();
        while (n2-- > 0) {
            list.add(in.nextInt());
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            final Integer val = list.get(i);
            stack2.push(val);
            height2 += val;
        }
        list.clear();
        Stack<Integer> stack3 = new Stack<>();
        while (n3-- > 0) {
            list.add(in.nextInt());
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            final Integer val = list.get(i);
            stack3.push(val);
            height3 += val;
        }
        System.out.println(findEqualHeight(height1, height2, height3, stack1, stack2, stack3));
    }

    private static int findEqualHeight(int height1, int height2, int height3, final Stack<Integer> stack1, final Stack<Integer> stack2, final Stack<Integer> stack3) {
        while (true) {
            if (height1 == height2 && height2 == height3) {
                return height1;
            } else if (height1 == 0 || height2 == 0 || height3 == 0) {
                return 0;
            }
            if (height1 >= height2 && height1 >= height3) {
                height1 -= stack1.pop();
            } else if (height2 >= height1 && height2 >= height3) {
                height2 -= stack2.pop();
            } else if (height3 >= height2 && height3 >= height1) {
                height3 -= stack3.pop();
            }
        }
    }
}

/*

5
3
4
3
2
1
1
1
4
3
2
1
1
4
1
 */
