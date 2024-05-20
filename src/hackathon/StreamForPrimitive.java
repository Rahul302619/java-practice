package hackathon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamForPrimitive {
    public static void example() {
        int[] arr = { 1, 2, 3, 4, 5 };

        var descending = Arrays.stream(arr)
                .boxed()
                .sorted((n1, n2)-> n2-n1)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(descending);

        char[] charArr = { 'A', 'B', 'E', 'D' };
        List<Character> listArray = new ArrayList<>();
        for (char c : charArr) {
            listArray.add(c);
        }

        var ascending = listArray
                .stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(ascending);
    }
}
