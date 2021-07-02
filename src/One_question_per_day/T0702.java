package One_question_per_day;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2021/7/2 10:27 上午
 * @Description 1833. 雪糕的最大数量
 * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 * 注意：Tony 可以按任意顺序购买雪糕。
 * 示例 1：
 * 输入：costs = [1,3,2,4,1], coins = 7
 * 输出：4
 * 解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
 * 示例 2：
 * 输入：costs = [10,6,8,7,7,8], coins = 5
 * 输出：0
 * 解释：Tony 没有足够的钱买任何一支雪糕。
 * 示例 3：
 * 输入：costs = [1,6,3,1,2,5], coins = 20
 * 输出：6
 * 解释：Tony 可以买下所有的雪糕，总价为 1 + 6 + 3 + 1 + 2 + 5 = 18 。
 */
public class T0702 {
    public static void main(String[] args) {
        int[] costs = {1, 3, 2, 4, 1};
        int coins = 7;
        System.out.println(new T0702().maxIceCream2(costs, coins));
    }

    public int maxIceCream(int[] costs, int coins) {
        /*
        排序，先买最便宜的雪糕，保证买最多的雪糕
         */
        Arrays.sort(costs);
        System.out.println(Arrays.toString(costs));
        int ans = 0;
        int sum = 0;
        for (int cost : costs) {
            sum += cost;
            if (sum <= coins) {
                ans++;//计数器+1
            } else {
                break;//否则直接跳出当前循环
            }
        }
        return ans;
    }

    public int maxIceCream2(int[] costs, int coins) {
        /*
        尽可能的多买
        1、贪心，costs从小到大排序
        2、遍历数组，对于每个元素，如果该元素不超过剩余的硬币数量，则将硬币数减去该元素值，
        表示购买了这只雪糕
        3、当遇到一个元素超过剩余的硬币数时，结束遍历，此时购买的雪糕数量就是最大的数量

         */
        Arrays.sort(costs);
        System.out.println(Arrays.toString(costs));
        int ans = 0;
        for (int cost : costs) {
            if (cost <= coins) {
                coins = coins - cost;//硬币数减去买的雪糕
                ans++;//计数器+1
            } else {
                break;//否则直接跳出当前循环
            }
        }
        return ans;
    }
}
