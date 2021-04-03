package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/4/3 1:47 下午
 * @Description 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的子序列 是指这样一个新的字符串：
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 */
public class T0403 {
    public static void main(String[] args) {
        String text1 = "bl";
        String text2 = "yby";
        System.out.println(longestCommonSubsequence(text1, text2));

    }

    public static int longestCommonSubsequence(String text1, String text2) {
        /*
         * 1、关于数组的定义
         * 定义dp[i][j] 表示最长公共子序列的长度
         * 2、初始化
         * dp[0][0]，表示text1，text2为空，dp[0][0]=0；
         * 第一列，表示当text1为空时，最长公共子序列长度为0；
         * 第一行，表示当text2为空时，最长公共子序列长度为0；
         * 3、状态方程
         * text1[i]=text2[j]时候，匹配上，最长公共子序列长度为dp[i][j]=dp[i-1][j-1]+1
         * 否则，没有匹配上，继续往下走
         * text1[i]!=text2[j]，不匹配，取的是 不使用text[i]形成的最长公共子序列的长度，
         *
         *
         * 1、dp[i][j]表示text1[0:i](text1的长度为i的前缀) 和text2[0:j](text2的长度为j的前缀)的最长公共子序列的长度，
         *
         * 2、动态规划的边界问题，所以i=0||j=0的时候dp[i][j]=0，初始化为0
         *      - 当i=0的时候,text1[0,i]为空，空字符和任何字符串的最长公共子序列为0，所以0<=j<=n d[0][j]=0
         *      - 当j=0的时候,text2[0,j]为空，空字符和任何字符串的最长公共子序列为0，所以0<=i<=n d[i][0]=0
         *
         * 3、当i>0 && j>0的时候，考虑dp[i][j]的计算
         *  - text1[i-1]==text2[j-1]，代表有匹配的公共字符，考虑text1[0:i-1]和text2[0:j-1]的最长公共子序列，加1 即可的搭配
         *      - 就是dp[i][j]=dp[i-1][j-1]+1
         *  - text1[i-1]!=text2[j-1]，代表没有公共子序列
         *      - text1[0:i-1] 和 text2[0:j]的最长公共子序列 dp[i-][j]
         *      - text1[0:i] 和 text2[0:j-1]的最长公共子序列 dp[i][j-1]
         *      - 想要得到text1[0:i]和text2[0:j]的最长公共子序列，就是取最大值
         *      - 所以 就是 dp[i][j]=max(dp[i][j-1],dp[i-1][j]);
         *
         * 4、得出结论，也就是状态方程
            dp[j]=dp[i-1][j-1]+1                   text1[i-1] == text2[j-1]
            dp[j]=max(dp[i][j-1],dp[i-1][j]);      text1[i-1] != text2[j-1]
         */
        int text1Len = text1.length();
        int text2Len = text2.length();
        int[][] dp = new int[text1Len + 1][text2Len + 1];
        //直接执行状态方程
        for (int i = 1; i <= text1Len; i++) {
            for (int j = 1; j <= text2Len; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1Len][text2Len];
    }
}
