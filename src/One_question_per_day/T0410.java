package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/4/10 9:59 上午
 * @Description 263. 丑数
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数
 * 示例 1：
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * 示例 2：
 * 输入：n = 8
 * 输出：true
 * 解释：8 = 2 × 2 × 2
 * 示例 3：
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 * 示例 4：
 * 输入：n = 1
 * 输出：true
 * 解释：1 通常被视为丑数。
 */
public class T0410 {
    public static void main(String[] args) {
        int n = 14;
        System.out.println(isUgly(n));
    }

    public static boolean isUgly(int n) {
        /*
        1、n不是正整数，必定为false
        2、n是正整数，对 n 执行2 3 5的整除操作，直到n被除干净，如果n最终为1说明是丑数
         */
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }

    public static boolean isUgly1(int n) {
        if (n == 0) return false; // 特别判断
        while (true) {
            if (n == 1) return true; // 当n等于1时，代表这个数的质因数只包含2,3,5。那么为true
            if (n % 2 == 0) n /= 2; // 如果n中含有2的质因数，那么把它抽出来
            else if (n % 3 == 0) n /= 3; // 如果n中含有3的质因数，那么把它抽出来
            else if (n % 5 == 0) n /= 5; // 如果n中含有5的质因数，那么把它抽出来
            else return false; // 不是丑数，返回false
        }
    }

    public static boolean isUgly3(int n) {
        /*
        1、负数返回false
        2、n>0的时候，若n是丑数，则n可以写成n=2^a*3^b*5^c的形式，a，b，c为0的时候，n=1
        3、可以针对n反复除以2，3，5。直到n不再包含质因数2，3，5。若剩下的数等于1
        4、说明n不包含其他质因数，丑数，否则，包含其他质因数，不是丑数
         */
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }


}
