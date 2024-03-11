package org.example;

import org.example.common.ConsoleSimpleListIO;
import org.example.common.Processor;
import org.example.distinct.DistinctProcessor;
import org.example.graphs.ConnectedComponentsProcessor;
import org.example.graphs.ConsoleGraphIO;
import org.example.pairs.PairProcessor;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<Integer, Processor> processorMap = new HashMap<>();
    static {
        processorMap.put(1, new DistinctProcessor(new ConsoleSimpleListIO()));
        processorMap.put(2, new PairProcessor(new ConsoleSimpleListIO()));
        processorMap.put(3, new ConnectedComponentsProcessor(new ConsoleGraphIO()));
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Exactly one argument containing the task number should be provided.");
        }
        Processor processor = processorMap.get(Integer.parseInt(args[0]));
        processor.process();
    }

}
