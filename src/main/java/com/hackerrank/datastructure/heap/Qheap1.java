package com.hackerrank.datastructure.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rajeshkumar on 14/05/17.
 */
public class Qheap1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Heap heap = new Heap();
        for (int i = 0; i < n; i++) {
            int choice = in.nextInt();
            if (choice == 1) {
                heap.add(in.nextInt());
            } else if (choice == 2) {
                heap.delete(in.nextInt());
            } else {
                heap.print();
            }
        }
    }

    static class Heap {
        List<Integer> list = new ArrayList<>();

        public List<Integer> getList() {
            return list;
        }

        public void add(final int value) {
            list.add(value);
            if (list.size() > 1) {
                heapify(list.size() - 1);
            }
        }

        public int removeTop() {
            int removed = list.remove(0);
            if (list.size() >= 2) {
                heapify(2);
            } else if (list.size() >= 1) {
                heapify(1);
            }
            return removed;
        }

        public int delete(final int value) {
            int removed = 0;
            if (!list.isEmpty()) {
                int indexOf = list.indexOf(new Integer(value));
                boolean heapify = indexOf < list.size() - 2;
                removed = list.remove(indexOf);
                if (heapify) {
                    heapify(indexOf + 1);
                }
            }
            return removed;
        }

        public void print() {
            if (!list.isEmpty()) {
                System.out.println(list.get(0));
            }
        }

        void heapify(int nodeIndex) {
            int pIndex = (nodeIndex - 1) / 2;
            if (pIndex >= 0 && nodeIndex > 0 && nodeIndex > pIndex) {
                if (list.get(pIndex) > list.get(nodeIndex)) {
                    swap(nodeIndex, pIndex);
                    heapify(pIndex);
                }
            }
        }

        private void swap(final int index, final int newIndex) {
            int temp = list.get(index);
            list.set(index, list.get(newIndex));
            list.set(newIndex, temp);
        }
    }
}

/*
6
1
10
1
8
3
1
5
2
5
3

 */
