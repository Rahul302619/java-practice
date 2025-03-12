package hackathon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        for(char c : word.toCharArray()) {
            if(c == character) count++;
        }
        return count;
    }

    public static void allCharactersWithSingleLoop(String word) {
        Map<Character, Integer> occurrencesOfAllCharacters = new HashMap<>();
        for(char c: word.toCharArray()) {
            occurrencesOfAllCharacters.merge(c, 1, (k1,k2) -> k1+k2);
        }
        System.out.println(occurrencesOfAllCharacters);
    }
}
