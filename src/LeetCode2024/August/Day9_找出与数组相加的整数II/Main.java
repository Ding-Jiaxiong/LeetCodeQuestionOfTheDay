package LeetCode2024.August.Day9_找出与数组相加的整数II;

import java.util.Arrays;

public class Main {

    public static int minimumAddedInteger(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // 暴力
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {  // nums[i] 和 nums[j] 就是 nums1 要移除的两个元素

                // 构建新数组【移除 nums1[i] 和 nums1[j]】
                int[] remaining = new int[nums1.length - 2];

                int index = 0;

                for (int k = 0; k < nums1.length; k++) {
                    if (k != i && k != j) {
                        remaining[index++] = nums1[k];
                    }
                }

                // 构建完成

                // 计算差值
                int diff = remaining[0] - nums2[0];
                boolean flag = true;  // 是否满足要求

                for (int k = 1; k < nums2.length; k++) {
                    if (remaining[k] - nums2[k] != diff) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    return nums2[0] - remaining[0];
                }
            }
        }

        return 0;

    }

    public static void main(String[] args) {

        int[] nums1 = {4, 20, 16, 12, 8};
        int[] nums2 = {14, 18, 10};

        System.out.println(minimumAddedInteger(nums1, nums2));

    }
}
