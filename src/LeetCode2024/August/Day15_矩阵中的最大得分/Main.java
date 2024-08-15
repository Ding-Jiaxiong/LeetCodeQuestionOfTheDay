package LeetCode2024.August.Day15_矩阵中的最大得分;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int maxScore(List<List<Integer>> grid) {

        int m = grid.size();  // 行数
        int n = grid.get(0).size();  // 列数

        // 预计算的前一行、前一列的最大值以及当前位置的最大得分
        int[][] prerow = new int[m][n];
        int[][] precol = new int[m][n];
        int[][] dp = new int[m][n];

        // 初始化
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        int ans = Integer.MIN_VALUE;  // 初始化为最小值

        // 遍历所有元素
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // 看上方
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], grid.get(i).get(j) + precol[i - 1][j]);
                }

                // 不是第一列
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], grid.get(i).get(j) + prerow[i][j - 1]);
                }

                // 更新
                ans = Math.max(ans, dp[i][j]);

                // 计算上方和左方可以贡献的最大值
                prerow[i][j] = precol[i][j] = Math.max(dp[i][j], 0) - grid.get(i).get(j);

                // 如果不是第一行, 更新当前列的预计算值
                if (i > 0) {
                    precol[i][j] = Math.max(precol[i][j], precol[i - 1][j]);
                }

                // 不是第一列，更新当前行的预计算值
                if (j > 0) {
                    prerow[i][j] = Math.max(prerow[i][j], prerow[i][j - 1]);
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {

        ArrayList<List<Integer>> grid = new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>() {{
                add(9);
                add(5);
                add(7);
                add(3);
            }});

            add(new ArrayList<Integer>() {{
                add(8);
                add(9);
                add(6);
                add(1);
            }});

            add(new ArrayList<Integer>() {{
                add(6);
                add(7);
                add(14);
                add(3);
            }});

            add(new ArrayList<Integer>() {{
                add(2);
                add(5);
                add(3);
                add(1);
            }});
        }};

        System.out.println(maxScore(grid));

    }
}
