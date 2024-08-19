package xcode;

import java.util.HashMap;
import java.util.Map;

public class Q219 {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{0, 1, 3, 1}, 3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int lastIndex = map.get(nums[i]);

                if (i - lastIndex <= k) {
                    return true;
                }
            }

            map.put(nums[i], i);
        }

        return false;
    }

}
