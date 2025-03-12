package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ListPractice {

    public static void main(String[] args) {
        listExample();
    }

    public static void listExample() {

        List<String> name = List.of("Rahul","Aakash", "Vinod", "Rahul");
        //name.add("test"); //It will give runtime exception

        List<String> name1 = new ArrayList<>();
        name1.add("Rahul"); // add method returns boolean to indicate value get added or not
        name1.add("Aakash");
        name1.add("Vinod");
        name1.add("Rahul");
        name1.add(1,"Lokesh");
        name1.set(3, "Rohan"); //replace the element at the mentioned position and returned the old element

        List<String> name2 = new LinkedList<>();
        name2.add("Rahul");
        name2.add("Aakash");
        name2.add("Vinod");
        name2.add("Rahul");
        name2.add(1,"Lokesh"); //here add method return type is void
        name2.set(3, "Rohan");

        System.out.println(name);
        System.out.println(name1);
        System.out.println(name2);
    }
}
