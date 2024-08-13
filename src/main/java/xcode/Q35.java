package xcode;

public class Q35 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 1) {
            return target >= nums[0] ? 1 : 0;
        }

        for (int i=0; i<nums.length; i++) {
            if (i == nums.length-1) {
                return nums.length;
            }

            if (nums[i] <= target && nums[i+1] >= target) {
                return i+1;
            }
        }

        return 0;
    }

}
