package algo;

import java.util.Stack;

public class BalancedStringExample {

    public static void main(String[] args) {
        String str = "[{()}]";
        System.out.println("Is balanced: " + isBalanced(str));

        String str1 = "[{()}])";
        System.out.println("Is balanced: " + isBalanced(str1));
    }

    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c== '}' || c== ']' || c== ')') {
                if(stack.isEmpty()) return false;

                char pop = stack.pop();
                if((c == '}' && pop != '{') || (c == ']' && pop != '[') || (c == ')' && pop != '(')) return false;
            }
        }

        return  stack.isEmpty();
    }


}
