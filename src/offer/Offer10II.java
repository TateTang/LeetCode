package offer;

/**
 * @Author tangmf
 * @Date 2021/7/31 11:06 上午
 * @Description Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 */
public class Offer10II {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(new Offer10II().numWays(n));
    }

    /**
     * 动态规划
     * 为了解决该问题，我们可以使用动态规划，将每次前两数之和存起来，便于下次直接使用，这样子，我们就把一个栈溢出的问题，变为了单纯的数学加法，大大减少了内存的压力
     */
    public int numWays(int n) {
        //a 为f(0)=1，b为f(1)=1 f(n)=f(n-1)+f(n-2)
        int a = 1, b = 1, sum;
        for (int i = 1; i <=n; i++) {
            sum = (a + b) % 1000000007;//求和
            a = b;//赋值给第一个数
            b = sum;//存储每次前两次的和，赋值给第二个数
        }
        return a;
    }
}
