package com.hackerrank.datastructure.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by rajeshkumar on 16/05/17.
 */
public class MinimumAverageWaitingTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Customer> custByArrival = new PriorityQueue<>((o1, o2) -> ((Long) o1.arrivalTime).compareTo(o2.arrivalTime));

        for (int i = 0; i < n; i++) {
            Customer customer = new Customer(in.nextLong(), in.nextLong());
            custByArrival.offer(customer);
        }
        long currentLeadTime = findAverageTime(custByArrival);

        System.out.println((currentLeadTime) / n);
    }

    private static long findAverageTime(final PriorityQueue<Customer> custByArrival) {
        long cumWaitTime = 0;
        long currentTime = custByArrival.peek().arrivalTime;
        long cumCookTime = 0;
        final PriorityQueue<Customer> custByCookTime = new PriorityQueue<>((o1, o2) -> ((Long) o1.timeToCook).compareTo(o2.timeToCook));

        findMoreOrders(custByArrival, custByCookTime, currentTime);

        while (custByCookTime.size() > 0) {
            final Customer customer = custByCookTime.poll();
            cumWaitTime += currentTime - customer.arrivalTime;
            currentTime += customer.timeToCook;
            cumCookTime += customer.timeToCook;
            findMoreOrders(custByArrival, custByCookTime, currentTime);
        }

        return cumCookTime + cumWaitTime;
    }

    private static void findMoreOrders(final PriorityQueue<Customer> custByArrival, final PriorityQueue<Customer> custByCookTime, final long currentTime) {
        while (!custByArrival.isEmpty() && custByArrival.peek().arrivalTime <= currentTime) {
            custByCookTime.offer(custByArrival.poll());
        }
        if (custByCookTime.isEmpty() && !custByArrival.isEmpty()) {
            custByCookTime.offer(custByArrival.poll());
        }
    }

    static class Customer {
        long arrivalTime;
        long timeToCook;

        public Customer(final long arrivalTime, final long timeToCook) {
            this.arrivalTime = arrivalTime;
            this.timeToCook = timeToCook;
        }
    }
}

/*
5
961148050
385599125
951133776
376367013
283280121
782916802
317664929
898415172
980913391
847912645

 */

/*
3
1
4
2
5
3
4

 */

/*
2
0
9
10
4

 */

