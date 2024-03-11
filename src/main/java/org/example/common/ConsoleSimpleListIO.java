package org.example.common;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleSimpleListIO implements SimpleListIO {

    private final Scanner scanner;

    public ConsoleSimpleListIO() {
        scanner = new Scanner(System.in);
    }

    @Override
    public List<Integer> read() {
        String[] split = scanner.nextLine().split(" ");
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public void write(String content) {
        System.out.println(content);
    }

}
