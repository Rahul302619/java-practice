package collection.equal_and_hashcode;

import java.util.HashMap;

public class WithoutEqualAndHashcode {
    public static void main(String[] args) {
        /*  With same ref and same value all value will not store because of ref check
            inside of put method also we can get the value because we have the same ref
             and in get method as well there is ref check */
        sameRef();
        /* With diff ref but same value all value will store but we can't access those
         because for retrival we don't have the ref */
        differentRef();
    }

    static void sameRef() {
        System.out.println("----------------Same Ref----------------");
        var map = new HashMap<Student2, String>();
        var student = new Student2(1, "Rahul");
        map.put(student, "Rahul Singh");
        map.put(student, "Rohan Singh");
        System.out.println(map.size());
        System.out.println("Key1 - " + map.get(student));
    }

    static void differentRef() {
        System.out.println("----------------Diff Ref----------------");
        var map = new HashMap<Student2, String>();
        map.put(new Student2(1, "Rahul"), "Rahul Singh");
        map.put(new Student2(1, "Rahul"), "Rahul Singh");
        System.out.println(map.size());
        System.out.println("Key1 - " + map.get(new Student2(1, "Rahul")));
    }
}

class Student2 {
    private int roll;
    private String name;

    public Student2(int roll, String name) {
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
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                '}';
    }
}
