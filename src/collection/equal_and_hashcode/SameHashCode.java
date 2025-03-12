package collection.equal_and_hashcode;

import java.util.HashMap;
import java.util.Objects;

public class SameHashCode {
    public static void main(String[] args) {
        // All element stored in the same bucket as a linked list because of same HashCode
        sameKey();
        differentKey();
    }

    static void sameKey() {
        System.out.println("----------------Same Key----------------");
        var map = new HashMap<Student, String>();
        map.put(new Student(1, "Rahul"), "Rahul Singh");
        map.put(new Student(1, "Rohan"), "Rohan Singh");
        System.out.println(map.size());
        System.out.println("Key1 - " + map.get(new Student(1, "Rahul")));
        System.out.println("Key2 - " + map.get(new Student(1, "Rohan")));
    }

    static void differentKey() {
        System.out.println("----------------Different Key----------------");
        var map = new HashMap<Student, String>();
        map.put(new Student(1, "Rahul"), "Rahul Singh");
        map.put(new Student(2, "Rohan"), "Rohan Singh");
        map.put(new Student(3, "Rahul"), "Rahul Singh");
        System.out.println(map.size());
        System.out.println("Key1 - " + map.get(new Student(1, "Rahul")));
        System.out.println("Key2 - " + map.get(new Student(2, "Rohan")));
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
        return Objects.equals(student.roll, this.roll);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                '}';
    }
}
