package practice.hackathon;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class RepetiveAndNonRepetiveChar {

    public static void main(String[] args) {
        String s1="John";
        String s2=new String("John");

        HashMap<String, Integer> map = new HashMap();
        map.put(s1,20);
        map.put(s2,30);
        System.out.println(map.size());
    }

   /* private List<Character> findNonRepeative(String word) {
        word
                .chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() == 1);
    }*/
}
