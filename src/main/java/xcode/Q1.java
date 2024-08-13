package xcode;

import java.util.Arrays;

public class Q1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        boolean done = false;

        for (int i=0; i<nums.length; i++) {
            for (int j=i; j<nums.length; j++) {
                int a = nums[i];
                int b = nums[j];

                int sum = a+b;

                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    done = true;
                }

                if (done) break;
            }

            if (done) break;
        }

        return result;
    }

}
