package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/3/22 10:11 上午
 * @Description 191. 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * 汉明重量：非零的个数
 * 示例 1：
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 * <p>
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 * <p>
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 */
public class T0322 {
    public static void main(String[] args) {
        int n = 00_000_000_000_000_000_000_000_000_001_011;
        int n1 = 00_000_000_000_000_000_000_000_010_000_000;
        //long n2 = 11_111_111_111_111_111_111_111_111_111_101;
        //System.out.p1rintln(hammingWeight(n));
        //System.out.println(hammingWeight(n1));
        //System.out.println(hammingWeight1(n));
        System.out.println(hammingWeight2(n));
        System.out.println(hammingWeight3(n));
    }

    // you need to treat n as an unsigned value
    //1、暴力法 Integer自带的方法，直接将一个整数转换程二进制数
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    //2、暴力法
    public static int hammingWeight1(int n) {
        //输入的n是补码，需要先求得原码，原码=补码按位取反+1
        String str = Integer.toBinaryString(n);//由二进制（基数2）中的参数表示的无符号整数值的字符串表示形式
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1')
                count++;
        }
        return count;
    }

    /**
     * 3、循环检查二进制位
     * 我们可以直接循环检查给定整数 的二进制位的每一位是否为1，
     * 具体代码中，当检查第i位的时候，可以让n与2^i计算，当且仅当第i位不为0的时候，计算加1
     * <p>
     * 时间复杂度：O(k),其中k 是int型的二进制位数，k=32。我们需要检查n的二进制位的每一位，一共需要检查32 位。
     * 空间复杂度：O(1)，我们只需要常数的空间保存若干变量。
     */
    public static int hammingWeight2(int n) {
        int count = 0;
        //1<<1，1左移动 i位，相当于2^i
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 4、位运算优化
     * 思路及解法：n & (n-1) 预算结果恰为把n的二进制中的最低位的1变成0的结果
     * 如 6 & (6-1) =(110) & (101) = 100=4 运算结果4 即为把 6的二进制中的最低位的1变为0的结果
     * 4 & 3 =0 把4的二进制中的最低位1 变成0
     * <p>
     * 利用这个位运算的性质加速检查过程，实际代码中，不断让n & n-1 做与运算，直到n变为0即可。
     * 因为每次运算都会使得n的最低位1 被翻转，因此运算次数就等于n的二进制中1的个数
     *
     * 时间复杂度：O(logn),循环次数等于n的二进制中1的个数，最坏情况下n的二进制的个数全部为1，需要logN次。
     * 空间复杂度：O(1)，我们只需要常数的空间保存若干变量。
     */
    public static int hammingWeight3(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
