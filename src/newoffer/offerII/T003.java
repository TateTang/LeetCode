package newoffer.offerII;

import java.util.Arrays;

/**
 * @author tangmf
 * @date 2022年08月31日 16:12:​28
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 * 示例 1:
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * <p>
 * 示例 2:
 * 输入: n = 5
 * 输出: [0,1,1,2,1,2]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 */
public class T003 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(1 >> 1);
        System.out.println(2 >> 1);
        System.out.println(3 >> 1);
        System.out.println(4 >> 1);
        System.out.println(5 >> 1);
        System.out.println(Arrays.toString(new T003().countBits1(n)));
    }

    public int[] countBits(int n) {
        // 转换成二进制
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            String s = Integer.toBinaryString(i);
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    public int[] countBits1(int n) {
        /*动态规划：线性时间扫描一趟完成
         - i & (i - 1) 就是将i最低位1变成0，相对i来说少了个最低位的1
         - i 中1的个数，等于 i & (i - 1) 中1的个数 + 1（就是少了最低位的1）
         i & (i - 1) 就是比 i 少了最低位的1，因此 i 的状态可以由 i & (i - 1)  的 1个数 + 1

         & 与运算：都为1 结果才是1
         >> 逻辑右移各二进位全部右移若干位，对无符号数，高位补0，当前位置向后移动两位
         1>>1：1>>1 = 1
         2>>1：10>>1 = 1
         3>>1：11>>1 = 1
         4>>1：100 >> 10 =  2
         5>>1：101 >>10 = 2
         a >> b & 1 代表检查 a 的第 b 位是否为1，有两种可能性 0或者1
         a += 1<<b 代表将 a 的第 b 位设置为1(当第 b 位为0的时候适用)
         */
        // 从小到大遍历
        int[] dp = new int[n + 1];
        // dp[i] = 「i >> 1 所包含的 1 的个数」+「i 的最低位是否为 1」，i>>1 就是前一步的操作
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
