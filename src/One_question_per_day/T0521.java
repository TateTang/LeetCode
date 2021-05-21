package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/5/21 10:02 上午
 * @Description 1035. 不相交的线
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 *  nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。以这种方法绘制线条，并返回可以绘制的最大连线数。
 * 示例 1：
 * 输入：nums1 = [1,4,2], nums2 = [1,2,4]
 * 输出：2
 * 解释：可以画出两条不交叉的线，如上图所示。
 * 但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
 * 示例 2：
 * 输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
 * 输出：3
 * 示例 3：
 * 输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
 * 输出：2
 */
public class T0521 {
    public static void main(String[] args) {
        int[] nums1 = {2, 5, 1, 2, 5};
        int[] nums2 = {10, 5, 2, 1, 5, 2};
        System.out.println(new T0521().maxUncrossedLines(nums1, nums2));
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        /*
        满足条件
        - nums1[i]==nums2[j]
        - 且绘制的直线不与任何其他连线（非水平线）相交。代表j后面的连线需要>j
        因此，这 k 对相等的元素组成的序列即为数组nums1[]和nums2的公共子序列
        1、关于数组的定义
        dp[i][j]标识表 示数组nums1的前i个元素和nums2的前j个元素所能绘制的最大连接数
        2、边界问题
        - 当i=0的时候,nums1[0:i]为空，空字符和任何字符串的最长公共子序列为0，所以0<=j<=n d[0][j]=0
        - 当j=0的时候,nums2[0:j]为空，空字符和任何字符串的最长公共子序列为0，所以0<=i<=n d[i][0]=0
         i=0,j=0 dp[i][j]=0
        3、当i>0 && j>0的时候，考虑dp[i][j]的计算
        - nums1[i-1]==nums2[j-1]，代表有匹配的公共字符，考虑nums1[0:i-1]和nums2[0:j-1]的最长公共子序列，
        再增加一个元素（即公共元素）就是dp[i][j]=dp[i-1][j-1]+1
        - nums1[i-1]!=nums2[j-1]，代表没有公共子序列
            - nums1[0:i-1] 和 nums2[0:j]的最长公共子序列 dp[i-1][j]
            - nums1[0:i] 和 nums2[0:j-1]的最长公共子序列 dp[i][j-1]
        - 想要得到nums1[0:i]和nums2[0:j]的最长公共子序列，就是取最大值
        - 所以 就是 dp[i][j]=max(dp[i][j-1],dp[i-1][j]);
        4、得出结论，也就是状态方程
            dp[j]=dp[i-1][j-1]+1                   nums1[i-1] == nums2[j-1]
            dp[j]=max(dp[i][j-1],dp[i-1][j]);      nums1[i-1] != nums2[j-1]
         */
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int[][] dp = new int[nums1Len + 1][nums2Len + 1];
        for (int i = 1; i <= nums1Len; i++) {
            for (int j = 1; j <= nums2Len; j++) {
                /*相等说明：
                 nums1的第i个元素可以和nums2的第j个元素可以连成一条线，
                 这个时候nums1的前i个元素和nums2的前j个元素所能绘制的最大连接数就是nums1的前i-1个元素
                 和nums2的前j-1个元素所能绘制的最大连接数加1，也就是dp[i][j]=dp[i-1][j-1]+1;*/
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    /*
                    不相等说明
                    把nums1去掉一个元素，计算nums1的前i-1个元素和nums2的前j个元素能绘制的最大连接数，也就是dp[i-1][j]
                    或者把nums2去掉一个元素，计算nums2的前j-1个元素和nums1的前i个元素能绘制的最大连接数，也就是dp[i][j-1]，
                    这两种情况我们取最大的即可
                     */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1Len][nums2Len];
    }
}
