package practice.hackathon;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.partitioningBy;

public class Java8Stream {

    public static void example() {
        map();
        collector();
    }

    private static void map() {
        var employeesName = getEmployees()
                .stream()
                .filter(emp -> emp.getName().startsWith("R"))
                .map(Employee::getName)
                .collect(toList());

        //here loop will not iterate over each and every employee.
        //In java7 we need to iterate over each and every element to get the same result
        var lazyEvaluation = getEmployees()
                .stream()
                .filter(emp -> emp.getName().startsWith("S"))
                .findFirst()
                .orElse(null);

        //peek take input as consumer and after operation again return same object
        //sorted, min, max take input as comparator
        var changeNameToUpperCase = getEmployees()
                .stream()
                .peek(employee -> employee.setName(employee.getName().toUpperCase()))
                .sorted((e1,e2) -> e2.getName().compareTo(e1.getName()))
                .collect(toList());

        //skip take input as integer
        var skipFirst3 = getEmployees()
                .stream()
                .skip(3)
                .collect(toList());

        //limit take input as integert
        var limitUpto3 = getEmployees()
                .stream()
                .limit(3)
                .collect(toList());

        System.out.println("*******map***********");
        System.out.println(employeesName);
        System.out.println("*******lazyEvaluation***********");
        System.out.println(lazyEvaluation);
        System.out.println("*******peek and sorting***********");
        System.out.println(changeNameToUpperCase);
        System.out.println("*******skip***********");
        System.out.println(skipFirst3);
        System.out.println("*******limit***********");
        System.out.println(limitUpto3);
    }

    private static void collector() {
        //collect take input as Collector
        var groupByName = getEmployees()
                .stream()
                .collect(groupingBy(Employee::getName, toList()));

        var joinAllNameByComma = getEmployees()
                .stream()
                .map(Employee::getName)
                .collect(joining(","));

        //groupingBy take 2 input first one is Function and 2nd one is Collector
        var countNumberOfOccurrenceByName = getEmployees()
                .stream()
                .map(Employee::getName)
                .collect(groupingBy(name -> name, counting()));

        var partitioningByName = getEmployees()
                .stream()
                .collect(partitioningBy(employee -> employee.getName().startsWith("R"), toList()));

        //mapping use to change the value of the output map
        var groupByNameAndValueAsId = getEmployees()
                .stream()
                .collect(groupingBy(Employee::getName, mapping(Employee::getId, Collectors.toList())));

        System.out.println("*******groupingBy(name, list)***********");
        System.out.println(groupByName);
        System.out.println("*******joining***********");
        System.out.println(joinAllNameByComma);
        System.out.println("*******groupingBy(name, count)***********");
        System.out.println(countNumberOfOccurrenceByName);
        System.out.println("*******partitioningBy name start with R***********");
        System.out.println(partitioningByName);
        System.out.println("*******mapping***********");
        System.out.println(groupByNameAndValueAsId);
    }

    private static List<Employee> getEmployees() {
        return List.of(
                new Employee(1L, "Rahul Singh"),
                new Employee(2L, "Rohan Singh"),
                new Employee(3L, "Roshan Singh"),
                new Employee(4L, "Sweta Singh"),
                new Employee(5L, "Preethvi Singh"),
                new Employee(6L, "Rahul Singh"),
                new Employee(7L, "Rohan Singh")
        );
    }
}

class Employee{
    private Long id;
    private String name;

    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Employee emp = (Employee) obj;
        return Objects.equals(emp.id, id) && emp.name.equals(name);
    }

    @Override
    public int hashCode() {
        return (id.toString() + name).hashCode();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
