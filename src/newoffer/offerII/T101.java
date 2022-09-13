package newoffer.offerII;

/**
 * @author tangmf
 * @date 2022年09月13日 10:38:​57
 * 剑指 Offer II 101. 分割等和子集
 * 给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：nums 可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：nums 不可以分为和相等的两部分
 */
public class T101 {
    public static void main(String[] args) {
        //int[] nums = {1, 5, 11, 5};
        int[] nums = {1, 2, 3, 5};
        System.out.println(new T101().canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        /*
        先求数组所有数字之和,然后计算是否为偶数,只有偶数才能分成相等的两份。
        然后问题就变成了在nums所有元素中选i个数,相加能否达到所有元素和的一般,和01背包问题相似,可以用相同的方法求解
         */
        //sum用于计算数组数字总和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //总和不为偶数直接返回false即可
        if (sum % 2 == 1) {
            return false;
        } else {
            // 保存总和的一半也就是两个数组分别要组成的数字总和
            int target = sum / 2;
            // 定义dp数组,dp[i][j]表示在nums里选择i个数相加得到的不超过j的最大数,相当于01背包问题的变形
            int[][] dp = new int[nums.length + 1][target + 1];
            // 初始化，i为0的时候dp[i][j]=0，所以从i为1开始循环直到i等于nums元素个数,表示选择的数字个数从1个数到nums所有元素
            for (int i = 1; i <= nums.length; i++) {
                // 数组下标从0开始,所以当前数表示为nums[i - 1]而不是nums[i]
                int num = nums[i - 1];
                // j为0的时候 dp[i][j]=0，最大数不超过j，j从1开始循环
                for (int j = 1; j <= target; j++) {
                    // 表示不选第i个数字 参考T0609
                    dp[i][j] = dp[i - 1][j];
                    // 如果j >= nums[i - 1],说明可以添加该数
                    if (j >= num) {
                        //dp[i][j]的最大值为不选该数时的dp[i - 1][j]和选了该数时的dp[i - 1][j - num] + num两者之间的最大值
                        //dp[i - 1][j - num] + num表示从i个数中选择i-1个数之和不超过[j - num]的最大值加上当前值
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - num] + num);
                    }
                }
            }
            //返回最大值
            return dp[nums.length][target] == target;
        }
    }
}
