package daily;

/**
 * @Author tangmf
 * @Date 2021/3/23 7:44 下午
 * @Description 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 要求时间复杂度为O(n)。
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Toffer42 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray1(nums));
    }

    /**
     * 暴力解法 O(n^2)，时间复杂度超出限制了
     *
     * @param nums 数组
     */
    public static int maxSubArray(int[] nums) {
        //子数组是需要连续的，分治算法，动态规划，首先是需要求出子数组
        int max = Integer.MIN_VALUE;//设置int的最小值
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;//子数组的和，每次重新赋值
            //j从i开始 需要算上自己
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;//子数组的和大于max进行替换
                }
            }
        }
        return max;
    }

    /**
     * 暴力解法2，时间复杂度o(n)
     */
    public static int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;//设置int的最小值
        int curSum = 0;
        for (int num : nums) {
            if (curSum < 0) {//小于0不进行操作
                curSum = num;
            } else {
                curSum += num;//否则直接进行++即可
            }
            if (curSum > max) max = curSum;
        }
        return max;
    }

    /**
     * 动态规划解法，时间复杂度o(n)
     */
    public static int maxSubArray2(int[] nums) {
        int[] dp = getDp(nums);
        int max = Integer.MIN_VALUE;
        for (int j : dp) {
            if (j > max)
                max = j;//获取到dp中的最大值
        }
        return max;
    }

    private static int[] getDp(int[] nums) {
        /*   行最大值 dp[0]---->dp[j]
            sum(i,j)表示nums[i]到nums[j]的元素之后
            以sum(0,3)--->sum(3，3)为例子，求其最大值，都包含nums[3]
            所以就是nums[2]  nums[1]+nums[2] nums[0]+nums[1]+nums[2]的最大值
            恰好就是dp[2]的值，所以dp[2]<0 dp[3] =nums[3] 否则dp[3]=dp[2]+nums[3]
            得出结论
            dp[j]=dp[j-1]+nums[j] dp[j-1]>=0
            dp[j]=nums[j]  dp[j-1]<0
         */
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int j = 1; j < nums.length; j++) {
            if (dp[j - 1] >= 0) {
                dp[j] = dp[j - 1] + nums[j];
            } else {
                dp[j] = nums[j];
            }
        }
        return dp;
    }

}
