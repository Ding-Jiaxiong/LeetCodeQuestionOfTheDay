package LeetCode2024.August.Day11_不相交的线;

public class Main {

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {

        // 其实就是找 LCS
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m + 1][n + 1];  // dp[i][j] 表示 nums1[0..i-1] 和 nums2[0..j-1] 的最大连线数

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // 如果 nums1[i-1] 和 nums2[j-1] 相等，则可以绘制一条连线
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {

                    // 否则，最大连线数取决于不包括当前元素的情况
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 4, 2};
        int[] nums2 = {1, 2, 4};

        System.out.println(maxUncrossedLines(nums1, nums2));

    }
}
