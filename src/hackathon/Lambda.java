package hackathon;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lambda {

    public static void main(String[] args) {
        example();
    }

    public static void example() {
        Runnable r = () -> {
            System.out.println("Thread started!");
        };
        new Thread(r).start();
        Predicate<Integer> agePredicate = age -> age>30;
        Function<String, Integer> countWords = String::length;
        List<Integer> validAges = Stream.of(30,40,10,20, 50)
                .filter(agePredicate)
                .collect(Collectors.toList());
        List<Integer> lengthOfWords = Stream.of("Rahul", "Rohan", "Rakesh")
                .map(countWords)
                .collect(Collectors.toList());

        System.out.println("----------------");
        IntStream.range(0,20).forEach(System.out::print);
        System.out.println("----------------");
        IntStream.rangeClosed(0,20).forEach(System.out::print);
        System.out.println("----------------");

        System.out.println(validAges);
        System.out.println(lengthOfWords);
    }
}
