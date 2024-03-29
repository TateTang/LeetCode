package offer;

/**
 * @Author tangmf
 * @Date 2021/10/11 10:18 上午
 * @Description 剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */
public class Offer14I {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Offer14I().cuttingRope3(n));
    }

    public int cuttingRope(int n) {
        /*
            动态规划：
            1、要求长度为n的绳子剪掉后的最大乘积，可以从前面比n小的绳子转移而来
            2、用一个dp数组 记录 从0到n 长度的绳子剪掉后的最大乘积，dp[i]：长度为i的绳子经过剪成m段后的最大乘积，
            初始化dp[2]=1，也就是长度为2的最大乘积就是1*1=1
            3、先把绳子剪掉第一段 【长度为j】，如果只剪掉1，对最后乘积没有任何的变化，所以从长度2开始剪
            4、剪下了第一段后，剩下 （i-j）可以剪也可以不剪。
                - 不剪的话长度的乘积为 j * (i-j) 一段为j 一段为 i-j
                - 剪的话长度乘积为 j * dp[i-j] 长度为j， dp[i-j] 就是长度为[i-j]的绳子剪成m段后的最大乘积
                - 取两者的最大值即可 max(j*(i-j),j*dp[i-j])
            5、第一段长度j可以取的区间为 [2,i)，从2开始的，对所有的j不同的情况取最大值，所以状态转移方程为
             - dp[i] = max(dp[i],max(j*(i-j),j*dp[i-j]))
             - max中的dp[i]，是更新存储最大值的，不是依赖自己的。是不同的j都会有一个dp[i]，
             这是在取不同的j情况下dp[i]的最大值,可以写成
               - int tmp = max(j*(i-j),j*dp[i-j]);
               - dp[i] =  max(dp[i],tmp)
            6、最后返回dp[n] 即可
         */
        int[] dp = new int[n + 1];//长度为i的绳子经过剪成m段后的最大乘积
        dp[2] = 1;//初始化，长度为2的最大乘积为 1*1=1
        //j的区间[2,i)，i的范围[3,n+1)
        for (int i = 3; i < n + 1; i++) {
            for (int j = 2; j < i; j++) {
                //剪下了第一段后，剩下 （i-j）可以剪也可以不剪,取的这一段的最大值即可
                int temp = Math.max(j * (i - j), j * dp[i - j]);
                //是不同的j都会有一个dp[i]，这是在取不同的j情况下dp[i]的最大值
                dp[i] = Math.max(dp[i], temp);
            }

        }
        return dp[n];
    }

    public int cuttingRope2(int n) {
        /*
          数学规律：贪心，尽量切长度为3的
          - 推论一：绳子以相等长度分为多段，得到的乘积最大
          - 推论二：尽可能将绳子以长度3等分为多段时，乘积最大
         */
        if (n < 2) return 0;
        if (n == 2) return 1;//长度2 乘积最大1

        //当绳子长度为3时，可能把绳子剪成长度分别为1和2的两段或者长度都为1的三段，因为1*2>1*1*1
        if (n == 3) return 2;
        int a = n / 3;//n能拆成3的个数
        int b = n % 3;//拆成3之后剩余的数
        //n是3的倍数
        if (b == 0) {
            return (int) Math.pow(3, a);//直接返回3的a次方即可
        }
        //n是3k+1，如7 拆分成331 1 对结果没有改变，最后的3 1 可以换成4
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;//b==2时，3k+2 如8 拆分成332 就是3的次方*2
    }

    public int cuttingRope3(int n) {
        /*
          数学规律：贪心，尽量切长度为3的
          步骤如下：
          -  如果 n == 2，返回1，如果 n == 3，返回2，两个可以合并成n小于4的时候返回n - 1
          -  如果 n == 4，返回4
          -  如果 n > 4，分成尽可能多的长度为3的小段，每次循环长度n减去3，乘积res乘以3；最后返回时乘以小于等于4的最后一小段
          -  以上2和3可以合并
         */
        if (n < 4) {
            return n - 1;
        }
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
