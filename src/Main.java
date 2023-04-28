import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Integer[] numbers = {1,2,3};
        String[] name = {"rahul", "rohan", "roushan"};
        Arrays.stream(numbers)
                .forEach(System.out::println);
        Arrays.stream(name)
                .forEach(System.out::println);
        List nameAndNumber = List.of(1,2,3,"rahul");
        nameAndNumber
                .forEach(System.out::println);
    }
}