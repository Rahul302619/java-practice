package hackathon;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

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

        //limit take input as integer
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

        var groupByNameAndValueAsSalary = getEmployees()
                .stream()
                .collect(groupingBy(Employee::getName, mapping(Employee::getSalary, Collectors.toList())));

        var sumOfSalaryUsingReduce = getEmployees()
                .stream()
                .map(Employee::getSalary)
                .reduce(0.0,(acc, salary) -> acc + salary);

        var sumOfSalary = getEmployees()
                .stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        var sumOfSalaryByName = getEmployees()
                .stream()
                .collect(groupingBy(Employee::getName, summingDouble(Employee::getSalary)));

        var sortedSalary = getEmployees()
                .stream()
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .sorted((e1, e2) -> e2.getSalary().compareTo(e1.getSalary()))
                .collect(toList());

        var correctSortedSalary = getEmployees()
                .stream()
                .sorted(Comparator.comparing(Employee::getName)
                        .thenComparing(Comparator.comparing(Employee::getSalary).reversed()))
                .collect(toList());

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
        System.out.println("*******mapping2***********");
        System.out.println(groupByNameAndValueAsSalary);
        System.out.println("*******reduce***********");
        System.out.println(sumOfSalaryUsingReduce);
        System.out.println("*******sum***********");
        System.out.println(sumOfSalary);
        System.out.println("*******summingDouble***********");
        System.out.println(sumOfSalaryByName);
        System.out.println("*******sortedSalary***********");
        System.out.println(sortedSalary);
        System.out.println("*******correctSortedSalary***********");
        System.out.println(correctSortedSalary);
    }

    private static List<Employee> getEmployees() {
        return List.of(
                new Employee(1L, "Rahul Singh", 10000.0),
                new Employee(2L, "Rohan Singh", 20000.0),
                new Employee(3L, "Roshan Singh", 30000.0),
                new Employee(4L, "Sweta Singh", 40000.0),
                new Employee(5L, "Preethvi Singh", 7000.0),
                new Employee(6L, "Rahul Singh", 5000.0),
                new Employee(7L, "Rohan Singh", 6000.0)
        );
    }
}

class Employee{
    private Long id;
    private String name;
    private Double salary;

    public Employee(Long id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
