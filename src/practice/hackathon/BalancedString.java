package practice.hackathon;

import java.util.Stack;

public class BalancedString {

    public static void main(String[] args) {
        String str = "[{[()]}](){}";
        boolean balanced = isBalancedUsingSwitch(str);
        if (balanced) {
            System.out.println("The string is balanced.");
        } else {
            System.out.println("The string is not balanced.");
        }
    }

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for(char c: str.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if(c == ')' || c == '}' || c == ']') {
                if(stack.isEmpty()) return false;

                char pop = stack.pop();
                if ((c == ')' && pop != '(') || (c == ']' && pop != '[') || (c == '}' && pop != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isBalancedUsingSwitch(String str) {
        var stack = new Stack<Character>();
        for (char ch : str.toCharArray()) {
            switch (ch) {
                case '(' -> stack.push(ch);
                case '[' -> stack.push(ch);
                case '{' -> stack.push(ch);
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
