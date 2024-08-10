package LeetCode2024.August.Day10_找到Alice和Bob可以相遇的建筑;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {

        // 离线 + 二分单调栈【知识范畴无】

        int n = heights.length;  // 建筑数量
        int m = queries.length;  // 查询数量

        List<int[]>[] query = new List[n];  // 存储查询

        for (int i = 0; i < n; i++) {

            query[i] = new ArrayList<int[]>();  // 初始化每个列表
        }

        int[] ans = new int[m];  // 结果数组

        List<Integer> st = new ArrayList<>();  // 列表模拟栈来存储可以看到的建筑的索引

        // 处理每个查询
        for (int i = 0; i < m; i++) {

            int a = queries[i][0]; // Alice 的位置
            int b = queries[i][1]; // Bob 的位置

            if (a > b) {  // Alice 在 Bob 的右边，则交换位置
                int tmp = a;
                a = b;
                b = tmp;
            }

            if (a == b || heights[a] < heights[b]) {  // 如果 Alice 和 Bob 在同一个位置或者 Bob 所在的建筑更高

                ans[i] = b;  // Alice 可以直接看到 Bob，答案为 b
                continue; // 跳过当前查询
            }

            query[b].add(new int[]{i, heights[a]});
        }

        int top = -1;  // 初始化栈的顶部指针

        for (int i = n - 1; i >= 0; i--) { // 从右向左遍历建筑

            for (int j = 0; j < query[i].size(); j++) {  // 处理与当前建筑相关的查询

                int q = query[i].get(j)[0];  // 查询索引
                int val = query[i].get(j)[1]; // Alice 所在建筑的高度

                if (top == -1 || heights[st.get(0)] <= val) {  // 如果栈为空或栈顶建筑的高度不高于 Alice 所在建筑
                    ans[q] = -1;  // Alice 和 Bob 无法相遇，答案为 -1
                    continue;
                }

                int left = 0;
                int right = top;  // 二分查找指针

                while (left <= right) {

                    int mid = (left + right) >> 1;  // 中间位置

                    if (heights[st.get(mid)] > val) {  // 如果中间建筑的高度高于 Alice 所在建筑

                        left = mid + 1;  // 移动左指针
                    } else {

                        right = mid - 1;  // 移动右指针
                    }
                }

                ans[q] = st.get(right);  // 最左边的建筑是栈中存储的建筑
            }

            while (top >= 0 && heights[st.get(top)] <= heights[i]) {  // 移除栈顶高度不高于当前建筑的建筑

                st.remove(st.size() - 1);  // 移除栈顶建筑

                top--;  // 更新栈顶指针
            }

            st.add(i);  // 当前建筑的索引添加到栈中
            top++;  // 更新栈顶指针
        }

        return ans;
    }


    public static void main(String[] args) {

        int[] heights = {6, 4, 8, 5, 2, 7};

        int[][] queries = {{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}};

        for (int query : leftmostBuildingQueries(heights, queries)) {

            System.out.print(query + " ");
        }

    }
}
