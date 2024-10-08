package xcode;

public class Q26 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        int result = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[result] < nums[i]) {
                result++;
                nums[result] = nums[i];
            }
        }

        return result;
    }

}
