package LeetCode2024.August.Day2_直角三角形;

import java.util.Arrays;

/**
 * Date: 2024-08-02
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static long numberOfRightTriangles(int[][] grid) {

        // 暴力枚举
        int row = grid.length;  // 行数
        int col = grid[0].length; // 列数

        int[] colonenum = new int[col];  // 每列的 1 的个数

        // 计算每列 1 的个数
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                colonenum[j] += grid[i][j];
            }
        }

        long res = 0;

        // 遍历每一行
        for (int i = 0; i < row; i++) {

            // 当前行中 1 的总数
            int rowonenum = Arrays.stream(grid[i]).sum();

            // 遍历当前行的每一列
            for (int j = 0; j < col; j++) {

                // 如果当前位置是 1
                if (grid[i][j] == 1) {
                    // 判断公式
                    res += (rowonenum - 1) * (colonenum[j] - 1);  // 当前 1 所能组成的直角三角形的数量，累加
                }
            }

        }

        return res;

    }

    public static void main(String[] args) {

        int[][] grid = {{0, 1, 0}, {0, 1, 1}, {0, 1, 0}};

        System.out.println(numberOfRightTriangles(grid));

    }
}
