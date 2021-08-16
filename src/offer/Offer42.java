package offer;

/**
 * @Author tangmf
 * @Date 2021/8/16 10:23 上午
 * @Description 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Offer42 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Offer42().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        /*
         *  动态规划解法
         *
         */
        int[] dp = getDp(nums);
        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            if (i > max) {
                max = i;//获取最大值
            }
        }
        return max;
    }

    private static int[] getDp(int[] nums) {
        /*   行最大值 dp[0]---->dp[j]  表示sum(0,i)-->sum(i,i)
            1、sum(i,j)表示nums[i]到nums[j]的元素之后
            2、以sum(0,3)--->sum(3，3)为例子，求其最大值，都包含nums[3]
            3、所以就是nums[2]  nums[1]+nums[2] nums[0]+nums[1]+nums[2]的最大值
            4、恰好就是dp[2]的值，
            5、所以dp[2]<0，dp[3] =nums[3] 否则dp[3]=dp[2]+nums[3]
            得出结论
            dp[j]=dp[j-1]+nums[j] dp[j-1]>=0
            dp[j]=nums[j]  dp[j-1]<0
         */
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int j = 1; j < nums.length; j++) {
            if (dp[j - 1] >= 0) {
                dp[j] = dp[j - 1] + nums[j];// dp[j]=dp[j-1]+nums[j] dp[j-1]>=0
            } else {
                dp[j] = nums[j];// dp[j]=nums[j]  dp[j-1]<0
            }
        }
        return dp;
    }
}
