package algo.easy;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        /*System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));*/
        System.out.println(longestCommonPrefix(new String[]{"flower", "fbcdef", "flowergfhfth"}));
    }

    private static String longestCommonPrefix(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
