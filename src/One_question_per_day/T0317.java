package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/3/17 3:05 下午
 * @Description 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（
 * 例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * 题目数据保证答案符合 32 位带符号整数范围。
 * 示例 1：
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 示例 2：
 * <p>
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 * ^    ^^
 * babgbag
 * ^^^
 */
public class T0317 {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s, t));
    }

    public static int numDistinct(String s, String t) {

        /*1.关于数组的定义
            定义 dp[i][j]，表示 s中t出现的次数
          2.关于初始化
            dp[0][0]，表示s,t都为空 dp[0][0]=0;
            第一列，表示当s为空时，t在 s中出现的次数为 0
            第一列，表示当t为空时，t在 s中出现的次数为0
          3.状态方程
           s[i] = t[j]时，两个字符串匹配上，等于上一次的次数，d[i][j]=dp[i-1][j-1];
           不相同需要继续往下走，
         *
         */
        int sLen = s.length();
        int tLeh = t.length();
        int[][] dp = new int[sLen + 1][tLeh + 1];
        //初始化,s,t 一个为空 dp[i][j]=0 ,s不为空，t 为空时dp[i][0] =0，s为空,t不为空时dp[0][j]=0
        //代表当s == " " 时，需要置为0
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = 0;
        }
        //代表着当t == " " 时，需要置为0
        for (int j = 1; j <= t.length(); j++) {
            dp[0][j] = 0;
        }
        //直接执行状态方程
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLeh; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + 1;
                    continue;//跳出当前循环
                }
                dp[i][j]++;
            }
        }
        return dp[sLen][tLeh];
    }
}
