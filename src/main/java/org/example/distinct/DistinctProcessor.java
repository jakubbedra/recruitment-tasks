package org.example.distinct;

import org.example.common.Processor;
import org.example.common.SimpleListIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DistinctProcessor implements Processor {

    private final SimpleListIO io;

    public DistinctProcessor(SimpleListIO io) {
        this.io = io;
    }

    @Override
    public void process() {
        List<Integer> input = io.read();
        int originalSize = input.size();
        Set<Integer> elements = new TreeSet<>(input);
        io.write(createString(elements, originalSize));
    }

    public String createString(Set<Integer> elements, int originalSize) {
        return elements.stream().map(Object::toString).collect(Collectors.joining(" ")) +
                "count: " + originalSize +
                "distinct: " + elements.size() +
                "min: " + elements.stream().findFirst() +
                "max: " + new ArrayList<>(elements).get(elements.size() - 1);
    }

}
