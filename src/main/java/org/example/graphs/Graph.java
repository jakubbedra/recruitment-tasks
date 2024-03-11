package org.example.graphs;

import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> neighbourLists;

    public Graph() {
        neighbourLists = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        neighbourLists.computeIfAbsent(u, (vertex) -> new LinkedList<>());
        neighbourLists.computeIfAbsent(v, (vertex) -> new LinkedList<>());
        neighbourLists.get(u).add(v);
        neighbourLists.get(v).add(u);
    }

    public List<Integer> getNeighbours(int u) {
        return neighbourLists.getOrDefault(u, Collections.emptyList());
    }

    public int getN() {
        return neighbourLists.size();
    }

}
