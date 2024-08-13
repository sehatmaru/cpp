package xcode;

public class Q27 {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,0,1,1,1,2,2,3,3,4}, 0));
    }

    public static int removeElement(int[] nums, int val) {
        int counter = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] != val) {
                if (counter != i) nums[counter] = nums[i];

                counter++;
            }
        }

        return counter;
    }

}
