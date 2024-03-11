package org.example.pairs;

import org.example.common.Processor;
import org.example.common.SimpleListIO;

import java.util.*;
import java.util.stream.Collectors;

public class PairProcessor implements Processor {

    private SimpleListIO simpleListIO;

    public PairProcessor(SimpleListIO simpleListIO){
        this.simpleListIO = simpleListIO;
    }

    @Override
    public void process() {
        List<Integer> input = simpleListIO.read().stream()
                .sorted()
                .collect(Collectors.toList());

        List<String> pairs = new LinkedList<>();
        Set<Integer> numbers = new HashSet<>();
        Set<Integer> foundComplements = new HashSet<>();

        for (Integer number : input) {
            int complement = 13 - number;
            if (input.contains(complement) && !foundComplements.contains(number)) {
                int smaller = Math.min(complement, number);
                int greater = Math.max(complement, number);
                pairs.add(smaller + " " + greater);
            }
            foundComplements.add(complement);
        }

        simpleListIO.write(String.join("\n", pairs));
    }

}
