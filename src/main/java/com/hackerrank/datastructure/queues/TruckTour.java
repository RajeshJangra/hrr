package com.hackerrank.datastructure.queues;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by rajeshkumar on 13/05/17.
 */
public class TruckTour {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        List<Pump> pumpList = new ArrayList<>();
        final int n = in.nextInt();
        IntStream.range(0, n).forEach(number -> pumpList.add(new Pump(in.nextInt(), in.nextInt())));

        int currentOil = 0;
        int pumpId = -1;
        int counter = 0;
        while (true) {
            final Pump pump = pumpList.get(counter);
            currentOil += pump.petrol - pump.distance;
            if (currentOil < 0) {
                currentOil = 0;
                pumpId = -1;
            } else {
                if (pumpId == counter) {
                    break;
                }
                if (pumpId == -1) {
                    pumpId = counter;
                }
            }
            counter = ++counter % n;
        }
        System.out.println(pumpId);

    }

    static class Pump {
        int petrol;
        int distance;

        public Pump(final int petrol, final int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }

    }
}

/*
3
1
5
10
3
3
4
 */
