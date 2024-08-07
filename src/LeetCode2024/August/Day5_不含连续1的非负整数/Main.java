package LeetCode2024.August.Day5_不含连续1的非负整数;

public class Main {

    // 【ChatGPT 版动态规划】
    public static int findIntegers(int n) {
        // 将数字转换为二进制字符串表示
        String binary = Integer.toBinaryString(n);
        // 获取二进制字符串的长度
        int length = binary.length();

        // dp数组，用于存储长度为i的以0和1结尾的非连续1的数字个数
        int[] dp = new int[length + 1];
        // dp[0] 表示长度为0时只有一个数字（空字符串）
        dp[0] = 1;
        // dp[1] 表示长度为1时有两个数字 0 和 1
        dp[1] = 2;

        // 计算长度为2到length的二进制数的dp值
        for (int i = 2; i <= length; i++) {
            // 长度为 i 的二进制数的非连续1的数字个数等于长度为 i-1 和 i-2 的数字个数之和
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 初始化 result 为 0，用于累加计算的结果
        int result = 0;
        // 初始化 prevBit 为 0，用于记录前一个比特位的值
        int prevBit = 0;
        // 遍历二进制字符串
        for (int i = 0; i < length; i++) {
            // 如果当前位是 '1'
            if (binary.charAt(i) == '1') {
                // 将 dp[length - i - 1] 累加到 result 中
                result += dp[length - i - 1];
                // 如果前一个比特位也是 '1'
                if (prevBit == 1) {
                    // 返回当前的 result 值
                    return result;
                }
                // 设置 prevBit 为 1
                prevBit = 1;
            } else {
                // 如果当前位是 '0'，则设置 prevBit 为 0
                prevBit = 0;
            }
        }

        // 返回 result + 1，包含 n 自身
        return result + 1;
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(findIntegers(n));

    }
}
