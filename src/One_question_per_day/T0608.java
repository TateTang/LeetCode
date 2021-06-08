package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/6/8 10:06 上午
 * @Description 1049. 最后一块石头的重量 II
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。
 * 假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头最小的可能重量 。如果没有石头剩下，就返回 0。
 * 示例 1：
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * 示例 3：
 * 输入：stones = [1,2]
 * 输出：1
 * 转化后为0-1背包最小值问题。
 */
public class T0608 {
    public static void main(String[] args) {
        int[] stones = {31, 26, 33, 21, 40};
        System.out.println(new T0608().lastStoneWeightII3(stones));
    }

    public int lastStoneWeightII(int[] stones) {
        /*
        动态规划：0-1背包问题
        数组中的元素不可重复使用，nums放在外循环，target放在内循环，**内循环倒序**
        for(int num:nums){
            for(int i=target;i>num-1;i--){
            }
        }
        官方题解
        1、石头总重量sum，ki=-1(负号堆)之和neg，ki=1(正号堆)之和sum-neg
        ki*stonesi = (sum-neg)-neg = sum-2neg
        2、要使最后一块石头的重量尽可能的小。neg在不超g过sum/2的前提尽可能的大，可以看作是背包容量为[sum/2],
        物品和价值都为stonei的0-1背包问题
        4、定义dp[i][j] dp[i+1][j]表示前i个石头能否凑出重量j，特别地，do[0][]为不选任何石头的状态，除了dp[0][0]
        为真，其余dp[0][j]全为假
        5、对于第i个时候，考虑凑出重量j；
        - j<stones[i]，不能选第i个石头，此时有dp[i+1][j]=dp[i][j];
        - j>=stones[i]，存在选或者不选两种决策，不选时有dp[i+1][j]=dp[i][j]，选时需要考虑能否
        凑出重量j-stones[i]，即dp[i+1][j]=dp[i][j-stones[i]]，都为假则dp[i+1][j]为假，否则dp[i+1][j]为真
        6、状态转移方程如下
        dp[i+1][j]=dp[i][j] j<stones[i]
        dp[i+1][j]=dp[i][j] V dp[i][j-stones[i]]  j>=stones[i]
        V逻辑或，dp[n][]之后，所有为真的dp[n][j]中，最大的j即为neg能取到的最大值
        代入sum-2*neg中得到最后一块石头的最小重量
         */
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int n = stones.length, maxWeight = sum / 2;
        boolean[][] dp = new boolean[n + 1][maxWeight + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                if (j < stones[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = dp[i][j] || dp[i][j - stones[i]];
                }
            }
        }
        for (int j = maxWeight; ; j--) {
            if (dp[n][j]) {
                return sum - 2 * j;
            }
        }
    }

    public int lastStoneWeightII2(int[] stones) {
        /*
        动态规划：0-1背包问题
        数组中的元素不可重复使用，nums放在外循环，target放在内循环，**内循环倒序**
        for(int num:nums){
            for(int i=target;i>num-1;i--){
            }
        }
        官方题解
        1、石头总重量sum，ki=-1(负号堆)之和neg，ki=1(正号堆)之和sum-neg
        ki*stonesi = (sum-neg)-neg = sum-2neg （0<=i<=n-1）
        2、要使最后一块石头的重量尽可能的小。neg在不超g过sum/2的前提尽可能的大，可以看作是背包容量为[sum/2],
        物品和价值都为stonei的0-1背包问题
        4、定义dp[i][j] dp[i+1][j]表示前i个石头能否凑出重量j，特别地，do[0][]为不选任何石头的状态，除了dp[0][0]
        为真，其余dp[0][j]全为假
        5、对于第i个时候，考虑凑出重量j；
        - j<stones[i]，不能选第i个石头，此时有dp[i+1][j]=dp[i][j];
        - j>=stones[i]，存在选或者不选两种决策，不选时有dp[i+1][j]=dp[i][j]，选时需要考虑能否
        凑出重量j-stones[i]，即dp[i+1][j]=dp[i][j-stones[i]]，都为假则dp[i+1][j]为假，否则dp[i+1][j]为真
        6、状态转移方程如下
        dp[i+1][j]=dp[i][j] j<stones[i]
        dp[i+1][j]=dp[i][j] V dp[i][j-stones[i]]  j>=stones[i]
        V逻辑或，dp[n][]之后，所有为真的dp[n][j]中，最大的j即为neg能取到的最大值
        代入sum-2*neg中得到最后一块石头的最小重量
        优化：
        1、对于dp[i+1][]每个元素的计算之和dp[i][]的元素值相关，因此可以使用滚动数组的方式，去掉dp的第一个维度
        2、对于转移方程dp[i+1][j]=dp[i][j] || dp[i][j-stones[i]] ，去掉第一个维度之后，
        若采用原来的正序遍历，计算dp[j]时，dp[j-stones[i]]被覆盖，意味着dp[j-stones[i]]对应的是dp[i+1][j-stones[i]]
        计算的是一个错误的转移方程 dp[i+1][j]=dp[i][j] || dp[i+1][j-stones[i]]
        采用倒序遍历，消除错误，保证计算dp[j]时，dp[j-stones[i]]的值实际对应的就是dp[i][j-stones[i]]
        保证转移方程与去掉维度前一致
         */
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int maxWeight = sum / 2;
        boolean[] dp = new boolean[maxWeight + 1];
        dp[0] = true;
        for (int weight : stones) {
            for (int j = maxWeight; j >= weight; j--) {
                dp[j] = dp[j] || dp[j - weight];
            }
        }
        for (int j = maxWeight; ; j--) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
    }

    public int lastStoneWeightII3(int[] stones) {
        /*
        动态规划：0-1背包问题
        数组中的元素不可重复使用，nums放在外循环，target放在内循环，**内循环倒序**
        for(int num:nums){
            for(int i=target;i>num-1;i--){
            }
        }
        官方题解 推导
        1、假设总重量为sum，其他neg个石头做重量相减操作 neg 负号堆 sum-neg 正号堆
        2、计算结果：(sum-neg)-neg = nsum -2*neg
        3、求最小重量，neg 趋近于 sum/2，且neg大于0
        实现流程
        1、根据推导，当石头最小可能重量时候，最好子集数组石头的总重量，趋近于且最大为sum/2
        2、构建dp数组，dp[i]表示，是否有子集数组，重量和为i
        3、遍历stones数组，生成dp数组的值
        4、从最大值开始，遍历dp数组，寻找最大i的值，得出结果
         */
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int maxWeight = sum / 2;//石头最小可能重量的时候，最好子集数组石头重量，趋近于且最大为sum/2
        boolean[] dp = new boolean[maxWeight + 1];//表示是否有子集数组，重量和为i
        dp[0] = true;
        for (int stone : stones) {
            for (int i = maxWeight; i >= stone; i--) {
                dp[i] = dp[i] || dp[i - stone];
            }
        }
        //从最大值开始，遍历dp数组，寻找最大i的值
        for (int i = maxWeight; ; i--) {
            if (dp[i]) {
                return sum - 2 * i;
            }
        }
    }
}
