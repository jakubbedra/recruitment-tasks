package org.example.graphs;

import org.example.common.Processor;

import java.util.*;

public class ConnectedComponentsProcessor implements Processor {

    private GraphIO io;

    public ConnectedComponentsProcessor(GraphIO io) {
        this.io = io;
    }

    @Override
    public void process() {
        Graph graph = io.read();

        int c = 0;
        Set<Integer> visited = new HashSet<>();
        for (int v = 1; v <= graph.getN(); v++) {
            if (!visited.contains(v)) {
                bfs(graph, visited, v);
                c++;
            }
        }

        io.write(Integer.toString(c));
    }

    private void bfs(Graph graph, Set<Integer> visited, int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        while (queue.size() != 0) {
            int u = queue.poll();
            List<Integer> neighbours = graph.getNeighbours(u);
            for (Integer v : neighbours) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }
    }

}
