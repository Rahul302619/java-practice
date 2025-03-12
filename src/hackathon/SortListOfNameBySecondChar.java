package hackathon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListOfNameBySecondChar {

    public static void main(String[] args) {
        var listOfName = new ArrayList<String>();
        listOfName.add("Rahul");
        listOfName.add("Rohan");
        listOfName.add("Preethvi");

        System.out.println(sortListOfNameBySecondChar(listOfName));
        System.out.println(reverseList(listOfName));
        System.out.println(listOfName);
    }

    private static List<String> sortListOfNameBySecondChar(List<String> listOfName) {
        return listOfName
                .stream()
                .sorted((n1,n2) -> n2.charAt(1) - n1.charAt(1))
                .toList();
    }

    private static List<String> reverseList(List<String> listOfName) {
        Collections.reverse(listOfName);
        return listOfName;
    }
}
