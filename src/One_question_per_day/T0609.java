package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/6/10 9:58 上午
 * @Description 518. 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。
 * 假设每一种面额的硬币有无限个。 
 * 示例 1:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 */
public class T0609 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(new T0609().change2(amount, coins));
    }

    public int change(int amount, int[] coins) {
        /*
        完全背包问题，完全背包方案数
       数组中的元素可以重复使用，nums放在外循环，target在内循环，内循环正序
        for(int num:nums){
            for(int i=num;i<=target;i++){
            }
            }
        给定总金额amount 和数组coins，计算金额之和等于amount的硬币组合数，其他，coins每个元素可以选取多次，
        不考虑元素，就是选取硬币的组合数
        动态规划五部曲分析：
        1、确定dp数组以及含义：dp[i]：总金额为i的硬币组合数，目标是求dp[amount]
        2、边界确定(初始化)：不选取任何影片的时候，金额之和才为0，只有一种硬币组合 dp[0]=1
        3、推导
        - 对于面额为coin的硬币，coin<=i<=amount时候，如果存在一种硬币组合的金额等于i-coin
        则在该硬币组合中增加一个面额为coin的硬币，得到一种金额之和等于i的硬币组合。
        - 遍历coins，对于其中每一种面额的硬币，更新dp中大于该面额的元素的值
        4、动态做法
        - 初始化：dp[0]=1
        - 遍历coins，其中每个元素coin，如下操作；
            -  遍历i从coin到amount，dp[i-coin]值加到dp[i]  dp[i-coin]，剩余的
        - dp[amoount]答案
        5、上面不会重复计算不同的排列。因为外层循环遍历cois的值(物品)，内层循环(背包)遍历不同的金额之和
        - 计算dp[i]是，确保金额之和等于i的硬币面额的顺序，由于顺序确定，不会重复计算不同的排列
        - 🌰：dp[3]的计算，一定是先遍历硬币面额1后遍历硬币面额2，只会出现以下2种组合
        - 3=1+1+1；3=2+1
        - 硬币面额2不可能出现在硬币面额1之前，不会出现重复计算3=2+1的情况
         */
        int[] dp = new int[amount + 1];
        dp[0] = 1;//初始化
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public int change2(int amount, int[] coins) {
        /*
        完全背包问题，完全背包方案数
       数组中的元素可以重复使用，nums放在外循环，target在内循环，内循环正序
        for(int num:nums){
            for(int i=num;i<=target;i++){
            }
            }
        典型的完全背包问题，空间大小j是不改变的
        01背包问题中，是物品只能选和不选两种情况，所以转移方程为dp[i][j] = dp[i-1][j]+dp[i-1][j-x]
        x表示第i件物品占据背包的空间大小
        完全背包问题，是物品可以重复选择，所以状态转移方程为dp[i][j] = dp[i-1][j]+dp[i][j-x]
        dp[i][j-x]是因为在选择第i件物品后，i仍然可以被选择
         */
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            int coin = coins[i - 1];
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j]; //不选第i个硬币
                if (j >= coin) {
                    dp[i][j] += dp[i][j - coin];//选择第i个硬币
                }
            }
        }
        return dp[n][amount];
    }
}
