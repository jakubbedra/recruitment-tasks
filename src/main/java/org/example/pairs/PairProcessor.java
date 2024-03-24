package org.example.pairs;

import org.example.common.Processor;
import org.example.common.SimpleListIO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PairProcessor implements Processor {

    private static final int SEARCHED_SUM = 13;

    private SimpleListIO simpleListIO;

    public PairProcessor(SimpleListIO simpleListIO) {
        this.simpleListIO = simpleListIO;
    }

    @Override
    public void process() {
        List<Integer> input = simpleListIO.read().stream()
                .sorted()
                .collect(Collectors.toList());

        Integer[] numbers = input.toArray(new Integer[0]);
        List<String> pairs = new LinkedList<>();

        int n = input.size();
        for (int v = 0; v < n; v++) {
            for (int u = v; u < n; u++) {
                if (numbers[v] + numbers[u] == SEARCHED_SUM) {
                    pairs.add(numbers[v] + " " + numbers[u]);
                }
            }
        }

        simpleListIO.write(String.join("\n", pairs));
    }

}
