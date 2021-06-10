package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/4/24 10:35 上午 377. 组合总和 Ⅳ
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
 * 请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * <p>
 * 题目数据保证答案符合 32 位整数范围。
 * @Description
 */
public class T0424 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }

    public static int combinationSum4(int[] nums, int target) {
        /*
            分析：
            题目描述说是求组合，但又说是可以元素相同顺序不同的组合算两个组合，其实就是求排列！
            组合不强调顺序，(1,5)和(5,1)是同一个组合。
            排列强调顺序，(1,5)和(5,1)是两个不同的排列。
            动态规划五部曲分析：
            1、确定dp数组以及含义：dp[i]:总和为i的方案数
            2、确定递推公式
             - dp[i]（考虑nums[j]）可以由 dp[i - nums[j]]（不考虑nums[j]） 推导出来。
             - 因为只要得到nums[j]，排列个数dp[i - nums[j]]，就是dp[i]的一部分。
            3、初始化：dp[0]=1
            4、确定遍历序列
             - 个数可以不限使用，说明这是一个完全背包。得到的集合是排列，说明需要考虑元素之间的顺序。
             - 本题要求的是排列，那么这个for循环嵌套的顺序可以有说法了。
             - 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
             - 如果求排列数就是外层for遍历背包，内层for循环遍历物品
             - 如果把遍历nums（物品）放在外循环，遍历target的作为内循环的话，
             举一个例子：计算dp[4]的时候，结果集只有 {1,3} 这样的集合，不会有{3,1}这样的集合，因为nums遍历放在外层，3只能出现在1后面！
             - target（背包）放在外循环，将nums（物品）放在内循环，内循环从前到后遍历。
            5、推导 [1,2,3] target = 4 🌰
              dp[0]=1;
             dp[1]=dp[0]=1
             dp[2]=dp[1]+dp[0]=2
             dp[3]=dp[2]+dp[1]+dp[0]=4
             dp[4]=dp[3]+dp[2]+dp[1]+dp[0]=7
            由于nums的数都是正整数，因此我们有显然的初始化条件dp[0]=1(表示什么都不选)凑成总和为 0 的方案数为 1），
            同时最终答案为 dp[target]
            - 由于每个数值可以被选择无限次数，因此在计算任意总和的时候，保证nums中的每一位都要考虑到
         */
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
