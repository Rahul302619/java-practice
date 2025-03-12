package algo.easy;

import java.util.Arrays;

public class SearchInsertPosition {

    public static void main(String[] args) {
        /*System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));*/

        /*lengthOfLastWord("Hello World");
        lengthOfLastWord("   fly me   to   the moon  ");*/

        Arrays.stream(plusOne(new int[]{1, 2, 3})).forEach(System.out::print);
    }

    private static int searchInsert(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            if(target <= nums[i]) return i;
        }
        return nums.length;
    }

    public static int lengthOfLastWord(String s) {
        var sArr = s.trim().split(" ");
        return sArr[sArr.length-1].length();
    }

    public static int[] plusOne(int[] digits) {
        int length=digits.length;
        if(digits[length-1] < 9){
            digits[length-1] = digits[length-1] + 1;
            return digits;
        }

        int sum = 0;
        for(int n:digits){
            sum = sum*10 + n;
        }

        return Arrays.stream((sum + "").split("")).mapToInt(Integer::parseInt).toArray();
    }
}
