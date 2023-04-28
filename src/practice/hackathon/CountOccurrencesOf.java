package practice.hackathon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountOccurrencesOf {

    public static void allCharacters(String word) {
        Map<Character, Integer> occurrencesOfAllCharacters = new HashMap<>();
        for(int i=0; i<word.length(); i++) {
            occurrencesOfAllCharacters
                    .put(word.charAt(i), count(word, word.charAt(i)));
        }
        System.out.println(occurrencesOfAllCharacters);
    }

    private static int count(String word, char character) {
        int count = 0;
        for(int i=0; i<word.length(); i++) {
            if(word.charAt(i) == character) count++;
        }
        return count;
    }

    public static void allCharactersWithSingleLoop(String word) {
        Map<Character, Integer> occurrencesOfAllCharacters = new HashMap<>();
        for(int i=0; i<word.length(); i++) {
            if(!occurrencesOfAllCharacters.containsKey(word.charAt(i))) occurrencesOfAllCharacters.put(word.charAt(i), 1);
            else occurrencesOfAllCharacters.put(word.charAt(i), occurrencesOfAllCharacters.get(word.charAt(i)) + 1);
        }
        System.out.println(occurrencesOfAllCharacters);
    }
}
