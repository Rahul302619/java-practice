package practice.collection;

import java.util.*;

public class SetPractice {
    public static void setExample() {
        /*Set.of method don't allow duplicates, throw error IllegalArgumentException*/
        //Set name = Set.of("Rahul","Aakash", "Vinod", "Rahul");

        Set<String> name1 = new HashSet<>(); // Created HashMap Internally and added value as key
        name1.add(null);
        name1.add("Rahul");
        name1.add("Aakash");
        name1.add("Vinod");
        name1.add("Rahul");
        //name1.add(1,"Lokesh"); //not allowed

        Set<String> name2 = new LinkedHashSet<>(); // Created LinkedHashMap Internally and added value as key
        name2.add(null);
        name2.add("Rahul");
        name2.add("Aakash");
        name2.add("Vinod");
        name2.add("Rahul");
        //name2.add(1,"Lokesh"); //not allowed

        Set<String> name3 = new TreeSet<>(); // Created TreeMap Internally and added value as key
        name3.add("Rahul");
        name3.add("Aakash");
        name3.add("Vinod");
        name3.add("Rahul");
        //name3.add(null); // not allowed

        Set<String> name4 = new TreeSet<>(Comparator.nullsLast(Comparator.reverseOrder()));
        name4.add("Rahul");
        name4.add("Aakash");
        name4.add("Vinod");
        name4.add("Rahul");
        name4.add(null); //By adding Comparator.nullsFirst or Comparator.nullsLast

        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);
    }
}
