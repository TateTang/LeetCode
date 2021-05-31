package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/5/31 10:30 上午
 * @Description 342. 4的幂 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x
 * 示例 1：
 * 输入：n = 16
 * 输出：true
 * 示例 2：
 * 输入：n = 5
 * 输出：false
 * 示例 3：
 * 输入：n = 1
 * 输出：true
 */
public class T0531 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(new T0531().isPowerOfFour(n));
    }

    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    public boolean isPowerOfFour2(int n) {
        /*
         * 1个数如果是4的幂，等价于n为质因数只有2的平方数
         * 因此可以将问题转换为：判断根号n是否为2的幂
         * 我们可以先对 n 执行 sqrt 函数，然后应用 lowbit 函数快速判断 是否为 2 的幂。
         * (x & -x) == x判断是否为2的幂次
         */
        if (n <= 0) return false;
        int x = (int) Math.sqrt(n);
        return x * x == n && (x & -x) == x;
    }
}
