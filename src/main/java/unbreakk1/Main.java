package unbreakk1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(11, 1, 2, 3, 12, 4, 13, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);

        // Double
        numbers.stream()
                .map(number -> number * 2)
                .forEach(System.out::println);

        // Sort
        numbers.stream()
                .sorted()
                .forEach(System.out::println);

        // Sum
        int sum = numbers.stream()
                .reduce(0, Integer::sum);           // (a, b) -> a + b
        System.out.println("Sum of all numbers: " + sum);

        // to new list
        List<Integer> doubledNumbers = numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList()); // very long for : .toList();

        System.out.println("Doubled Numbers: " + doubledNumbers);

    }
}