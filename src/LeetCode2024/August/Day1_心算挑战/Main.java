package LeetCode2024.August.Day1_心算挑战;

import java.util.Arrays;

/**
 * Date: 2024-08-01
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int maximumScore(int[] cards, int cnt) {

        Arrays.sort(cards);

        int len = cards.length;

        int sum = 0;

        // 先加上 cnt 个数
        for (int i = len - cnt; i < len; i++) {
            sum += cards[i];  // 加上最后 cnt 个数
        }

        // 判断当前和的奇偶性，如果是偶就可以直接返回了
        if (sum % 2 == 0) {
            return sum;
        }

        // 尝试替换
        int x = cards[len - cnt];  // 当前相加中最小的那个数
        int ans = replacedSum(cards, cnt, sum, x);  // 把这个最小的数替换掉 【就是 x】

        for (int i = len - cnt + 1; i < len; i++) {  // 这里是遍历除了 x 之外的其他数进行尝试替换【全都尝试替换，找到最大的】

            if (cards[i] % 2 != x % 2) {

                ans = Math.max(ans, replacedSum(cards, cnt, sum, cards[i]));
                break;
            }

        }

        return ans;
    }

    private static int replacedSum(int[] cards, int cnt, int sum, int x) {  // 尝试将 cnt 个数中的某个数替换成其他数，以便其和变为偶数

        for (int i = cards.length - cnt - 1; i >= 0; i--) {  // 从还差的那个数开始看

            if (cards[i] % 2 != x % 2) {  // 找到一个最大的，奇偶性和 x 不同的数

                return sum - x + cards[i];
            }
        }

        return 0;  // 如果没找到就直接返回 0
    }

    public static void main(String[] args) {

        int[] cards = {1, 2, 8, 9};
        int cnt = 3;

        System.out.println(maximumScore(cards, cnt));

    }

}
