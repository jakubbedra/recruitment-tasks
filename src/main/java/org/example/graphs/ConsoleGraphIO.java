package org.example.graphs;

import java.util.Scanner;

public class ConsoleGraphIO implements GraphIO {

    private final Scanner scanner;

    public ConsoleGraphIO() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Graph read() {
        Graph g = new Graph();

        int m = Integer.parseInt(scanner.nextLine());
        for (int e = 0; e < m; e++) {
            String[] edge = scanner.nextLine().split(" ");
            g.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
        }

        return g;
    }

    @Override
    public void write(String content) {
        System.out.println(content);
    }

}
