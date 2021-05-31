package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/5/31 10:00 上午
 * @Description 231. 2 的幂 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 x 使得 n == 2^x ，则认为 n 是 2 的幂次方。
 * 示例 1：
 * 输入：n = 1
 * 输出：true
 * 解释：2^0 = 1
 * 示例 2：
 * 输入：n = 16
 * 输出：true
 * 解释：2^4 = 16
 * 示例 4：
 * 输入：n = 4
 * 输出：true
 * 2^2 = 4
 * 一个数 n 是 2 的幂，当且仅当 n 是正整数，并且 n 的二进制表示中仅包含1 个1
 * 二进制表示中最低位：
 * 1、n & (n-1) n & (n-1)==0 n就是2的幂
 * 2、n & (-n)  n & (-n) == n n就是2的幂
 */
public class T0530 {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(new T0530().isPowerOfTwo(n));
        System.out.println(4 & 3);
    }

    public boolean isPowerOfTwo(int n) {
        /*朴素做法
         *1、小于等于0的数必然不是，1必然是
         *2、尝试将n除干净，如果最后剩余数值为1则说明开始是2的幂
         * 时间复杂度：O(logN)
         * 空间复杂度：O(1)
         */
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        /*一个数 n 是 2 的幂，当且仅当 n 是正整数，并且 n 的二进制表示中仅包含1 个1，考虑使用位运算
         *1、将n的二进制表示中最低位的那个1提取出来，在判断剩余的数值是否为0即可
         *2、「二进制表示中最低位」：n&(n-1)
         *3、& 与运算，可以直接将n二进制表示的最低位1移除
          1，低位为 0）。
         * 时间复杂度：O(1)
         * 空间复杂度：O(1)
         */
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo3(int n) {
        /*lowbit做法
         *1、lowbit 可以快速求得 x 二进制表示中最低位 1 表示的值。
         *2、如果一个数 n 是 2 的幂，那么有 lowbit(n) = n 的性质（2 的幂的二进制表示中必然是最高位为
          1，低位为 0）。
         * 时间复杂度：O(1)
         * 空间复杂度：O(1)
         */
        return n > 0 && (n & (-n)) == n;
    }
}
