package unbreakk1;

import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);

        // Double
        numbers.stream()
                .map(number -> number * 2)
                .forEach(System.out::println);

    }
}