package One_question_per_day;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2021/4/16 11:42 上午
 * @Description 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金
 * 。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * 来
 */
public class T0415 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        /*
         * 动态规划解法，房屋首尾相连接
         * 1、首先考虑最简单的解法
         *  - 只有一间房屋，偷盗该房屋
         *  - 两间房屋，只能偷盗其中一个金额最大的
         * 2、房屋数量在两间间以上，对于k（k>2）间房屋，需要考虑首尾相连接的情况，保证第一间房屋和最后一间房屋不同时偷窃
         *  - 1、因为偷窃了第一间房屋，就不能偷窃最后一间房屋，所以偷窃房屋的范围是在第一间房屋到倒数第二件房屋
         *  - 2、因为偷窃了最后一间房屋，就不能偷窃第一间房屋，所以偷窃房屋的返回是在第二件房屋到最后一间房屋
         *  - 3、不偷窃第一间房屋，范围[0:n-2];不偷窃最后一间房屋，范围[1:n-1]
         * 3、对于两段下标范围分别计算可以偷窃到的最高总金额，其中的最大值即为在n间房屋中可以偷窃到的最高总金额
         *  - 假设偷窃房屋的下标范围[start:end]，用dp[i]表示下标范围在[start:i]可以偷窃到的最大值
         *  - 状态转移方程 dp[i]=Max(dp[i-2]+nums[i],dp[i-1])
         * 4、边界条件
         *  - dp[start] = nums[start] 一间房屋，偷窃
         *  - dp[start=1] = max(nums[start],nums[start+1]) 两间房屋，偷窃总金额较大的
         * dp[n-1]就是最高总金额
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //return Math.max(robRange(nums, 0, nums.length - 2),
        //        robRange(nums, 1, nums.length - 1));
        /*
        环状排列意味着第一个房子和最后一个房子中只能选择一个偷窃，因此可以把此环状排列房间问题约化 为两个单排排列房间子问题
        1.在不偷窃第一个房子的情况下(即mums[1：])，最大金额是p1
        2.在不偷窃最后一个房子的情况下(即nuns[：n-1])，最大金额是P2
        综合偷窃最大金额：为以上两种情况的较大值，即max(p1，p2)。
        解决单排排列问题即可，也就是打家劫舍I问题即可
         */
        return Math.max(myRob(Arrays.copyOfRange(nums, 1, nums.length)), myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    public static int robRange(int[] nums, int start, int end) {
        /*
         * 动态规划解法，房屋首尾相连接
         * 1、首先考虑最简单的解法
         *  - 只有一间房屋，偷盗该房屋
         *  - 两间房屋，只能偷盗其中一个金额最大的
         * 2、房屋数量在两间间以上，对于k（k>2）间房屋，需要考虑首尾相连接的情况，保证第一间房屋和最后一间房屋不同时偷窃
         *  - 1、因为偷窃了第一间房屋，就不能偷窃最后一间房屋，所以偷窃房屋的范围是在第一间房屋到倒数第二件房屋
         *  - 2、因为偷窃了最后一间房屋，就不能偷窃第一间房屋，所以偷窃房屋的返回是在第二件房屋到最后一间房屋
         *  - 3、不偷窃第一间房屋，范围[0:n-2];不偷窃最后一间房屋，范围[1:n-1]
         * 3、对于两段下标范围分别计算可以偷窃到的最高总金额，其中的最大值即为在n间房屋中可以偷窃到的最高总金额
         *  - 假设偷窃房屋的下标范围[start:end]，用dp[i]表示下标范围在[start:i]可以偷窃到的最大值
         *  - 状态转移方程 dp[i]=Max(dp[i-2]+nums[i],dp[i-1])
         * 4、边界条件
         *  - dp[start] = nums[start] 一间房屋，偷窃
         *  - dp[start=1] = max(nums[start],nums[start+1]) 两间房屋，偷窃总金额较大的
         * dp[n-1]就是最高总金额
         */
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    public static int myRob(int[] nums) {
        /*
         * 动态规划解法
         * 1、首先考虑最简单的解法
         *  - 只有一间房屋，偷盗该房屋
         *  - 两间房屋，只能偷盗其中一个金额最大的
         * 2、房屋数量在两间以上，对于k（k>2）间房屋，有两个选项，因为不相邻
         *  - 偷窃第k间房屋，就不能偷窃第k-1间房屋，偷窃总金额为前k-2房屋的最高总金额+第k间房屋的金额之和
         *  - 不偷窃第k间房屋，偷窃总金额为前 k-1间房屋的最高总金额
         * 3、两个选项中选择偷窃总金额较大的选项，该选项对应的偷窃总金额= 前k间房屋能够偷窃到的最高总金额
         * 4、dp[i]表示前i间房屋能够偷窃到的最高总金额，有如下状态方程
         *  - dp[i]=Max(dp[i-2]+nums[i],dp[i-1])
         * 5、边界条件出来
         *  - dp[0] =nums[0]  一间房屋
         *  - dp[1]=max(nums[0],nums[1]) 两间房屋
         * 6、🌰 {1, 2, 3, 1}
         *  - 1 号房间的最大盗窃值1 即为dp[1] =1
         *  - 2 号房间最大盗窃值2 即为dp[2] =2
         *  - 3 号房间自身num=3 dp[3] = Max(dp[2],dp[1]+num) = 4 最大盗窃值为4
         * dp[length-1]就是最高总金额
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
