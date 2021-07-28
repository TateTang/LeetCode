package offer;

/**
 * @Author tangmf
 * @Date 2021/7/28 10:06 上午
 * @Description 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Offer10 {
    public static void main(String[] args) {
        int n = 44;
        System.out.println(new Offer10().fib1(n));
    }

    /**
     * 递归导致栈溢出，不可用
     *
     * @param n
     */
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return ((fib(n - 1) + fib(n - 2)) % 1000000007);
    }

    /**
     * 动态规划
     * 为了解决该问题，我们可以使用动态规划，将每次前两数之和存起来，便于下次直接使用，这样子，我们就把一个栈溢出的问题，变为了单纯的数学加法，大大减少了内存的压力
     *
     * @param n
     */
    public int fib1(int n) {
        int a = 0, b = 1, sum;//a为第一个数，b为第二个数
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;//求和
            a = b; // 赋值给第一个数
            b = sum;//存储每次前两次的和，赋值给第二个数
        }
        return a;
    }
}
