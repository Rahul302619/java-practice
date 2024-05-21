package algo;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveAdjacentDuplicates {

    public static void main(String[] args) {
        String inputStr = "AbcCbd";
        String outputStr = removeAdjacentDuplicates(inputStr);
        System.out.println(outputStr);  // Output: "Ad"
    }

    public static String removeAdjacentDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()) {
            if(!stack.isEmpty() && Character.toLowerCase(stack.peek()) == Character.toLowerCase(c)){
                stack.pop();
            } else stack.push(c);
        }

        return stack.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
