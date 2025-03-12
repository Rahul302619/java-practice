package algo.easy;

import java.util.ArrayDeque;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }

    private static boolean isValid(String s) {
        if(s == null || s.length()%2 != 0) return false;
        var charArr = s.toCharArray();

        var stack = new ArrayDeque<Character>();

        for(char c: charArr) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                char pop = stack.pop();
                if((pop == '(' && c != ')') || (pop == '{' && c != '}') || (pop == '[' && c != ']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
