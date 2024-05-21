package basic;

import java.util.*;
import java.util.stream.Collectors;

public class FindRepetitiveAndNonRepetitive {

    public static void main(String[] args) {
        String str = "bananacdf";
        var repetitiveChars = findRepetitiveCharacters(str);
        var nonRepetitiveChars = findNonRepetitiveCharacters(str);
        System.out.println(repetitiveChars);
        System.out.println(nonRepetitiveChars);

        List<String> list = List.of("abc", "defg", "ghi", "jklm");
        var listToMap = convertListToMap(list);
        System.out.println(listToMap);

        var withIndexOf = withIndexOf(str);
        System.out.println(withIndexOf);
    }

    private static LinkedHashMap<Character, Long> findRepetitiveCharacters(String str) {
        return str.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream().filter(c -> c.getValue() > 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (c1,c2) -> c1,
                        LinkedHashMap::new
                ));
    }

    private static LinkedHashMap<Character, Long> findNonRepetitiveCharacters(String str) {
        return str.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream().filter(c -> c.getValue() == 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (c1,c2) -> c1,
                        LinkedHashMap::new
                ));
    }

    private static Map<Integer, String> convertListToMap(List<String> list) {
        return list
                .stream()
                .collect(Collectors.toMap(
                        String::length,
                        l -> l,
                        (l1,l2) -> l2, // in case of duplicate key took the latest own(l2)
                        HashMap::new
                ));
    }

    private static Map<Character, Integer> withIndexOf(String str) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = str.indexOf(c);
            int lastIndex = str.lastIndexOf(c);
            if (index != lastIndex) { // if we make it == than we will get non-repetitive
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }
        return charCount;
    }
}
