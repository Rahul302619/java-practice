package algo.easy;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {
        /*System.out.println(removeDuplicates(new int[] {1,1,2}));*/
        /*System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));*/
        removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4});
    }

    private static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
