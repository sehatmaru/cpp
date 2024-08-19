package xcode;

import java.util.Arrays;

public class Q217 {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{0, 1, 3, 2}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length-1 && nums[i] == nums[i+1]) return true;
        }

        return false;
    }

}
