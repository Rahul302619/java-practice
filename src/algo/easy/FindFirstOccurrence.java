package algo.easy;

public class FindFirstOccurrence {

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }

    private static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
