package basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseStringExample {

    public static void main(String[] args) {
        String word = "Rahul";
        System.out.println(reverseWord(word));

        String sentence = "My name is Rahul";
        System.out.println(reverseSentence(sentence));

        String frequencyStr = "Banana";
        System.out.println(findFrequencyOfChars(frequencyStr, "a"));
    }

    private static String reverseWord(String str) {
        return Arrays.stream(str.split(""))
                .reduce((c1, c2) -> c2 + c1)
                .orElse("");
    }

    private static String reverseSentence(String str) {
        return Arrays.stream(str.split(" "))
                //.map(ReverseStringExample::reverseWord)
                .reduce((c1, c2) -> c2 + " " + c1)
                .orElse("");
    }

    private static Integer findFrequencyOfChars(String str, String c) {
        List<String> test = Arrays.stream(str.split("")).toList();
        return Collections.frequency(test, c);
    }
}
