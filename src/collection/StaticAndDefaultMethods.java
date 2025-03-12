package collection;

import java.util.*;

public class StaticAndDefaultMethods {

    public static void main(String[] args) {
        list();
        set();
        map();
    }

    public static void list() {
        //Mostly used static methods
        List<String> list = List.of("A", "B", "C"); //Creates an immutable list
        List<String> mutable = new ArrayList<>(list);
        List<String> immutable = List.copyOf(mutable); //Creates an immutable list
        System.out.println(immutable);

        //Mostly used default methods
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
        numbers.replaceAll(n -> n * 3);
        numbers.sort(Comparator.reverseOrder());
        numbers.removeIf(n -> n % 2 == 0);
        numbers.forEach(System.out::print);
    }

    public static void set() {
        //Mostly used static methods
        Set<String> set = Set.of("A", "B", "C"); //Creates an immutable set
        Set<String> mutable = new HashSet<>(set);
        Set<String> immutable = Set.copyOf(mutable); //Creates an immutable set
        System.out.println(immutable);

        //Mostly used default methods
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3));
        numbers.removeIf(n -> n % 2 == 0);
        numbers.forEach(System.out::println);
    }

    public static void map() {
        //Mostly used static methods
        Map<Integer, String> map = Map.of(1, "A", 2, "B", 3, "C"); //Creates an immutable map
        Map<Integer, String> mutable = new HashMap<>(map);
        Map<Integer, String> immutable = Map.copyOf(mutable); //Creates an immutable map
        System.out.println(immutable);

        //Mostly used default methods
        Map<String, Integer> map1 = new HashMap<>(Map.of("A", 1, "B", 2, "C", 3));
        map1.put("D", null);
        map1.merge("D", 5, (v1,v2) -> v1+v2);
        map1.merge("E", 6, (v1,v2) -> v1+v2);
        map1.replaceAll((k, v) -> v * 2);
        map1.putIfAbsent("Alice", 4);
        map1.computeIfAbsent("Rahul", k -> k.length());
        map1.computeIfPresent("Alice", (k, v) -> v + 10);
        map1.merge("Rahul", 5, (v1,v2) -> v1+v2);
        int aScore = map1.getOrDefault("A", 50);
        int bobScore = map1.getOrDefault("Bob", 50);
        System.out.println(aScore + "--" + bobScore);
        map1.forEach((k,v) -> System.out.println(k + "--" + v));
    }
}
