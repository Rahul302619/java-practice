package practice.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetPractice {
    public static void setExample() {
        /*Set.of method don't allow duplicates, throw error IllegalArgumentException
        Set name1 = Set.of("Rahul","Aakash", "Vinod", "Rahul");*/

        Set<String> name1 = new HashSet<>();
        name1.add(null);
        name1.add("Rahul");
        name1.add("Aakash");
        name1.add("Vinod");
        name1.add("Rahul");
        //name1.add(1,"Lokesh"); //not allowed

        Set<String> name2 = new LinkedHashSet<>();
        name2.add(null);
        name2.add("Rahul");
        name2.add("Aakash");
        name2.add("Vinod");
        name2.add("Rahul");
        //name2.add(1,"Lokesh"); //not allowed

        Set<String> name3 = new TreeSet<>();
        name3.add("Rahul");
        name3.add("Aakash");
        name3.add("Vinod");
        name3.add("Rahul");
        //name3.add(null); // not allowed

        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
    }
}
