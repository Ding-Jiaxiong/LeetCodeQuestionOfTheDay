package LeetCode2024.August.Day3_正方形中的最多点数;

import java.util.Arrays;

/**
 * Date: 2024-08-03
 *
 * @author Ding Jiaxiong
 */

public class Main {

    // 主要就是找到每个点到原点的最大距离，然后找出能够构成正方形的最多点数
    public static int maxPointsInsideSquare(int[][] points, String s) {

        // 一个数组记录每个点的最小距离
        int[] mindis = new int[26];

        Arrays.fill(mindis, Integer.MAX_VALUE);   // 初始化为一个大值

        int secmindis = Integer.MAX_VALUE;

        int len = s.length();  // 字符串长度

        for (int i = 0; i < len; i++) {  // 遍历每个字符

            int x = points[i][0], y = points[i][1];  // 当前遍历点的 x 和 y 坐标

            int index = s.charAt(i) - 'a';  // 当前字符在小写字母中的索引 a → 0，z → 25

            int dis = Math.max(Math.abs(x), Math.abs(y));  // 当前点到原点的最大距离【横向或纵向】

            if (dis < mindis[index]) {  // 当前距离比字符 j 的最小距离更小
                secmindis = Math.min(secmindis, mindis[index]);   // 更新第二小距离
                mindis[index] = dis;  // 更新字符 index 的最小距离
            } else if (dis < secmindis) {  // 如果当前距离比第二小的距离讲
                secmindis = dis;
            }
        }

        int maxPointsNum = 0;

        for (int dis : mindis) {
            if (dis < secmindis) {
                maxPointsNum++;
            }
        }

        return maxPointsNum;
    }

    public static void main(String[] args) {

        int[][] points = {{2, 2}, {-1, -2}, {-4, 4}, {-3, 1}, {3, -3}};

        String s = "abdca";

        System.out.println(maxPointsInsideSquare(points, s));

    }

}
