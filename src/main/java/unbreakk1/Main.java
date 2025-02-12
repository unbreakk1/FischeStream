package unbreakk1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
                .reduce(0, Integer::sum);  // (a, b) -> a + b
        System.out.println("Sum of all numbers: " + sum);

        // To new list
        List<Integer> doubledNumbers = numbers.stream()
                .map(number -> number * 2)
                .toList(); // .collect(Collectors.toList())

        System.out.println("Doubled Numbers List: " + doubledNumbers);

        //========================================BONUS===============================

        Path filePath = Path.of("students.csv");

        // read each line
        try (Stream<String> lines = Files.lines(filePath))
        {
            lines.forEach(System.out::println);
        }
        catch (IOException e)
        {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        // remove header
        try (Stream<String> lines = Files.lines(filePath))
        {
            lines.skip(1)
                    .forEach(System.out::println);
        }
        catch (IOException e)
        {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        // Line to Student .distinct() to remove duped "Stefan"
        try (Stream<String> lines = Files.lines(filePath))
        {
            lines.skip(1)
                    .filter(line -> !line.isBlank())
                    .distinct()
                    .map(line ->
                    {
                        String[] fields = line.split(",");
                        return new Student(
                                Integer.parseInt(fields[0].trim()),
                                fields[1].trim(),
                                fields[2].trim(),
                                Integer.parseInt(fields[3].trim())
                        );
                    })
                    .forEach(System.out::println);
        }
        catch (IOException e)
        {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}