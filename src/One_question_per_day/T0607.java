package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/6/7 10:09 上午
 * @Description 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 * 输入：nums = [1], target = 1
 * 输出：1
 */
public class T0607 {
    int count = 0;

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(new T0607().findTargetSumWays3(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        /*
        结果等于target的数量
        方法1：回溯方法
        1、数组nums的每个元素可以添加符号+或者-，因此每个元素有2中添加符号的方法。
        2、n个数有2^n中添加符号的方法，对应2^n中不同表达式。
        3、n个元素都添加符号之后，得到一种表达式，表达式的结果等于 target，代表符合计数器+1
        4、使用回溯，维护一个计数器count target = 结果时 +1。
        5、遍历完成所有的表达式之后，阔以得到结果等于目标数target的表达式的数目
        时间复杂度：O(2^n)
        空间复杂度：O(n)
         */
        backTrack(nums, target, 0, 0);
        return count;
    }

    /**
     * 回溯
     *
     * @param nums   数组
     * @param target 目标值
     * @param index  下标
     * @param sum    总和
     */
    public void backTrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backTrack(nums, target, index + 1, sum + nums[index]);
            backTrack(nums, target, index + 1, sum - nums[index]);
        }
    }

    public int findTargetSumWays2(int[] nums, int target) {
        /*
        结果等于target的数量
        方法1：动态规划解法 转化问题以后为0-1背包方案数问题。
        0-1背包问题
        数组中的元素不可重复使用，nums放在外循环，target放在内循环，**内循环倒序**
        for(int num:nums){
        for(int i=target;i>num-1;i--){
            }
        }
        1、元素总和sum, - 号元素之和neg，+ 号元素之和sum-neg，有(sum-neg) -neg = target neg = (sum-target)/2
        2、nums中元素非负数，neg也是非负整数。所以前提是sum-target是非负偶数，若不符合该条件直接返回0
        3、上面成立，转化在数组nums中选取若干元素，使得这些元素之和等于neg，计算选取元素的方案数，使用dp
        4、二维数组dp，dp[i][j]表示数组nums的前i个数中选取元素，使得元素之和等于j的方案数。nums长度为n，最终答案为dp[n][neg]
        5、边界条件 dp[0][j]=1 j=0（等于0的方案数）; dp[0][j]=0 j>1
        6、1<=i<=n，对于数组nums中的第i个元素num（i的计算从1开始），遍历0<=j<=neg，计算dp[i][j]值
        - 如果j<num，不能选num，此时有dp[i][j]=dp[i-1][j]
        - 如果j>=num，不选num，方案数dp[i-1][j]，选num，方案数dp[i-1][j-num]，此时
        dp[i][j]=dp[i-1][j]+dp[i-1][j-num]
        num = nums[i-1]
        状态方程也是
        dp[i][j]=dp[i-1][j]                   j<nums[i]
        dp[i][j]=dp[i-1][j]+dp[i-1][num] j>=nums[i]
        方案数就是dp[n][neg]
         */
        int sum = 0;
        for (int num : nums) {
            sum += num;//求的总和
        }
        int diff = sum - target;//总和减去目标和
        if (diff < 0 || diff % 2 != 0) {
            return 0;//必须要是非负偶数
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;//初始化
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }

    public int findTargetSumWays3(int[] nums, int target) {
        /*
        结果等于target的数量
        方法1：动态规划解法 转化问题以后为0-1背包方案数问题。
        0-1背包问题
        数组中的元素不可重复使用，nums放在外循环，target放在内循环，**内循环倒序**
        for(int num:nums){
        for(int i=target;i>num-1;i--){
            }
        }
        1、元素总和sum, - 号元素之和neg，+ 号元素之和sum-neg，有(sum-neg) -neg = target neg = (sum-target)/2
        2、nums中元素非负数，neg也是非负整数。所以前提是sum-target是非负偶数，若不符合该条件直接返回0
        3、上面成立，转化在数组nums中选取若干元素，使得这些元素之和等于neg，计算选取元素的方案数，使用dp
        4、二维数组dp，dp[i][j]表示数组nums的前i个数中选取元素，使得元素之和等于j的方案数。nums长度为n，最终答案为dp[n][neg]
        5、边界条件 dp[0][j]=1 j=0（等于0的方案数）; dp[0][j]=0 j>1
        6、1<=i<=n，对于数组nums中的第i个元素num（i的计算从1开始），遍历0<=j<=neg，计算dp[i][j]值
        - 如果j<num，不能选num，此时有dp[i][j]=dp[i-1][j]
        - 如果j>=num，不选num，方案数dp[i-1][j]，选num，方案数dp[i-1][j-num]，此时
        dp[i][j]=dp[i-1][j]+dp[i-1][j-num]
        num = nums[i-1]
        状态方程也是
        dp[i][j]=dp[i-1][j]                   j<nums[i]
        dp[i][j]=dp[i-1][j]+dp[i-1][num] j>=nums[i]
        方案数就是dp[n][neg]
        由于 dp 的每一行的计算只和上一行有关，因此可以使用滚动数组的方式，去掉 dp
        的第一个维度，将空间复杂度优化到 O(neg)。
        实现时，内层循环需采用倒序遍历的方式，这种方式保证转移来的是dp[i−1][] 中的元素值。
         */
        int sum = 0;
        for (int num : nums) {
            sum += num;//求的总和
        }
        int diff = sum - target;//总和减去目标和
        if (diff < 0 || diff % 2 != 0) {
            return 0;//必须要是非负偶数
        }
        int n = nums.length, neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;//初始化
        for (int num : nums) {
            for (int i = neg; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[neg];
    }
}
