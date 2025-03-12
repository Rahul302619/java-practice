package hackathon;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountOccurrencesOfUsingStream {

    public static void main(String[] args) {
        maxTest();
        allCharacters("elephant");
    }

    static void maxTest() {
        var max = Stream.of(1L, 2L, 5L, 10L, 2L)
                .max((l1,l2) -> l1.compareTo(l2))
                .orElse(null);
        System.out.println("Max Number: " + max);
    }

    public static void allCharacters(String word) {
        var occurance = Arrays.stream(word.split(""))
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));

        System.out.println(occurance);

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

        var max1 = occurrenceOfCharacters
                .entrySet()
                .stream()
                .max((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .orElse(null);

        var max2 = occurrenceOfCharacters
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .findFirst()
                .orElse(null);

        System.out.println("max:" + max);
        System.out.println("max1:" + max1);
        System.out.println("max2:" + max2);

        occurrenceOfCharacters
                .forEach((k,v) -> System.out.print(k + "-" + v));

        var joinChar = occurrenceOfCharacters
                .entrySet()
                .stream()
                .sorted((c1,c2) -> c2.getValue().compareTo(c1.getValue()))
                .map(entry -> entry.getKey() + "--" + entry.getValue())
                .collect(Collectors.joining(","));

        System.out.println(joinChar);
    }

    public static void words(String sentence) {
        var occurrenceOfWords = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println(occurrenceOfWords);
    }
}
