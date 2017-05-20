package com.hackerrank.datastructure.disjointsets;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rajeshkumar on 20/05/17.
 */
public class KunduAndTree {
    static final int M = 1000000007;

    public static void main(String[] args) {

    }

    static class Vertex {
        private ArrayList<Edge> neighborhood;

    }

    static class Edge {
        private Vertex one, two;
        private int weight;

    }

    static class Graph {
        private HashMap<String, Vertex> vertices;
        private HashMap<Integer, Edge> edges;
    }
}
