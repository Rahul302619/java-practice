package collection;

import java.util.ArrayList;

public class CollectionTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list.add("Rahul"));
        System.out.println(list.add("Aakash"));
        System.out.println(list.set(1, "Rohan"));
        System.out.println(list);
    }
}
