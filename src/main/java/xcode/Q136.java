package xcode;

import java.util.Arrays;

public class Q136 {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1}));
    }

    public static int singleNumber(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            System.out.println(Arrays.binarySearch(nums, nums[i]));
            if (Arrays.binarySearch(nums, nums[i]) > 0) i++;
            else return nums[i];
        }

        return 0;
    }

}
