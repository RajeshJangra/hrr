package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * Created by rajeshkumar on 27/04/17.
 */
public class ClimbingTheLeaderboard {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] leaderScores = new int[n];
        for (int scores_i = 0; scores_i < n; scores_i++) {
            leaderScores[scores_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] aliceScores = new int[m];
        for (int alice_i = 0; alice_i < m; alice_i++) {
            aliceScores[alice_i] = in.nextInt();
        }

        int[] rankings = findRankings(leaderScores, aliceScores);
        for (int rank : rankings) {
            System.out.println(rank);
        }
    }

    private static int[] findRankings(final int[] leaderScores, final int[] aliceScores) {
        int[] aliceRankings = new int[aliceScores.length];
        int currentRank = 1;
        int previous = -1;
        int startCounter = 0;
        for (int aCounter = aliceScores.length - 1; aCounter >= 0; aCounter--) {
            for (int lCounter = startCounter; lCounter < leaderScores.length; lCounter++) {
                if (aliceScores[aCounter] >= leaderScores[lCounter]) {
                    aliceRankings[aCounter] = currentRank;
                    break;
                } else {
                    if(startCounter < leaderScores.length -1) {
                        startCounter++;
                    }
                }
                if (previous != leaderScores[lCounter]) {
                    currentRank++;
                    previous = leaderScores[lCounter];
                }
                aliceRankings[aCounter] = currentRank;
            }
        }

        return aliceRankings;
    }
}

/*
7
100
100
50
40
40
20
10
4
4
5
6
7
 */
