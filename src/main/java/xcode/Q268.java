package xcode;

import java.util.Arrays;

public class Q268 {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1}));
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);

        if (nums[0] != 0) return 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }

        return nums[nums.length - 1] == nums.length ? 0 : nums.length;
    }

}
