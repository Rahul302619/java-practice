package practice.collection;

import java.util.*;

public class MapPractice {
    public static void mapExample() {
        Map<Integer, String> map = Map.of(1, "Rahul", 2, "Rohan", 3, "Roushan", 4, "Rahul");

        /*Map.of method don't allow duplicates, throw error IllegalArgumentException
        Map<Integer, String> map1 = Map.of(1, "Rahul", 2, "Rohan", 3, "Roushan", 1, "Rahul");*/

        Map<String, String> map1 = new HashMap<>(); //orders are not preserved
        System.out.println(map1.put("Rahul", "Rahul"));//return null because key is not present in the map
        map1.put("Rohan", "Rohan");
        map1.put("Roushan", "Roushan");
        System.out.println(map1.put("Rahul", "Vinod")); // return added key because key is already present in the map and replace the old value with new one
        map1.put(null, "Vivek");
        map1.put(null, "Vivek1");
        map1.put("Suraj", null);
        map1.put("Suresh", null);

        Map<String, String> map2 = new LinkedHashMap<>();
        map2.put("Rahul", "Rahul");
        map2.put("Rohan", "Rohan");
        map2.put("Roushan", "Roushan");
        map2.put("Rahul", "Vinod");
        map2.put(null, "Vivek");
        map2.put(null, "Vivek1");
        map2.put("Suraj", null);
        map2.put("Suresh", null);

        Map<String, String> map3 = new TreeMap<>();
        map3.put("Rahul", "Rahul");
        map3.put("Rohan", "Rohan");
        map3.put("Aakash", "Roushan");
        map3.put("Rahul", "Vinod");
        //map3.put(null, "Vivek"); // not allow
        map3.put("Suraj", null);
        map3.put("Suresh", null);

        Map<String, String> map4 = new Hashtable<>();
        map4.put("Rahul", "Rahul");
        map4.put("Rohan", "Rohan");
        map4.put("Roushan", "Roushan");
        map4.put("Rahul", "Vinod");
        //map4.put(null, "Vivek"); // not allow
        //map4.put("Suraj", null); // not allow
        //map4.put("Suresh", null); // not allow

        System.out.println(map);
        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);
        System.out.println(map4);
    }

    public static void mapWithCustomClassExample() {
        Student student = new Student(1, "Rahul");
        Student student1 = new Student(2, "Rohan");
        Student student2 = new Student(1, "Rahul Kumar");
        Student student3 = new Student(3, "Rohan");

        /*Map.of method don't allow duplicates, throw error IllegalArgumentException
        Map<Student, String> map = Map.of(student, "Rahul", student1, "Rohan", student2, "Roushan");*/

        Map<Student, String> map1 = new HashMap<>();
        map1.put(student, "Rahul");
        map1.put(student1, "Rohan");
        map1.put(student2, "Roushan");
        map1.put(student3, "Rakesh");

        System.out.println(map1);

        /*Not allowed because Student haven't implemented Comparable
        Map<Student, String> map3 = new TreeMap<>();
        map3.put(student, "Rahul");
        map3.put(student1, "Rohan");
        map3.put(student2, "Roushan");
        map3.put(student3, "Vinod");

        System.out.println(map3);*/

        /*Equal based on id && hash based on id and name
        {Student{roll=1, name='Rahul'}=Rahul, Student{roll=1, name='Rahul Kumar'}=Roushan, Student{roll=2, name='Rohan'}=Rohan}*/

        /*Equal based on id and name && hash based on id
        {Student{roll=1, name='Rahul'}=Rahul, Student{roll=1, name='Rahul Kumar'}=Roushan, Student{roll=2, name='Rohan'}=Rohan}*/

        /*Equal based on name && hash based on id
        {Student{roll=1, name='Rahul'}=Rahul, Student{roll=1, name='Rahul Kumar'}=Roushan, Student{roll=2, name='Rohan'}=Rohan, Student{roll=3, name='Rohan'}=Rakesh}*/
    }
}

class Student {
    private int roll;
    private String name;

    public Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        return student.roll == this.roll /*&& student.name.equals(this.name)*/;
    }

    @Override
    public int hashCode() {
        return (this.roll + "" + this.name).hashCode();
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                '}';
    }
}
