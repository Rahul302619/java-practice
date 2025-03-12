package collection.equal_and_hashcode;

import java.util.HashMap;
import java.util.Objects;

public class SameEqual {
    public static void main(String[] args) {
        // All element stored in the different bucket because of diff HashCode
        var map = new HashMap<Student1, String>();
        map.put(new Student1(1, "Rahul"), "Rahul Singh");
        map.put(new Student1(2, "Rahul"), "Roshan Singh");
        System.out.println(map.size());
        System.out.println("Key1 - " + map.get(new Student1(1, "Rahul")));
        System.out.println("Key2 - " + map.get(new Student1(2, "Rohan")));
    }
}

class Student1 {
    private int roll;
    private String name;

    public Student1(int roll, String name) {
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
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.roll);
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                '}';
    }
}
