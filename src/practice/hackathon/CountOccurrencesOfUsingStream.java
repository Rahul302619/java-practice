package practice.hackathon;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountOccurrencesOfUsingStream {

    public static void allCharacters(String word) {
        var occurrenceOfCharacters = word
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(occurrenceOfCharacters);
    }

    public static void words(String sentence) {
        var occurrenceOfWords = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println(occurrenceOfWords);
    }
}
