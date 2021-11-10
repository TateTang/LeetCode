package offer;

/**
 * @Author tangmf
 * @Date 2021/11/9 11:08 上午
 * @Description 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 */
public class Offer16 {
    public static void main(String[] args) {
        double x = 2.10000;
        int n = 3;
        System.out.println(new Offer16().myPow(x, n));
    }

    public double myPow(double x, int n) {
        /*
         * 主要是将n分为偶数和奇数两种情况：
         * 先判断一样n为0或负数的情况，然后判断奇偶
         *
         * 如果n为负数，返回 1/x * myPow(1/x,-n-1)
         * 如果n为偶数，返回 myPow(x * x,n/2);
         * 如果n为奇数，返回 x * myPow(x * x,n/2);
         *
         * 注意：当n为负数时，Java中因为n的最小值可以取到Integer.MIN_VALUE，
         * 如果直接取它的相反数的话还是它自己，会导致堆栈溢出，因此提一个x出来。
         */
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / x * myPow(1 / x, -n - 1);//防止溢出操作
        } else if (n % 2 == 0) {
            return myPow(x * x, n / 2); //偶数
        } else if (n % 2 != 0) {
            return x * myPow(x * x, n / 2);
        }
        return 0;
    }
}
