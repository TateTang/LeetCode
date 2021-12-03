package offer;

/**
 * @Author tangmf
 * @Date 2021/12/2 2:10 下午
 * @Description 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
 * 1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class Offer46 {
    public static void main(String[] args) {
        int num = 25;
        System.out.println(new Offer46().translateNum(num));
    }

    public int translateNum(int num) {
        /*
        方案数的递推
        - 12258 = X(1)X(2)X(3)X(4)X(5)
        X(1)X(2)X(3)X(4)...X(i-2)翻译方案f(i-2)
        X(1)X(2)X(3)X(4)...X(i-i)翻译方案f(i-1)

        整体翻译X(i-1)X(i)时候
        - X(1)X(2)X(3)X(4)...X(i-2) X(i-1)X(i) 翻译方案数f(i-2)
        单独翻译X(i)时，
        - X(1)X(2)X(3)X(4)...X(i-2)X(i-1) X(i) 翻译方案数f(i-1)
        方案数的递推关系
        -  f(i) = f(i-2) + f(i-1) 若数字X(i-1)X(i) 可被翻译
        -  f(i) = f(i-1) 若数字X(i-1)X(i) 不可被翻译
        动态规划
        记数字num的第i为数字为X(i),数字num的位数为n，如num=12258 n=5,X(1)=1，X(5)=5
        状态定义：
            - 动态规划列表dp，dp[i]代码以X(i)为结尾的数字的翻译方案数量，也就是
        转移方程：如果X(i)和X(i-1)组成的两位数字能够被翻译，则dp[i]=dp[i-1]+dp[i-2]，否则dp[i]=dp[i-1]
            - 可以被翻译的两位数区间，当X(i-1)=0时，组成的两位数是无法被翻译的(如00,01,02)，因此区间为[10,25]
            - 两个数字翻译是一个两位数，单独翻译是一位数 0-10 25-99都是有效的
            dp[i]=dp[i-1]+dp[i-2] 10<=10X(i-1)+X(i)<=25
            dp[i]=dp[i-1] 0<=10X(i-1)+X(i)<10 && 25<10X(i-1)+X(i)<=99
        初始状态：
            - dp[0]=dp[1]=1，无数字和第一位数字的翻译方法数量都是1
        返回值：
            - dp[n]，数字的翻译数量
        无数字情况dp[0]=1 从何而来
        - 当num 第1，2位的组成的数字 [10,25]时，有两种dp[2] =dp[1]+dp[0]=2，然而dp[1]=1，因此推出dp[0]=

        方法一：字符串遍历
        - 方便获取数字的个位X(i),现将数字num转化为字符串s，通过遍历s实现动态规划
        - 通过字符串切片s[i-2:i]获取数字组合10X(i-1)+Xi，通过对比字符串ASCII码判断字符串对应的数字区间
         */
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;//，无数字和第一位数字的翻译方法数量都是1
        for (int i = 2; i <= s.length(); i++) {
            String temp = s.substring(i - 2, i);
            //判断当前字符串i下标处最后两位数字是否>=10且<=25
            //因为<10走一步和走两步的翻译结果一样，>25只能一步一步走，因此这两种情况都只能dp[n]=dp[n-1]
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
