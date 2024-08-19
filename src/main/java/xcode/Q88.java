package xcode;

import java.util.Arrays;

public class Q88 {

    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        merge(new int[]{0}, 0, new int[]{1}, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m;
        for (int i = 0; i < n; i++) {
            nums1[j] = nums2[i];

            j++;
        }

        Arrays.sort(nums1);
    }

}
