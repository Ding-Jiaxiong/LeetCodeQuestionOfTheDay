package LeetCode2024.August.Day14_特殊数组II;

public class Main {

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {

        int n = nums.length;

        boolean[] ans = new boolean[queries.length];  // 结果数组


        if (n == 1) { // 数组长度为 1， 肯定全是 true

            for (int i = 0; i < queries.length; i++) {
                ans[i] = true;
            }
            return ans;
        }

        // 预处理相邻元素是否具有相同奇偶性
        boolean[] isSpecial = new boolean[n - 1];

        for (int i = 0; i < n - 1; i++) {
            isSpecial[i] = nums[i] % 2 != nums[i + 1] % 2;
        }

        // 前缀和数组
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) {

            prefix[i] = prefix[i - 1] + (isSpecial[i - 1] ? 0 : 1); // prefix[i] 表示从第 0 到第 i 个位置有多少个 false
        }

        for (int i = 0; i < queries.length; i++) {

            // 处理查询
            int left = queries[i][0];
            int right = queries[i][1];

            ans[i] = prefix[right] - prefix[left] == 0; // 判断区间内是否有非特殊的元素
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1};

        int[][] queries = {{0, 0}, {0, 0}, {0, 0}};

        for (boolean b : isArraySpecial(nums, queries)) {
            System.out.print(b + " ");
        }
    }
}
