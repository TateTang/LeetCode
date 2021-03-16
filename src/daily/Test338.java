package daily;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2021/3/11 10:15 上午
 * @Description 338. 比特位计数
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * <p>
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 */
public class Test338 {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(Arrays.toString(countBits1(num)));
        System.out.println(Arrays.toString(countBits2(num)));
        System.out.println(Arrays.toString(countBits3(num)));

    }

    /*
    1、方法1：Integer自带的方法，直接将一个整数转换程二进制数
     */
    public static int[] countBits1(int num) {
        int[] arrs = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            arrs[i] = Integer.bitCount(i);
        }
        return arrs;
    }


    /*
    方法2：暴力解法，求出每一个数转求一个数转换成二进制后1的个数返回即可
     */
    public static int[] countBits2(int num) {
        int[] arrs = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            arrs[i] = binCount(i);
        }
        return arrs;
    }

    /**
     * 求一个数转换成二进制后1的个数：
     * 2进制：除二取余，然后倒序排列，高位补零。
     * 个数求解：res += n%2 n = n/2
     *
     * @param n 数
     */
    public static int binCount(int n) {
        int res = 0;//1的个数
        while (n != 0) {
            res += n % 2;
            n = n / 2;
        }
        return res;
    }

    /*
    方法3：从已经得到的结果中寻找解以减少计算，使用
     */
    public static int[] countBits3(int num) {
        int[] arrs = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            arrs[i] = arrs[i >> 1] + (i & 1);
            //i>>1 右移一位等价于 i/2
            //i & 1 =0 i为奇数，i & 1 = 1 i为偶数。也可以计算二进制的个位数是1 还是0
            //i & 1 按位与 11 1 只要有0 就是0
        }
        return arrs;
    }
}
