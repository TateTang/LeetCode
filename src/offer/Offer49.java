package offer;

/**
 * @Author tangmf
 * @Date 2021/12/7 10:34 上午
 * @Description 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
public class Offer49 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Offer49().nthUglyNumber1(n));
    }

    public int nthUglyNumber(int n) {
        /*
        1、这里需要找到第n个丑数，代表我们的思维需要从下往上，从小的数值向上寻找
        2、设置三个指针 i2 i3 i5 三个指针对应的作用就是2 3 5 的倍数
        3、丑数是质因数只包含2，3，5的正整数，所以从小开始，一个一个丑数放进结果数组中，知道要找的个数为止
        丑数 = 某较小丑数 × 某因子
         */
        int[] dp = new int[n];//定义数组，存放丑数
        dp[0] = 1;//1是丑数
        int i2 = 0, i3 = 0, i5 = 0;//三个指针
        for (int i = 1; i < n; i++) {
            //从小到达，按照丑数的定义收集丑数
            int ugly = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            dp[i] = ugly;//丑数放入对应数组
            if (dp[i] == dp[i2] * 2) i2++;
            if (dp[i] == dp[i3] * 3) i3++;
            if (dp[i] == dp[i5] * 5) i5++;
        }
        return dp[n - 1];//返回第n个丑数
    }

    public int nthUglyNumber1(int n) {
        /*
        1、这里需要找到第n个丑数，代表我们的思维需要从下往上，从小的数值向上寻找
        2、设置三个指针 a b c 三个指针对应的作用就是2 3 5 的倍数
        3、丑数是质因数只包含2，3，5的正整数，所以从小开始，一个一个丑数放进结果数组中，知道要找的个数为止
         */
        int[] dp = new int[n];//定义数组，存放丑数
        dp[0] = 1;//1是丑数
        int a = 0, b = 0, c = 0;// 下个应该通过乘2来获得新丑数的数据是第a个， 同理b, c
        for (int i = 1; i < n; i++) {
            // 第a丑数个数需要通过乘2来得到下个丑数，第b丑数个数需要通过乘3来得到下个丑数，同理第c个数
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                a++; // 第a个数已经通过乘2得到了一个新的丑数，那下个需要通过乘2得到一个新的丑数的数应该是第(a+1)个数
            }
            if (dp[i] == n3) {
                b++; // 第 b个数已经通过乘3得到了一个新的丑数，那下个需要通过乘3得到一个新的丑数的数应该是第(b+1)个数
            }
            if (dp[i] == n5) {
                c++; // 第 c个数已经通过乘5得到了一个新的丑数，那下个需要通过乘5得到一个新的丑数的数应该是第(c+1)个数
            }
        }
        return dp[n - 1];//返回第n个丑数
    }
}
