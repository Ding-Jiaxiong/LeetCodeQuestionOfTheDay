package LeetCode2024.August.Day8_找出与数组相加的整数I;

import java.util.Arrays;

public class Main {

    public static int addedInteger(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        return nums2[nums2.length - 1] - nums1[nums1.length - 1];

    }

    public static void main(String[] args) {

        int[] nums1 = {2, 6, 4};
        int[] nums2 = {9, 7, 5};

        System.out.println(addedInteger(nums1, nums2));

    }
}
