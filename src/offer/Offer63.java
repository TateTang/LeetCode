package offer;

/**
 * @Author tangmf
 * @Date 2021/12/17 2:33 下午
 * @Description 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Offer63 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Offer63().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        /*
        设共有n天，第a天卖，第b天买，需要保证a<b，可推出交易方案共有
         (n-1)+(n-2)+..+2+1 = n(n-1)/2 中
        因此暴力法的时间复杂度为O(n^2)，考虑使用动态规划降低时间复杂度，已经按照流程解题

        动态规划解析：
        - 状态定义：动态规划列表dp，dp[i]代表以price[i]为结尾的子数组的最大利润（简称为前i日的最大利润）
        - 转移方程：由于题目限定"买卖该股票以此"，因此前i日最大利润dp[i]等于前i-1日最大利润dp[i-1]和
        第i日卖出的最大利润中的最大值
         前i日利润 =  max（前(i-1)日最大利润，第i日价格-前i日最低价）
          dp[i] = max(dp[i-1],prices[i]-min(prices[0:i]))
        - 初始状态：dp[0]=0。首日的利润为0
        - 返回值：dp[n-1]，n为列表的长度
        例如前4日的最大利润为,7 1 5 3 6 4
        dp[4] = max(dp[3],prices[4]-min(prices[0;4]))
           = max(4,6-1) = 5

        效率优化：
            时间复杂度降低：前i日的最低价格min(price[0:i])时间复杂度为O(i)，在遍历prices时候，可以
            借助一个变量cost，每日更新最低价格。优化后的转移方程为
                dp[i] = max(dp[i-1],prices[i]-min(cost,prices[i]))
            空间复杂度降低：由于dp[i] 只和dp[i-1],prices,cost 相关，因此使用一个变量profit代替dp列表，优化后为
                profit = max(profit,prices[i]-min(cost,prices[i]))

         复杂度分析：
         时间复杂度O(N)：其中N为prices列表的长度，动态规划是需要遍历prices的
         空间复杂度O(N)：变量cost 和 profit 使用常数大小的额外空间
         */
        if (prices.length == 0) return 0;
        int cost = Integer.MAX_VALUE;//定义一个变量接收最低值
        int profit = 0;//返回结果也就是利润
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);

        }
        return profit;
    }
}
