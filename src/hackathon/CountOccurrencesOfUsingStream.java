package hackathon;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOccurrencesOfUsingStream {

    public static void allCharacters(String word) {
        var occurrenceOfCharacters = word
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(occurrenceOfCharacters);

        var max = occurrenceOfCharacters
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        System.out.println(max);

        occurrenceOfCharacters
                .forEach((k,v) -> System.out.println(k + "-" + v));

        var joinChar = occurrenceOfCharacters
                .entrySet()
                .stream()
                .sorted((c1,c2) -> c2.getValue().compareTo(c1.getValue()))
                .map(entry -> entry.getKey().toString() + entry.getValue())
                .collect(Collectors.joining());

        System.out.println(joinChar);
    }

    public static void words(String sentence) {
        var occurrenceOfWords = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println(occurrenceOfWords);
    }
}
