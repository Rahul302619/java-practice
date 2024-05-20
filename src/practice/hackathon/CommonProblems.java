package practice.hackathon;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CommonProblems {

    public static void main(String[] args) {
        isPalindrome();
        reverseStringUsingStream();
        reverseSentenceUsingStream();
    }

    public static void isPalindrome() {
        String name = "radar";
        String reverseName = new StringBuilder(name).reverse().toString();
        if(name.equals(reverseName)) {
            System.out.println(name + " is palindrome(Check with string builder reverse)");
        }
    }

    public static void reverseStringUsingStream() {
        String name = "Rahul";
        var reversedString = IntStream.range(0, name.length())
                .mapToObj(i -> name.charAt(name.length() - 1 - i))
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(reversedString);

        var reversedWordUsingStream = name
                .chars()
                .mapToObj(c -> (char)c)
                .map(Object::toString)
                .reduce((first, second) -> second + first)
                .orElse("");

        System.out.println(reversedWordUsingStream);
    }

    public static void reverseSentenceUsingStream() {
        String name = "Rahul is a boy";
        var reversedString = Arrays.stream(name.split(" "))
                .reduce((first, second) -> second + " " + first)
                .orElse("");
        System.out.println(reversedString);
    }
}
