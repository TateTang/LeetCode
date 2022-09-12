package newoffer.offerII;

import java.util.Arrays;

/**
 * @author tangmf
 * @date 2022年09月12日 12:25:​13
 * 剑指 Offer II 088. 爬楼梯的最少成本
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * 每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * 示例 1：
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 *  示例 2：
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 */
public class T088 {
    public static void main(String[] args) {
        //int[] cost = {10, 15, 20};
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new T088().minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        /*
         * dp[i]表示前i个数字到达楼顶的最低花费
         * 当前花费的最小值就是 前一个的花费加之前的花费和  前两个台阶的花费+之前的花费的最小值
         * 1.由于可以选择下标 0 或 1 作为初始阶梯，因此有 dp[0]=dp[1]=0。
         * 2.当 2≤i≤n 时，可以从下标i−1 使用 cost[i−1] 的花费达到下标 i，
         * 3.或者从下标 i−2 使用cost[i−2] 的花费达到下标 i。
         * 4.为了使总花费最小，dp[i] 应取上述两项的最小值，因此状态转移方程如下：
            dp[i]=min(dp[i−1]+cost[i−1],dp[i−2]+cost[i−2])
            依次计算 dp 中的每一项的值，最终得到的dp[n] 即为达到楼层顶部的最小花费。
         */
        int[] dp = new int[cost.length + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            //当前前花费的最小值=（前一个的花费+之前的花费和） (前两个台阶的花费+之前的花费)的其中最小值
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[cost.length];
    }
}
