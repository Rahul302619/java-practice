package basic;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TestExample {
    public static void main(String[] args) {
        var streamOfNumber = Stream.of(1,2,3);
        streamOfNumber.filter(n -> n%2 == 0);

        streamOfNumber.forEach(System.out::println);
    }

}

enum Day {
    MONDAY, SUNDAY, SATARDAY;
}

class EmpTest{
    private int id;
    private String name;

    public EmpTest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        EmpTest empTest = (EmpTest) obj;
        return Objects.equals(id, empTest.id) && Objects.equals(name, empTest.name);
    }

/*    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }*/

    @Override
    public String toString() {
        return "EmpTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

