package LeetCode2024.August.Day13特殊数组I;

public class Main {

    public static boolean isArraySpecial(int[] nums) {

        int n = nums.length;

        if (n == 1) return true;

        for (int i = 0; i < n - 1; i++) {

            int j = i + 1;

            if (nums[i] % 2 == nums[j] % 2) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums = {2, 1, 4};

        System.out.println(isArraySpecial(nums));

    }
}
