package LeetCode2024.August.Day17_K周期字符串需要的最少操作次数;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int minimumOperationsToMakeKPeriodic(String word, int k) {

        int n = word.length();  // 字符串长度
        int max = 0;  // 最大重复次数

        Map<String, Integer> count = new HashMap<>();  // HashMap来记录每个长度为k的子串出现的次数

        for (int i = k; i <= n; i += k) { // 以步长为k遍历字符串

            String sub = word.substring(i - k, i);  // 获取当前位置前k个字符组成的子串

            int newcnt = count.merge(sub, 1, Integer::sum);  // 子串出现的次数加1，并返回新的次数

            max = Math.max(max, newcnt);  // 更新
        }

        return n / k - max;  // 这个就是答案
    }

    public static void main(String[] args) {

        String word = "leetcodeleet";

        int k = 4;

        System.out.println(minimumOperationsToMakeKPeriodic(word, k));

    }
}
