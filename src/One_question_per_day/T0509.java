package One_question_per_day;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2021/5/10 10:38 上午
 * @Description 1482. 制作 m 束花所需的最少天数
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * 现需要制作 m 束花。制作花束时，需要使用花园中相邻的k 朵花 。
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好可以用于 一束花中。
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 * 示例 1：
 * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 1
 * 输出：3
 * 解释：让我们一起观察这三天的花开过程，x 表示花开，而 _ 表示花还未开。
 * 现在需要制作 3 束花，每束只需要 1 朵。
 * 1 天后：[x, _, _, _, _]   // 只能制作 1 束花
 * 2 天后：[x, _, _, _, x]   // 只能制作 2 束花
 * 3 天后：[x, _, x, _, x]   // 可以制作 3 束花，答案为 3
 * 示例 2：
 * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 2
 * 输出：-1
 * 解释：要制作 3 束花，每束需要 2 朵花，也就是一共需要 6 朵花。而花园中只有 5 朵花，无法满足制作要求，返回 -1 。
 * 示例 3：
 * 输入：bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
 * 输出：12
 * 解释：要制作 2 束花，每束需要 3 朵。
 * 花园在 7 天后和 12 天后的情况如下：
 * 7 天后：[x, x, x, x, _, x, x]
 * 可以用前 3 朵盛开的花制作第一束花。但不能使用后 3 朵盛开的花，因为它们不相邻。
 * 12 天后：[x, x, x, x, x, x, x]
 * 显然，我们可以用不同的方式制作两束花。
 * 示例 4：
 * 输入：bloomDay = [1000000000,1000000000], m = 1, k = 1
 * 输出：1000000000
 * 解释：需要等 1000000000 天才能采到花来制作花束
 * 示例 5：
 * 输入：bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2
 * 输出：9
 */
public class T0509 {
    public static void main(String[] args) {
        int[] bloomDay = {62, 75, 98, 63, 47, 65, 51, 87, 22, 27, 73, 92, 76, 44, 13, 90, 100, 85};
        int m = 2;
        int k = 7;
        System.out.println(new T0509().minDays(bloomDay, m, k));
    }

    public int minDays(int[] bloomDay, int m, int k) {
        /*
            k：代表几朵几朵相邻 m*k是所需要的花朵的总数
          前提：
            1、如果要做 m 束花束， 而每个花束需要 k 朵花，因此他至少需要m×k 朵花，如果花园中没有那么多花，
            那么无论如何他也完成不了任务！
            2、如果满足了上述条件,对于最短的天数,想找的答案一定在花朵盛开的时间表中。
              - 因此他将左边界定义为了数组中的最小值。
              - 右边界定义为了数组的最大值。
          思路：
          为了计算制作出指定数量的花束的最少天数，首先需要实现一个辅助函数用于判断在给定的天数内能否制作出指定数量的花束
          1、辅助函数的参数除了 bloomday、m和k之外,还有一个参数dags表示指定天数。例如, 当bloomDay= 1,10,3,10,2、m=3、k=1时,如果days=3则辅助函数返回true,如果days=2则辅助函数返回 false。
          2、辅助函数实现遍历数组bloomday，计算其中的长度为k且最大元素不超过days的不重合的连续子数组中的数量，如果符合要求的不重合的连续
          子数组的数量大于或等于m返回true，否则返回false
          3、days很小时，辅助函数返回false，因为天数天数不能收集m个花束
          3、days很大时，辅助函数总是返回true，如果给定序列可以制作出m个花束，在days慢慢变大的过程中，辅助函数的返回值
          会从false变成true，所以可以认为这个辅助函数关于days递增的，于是可以通过二分查找得到最少天数
          4、确保可以制作出指定的花束的情况下，所需的最少天数一定不会小于数组bloomday的最小值，不会大于最大值，边界为{min[],max[]}
          low和hign相等的时候二分查找结束，此时low为最少天数
         */
        if (m > bloomDay.length / k) {
            //花朵的数量小于所需要的花朵数量，代表无法满足制作要求，直接返回-1
            return -1;
        }
        int low = Arrays.stream(bloomDay).min().getAsInt();//边界值，花开的最小天数
        int high = Arrays.stream(bloomDay).max().getAsInt();//边界值，花开的最大天数
        //如果可以制m束花，天数一定在low和high之间，因此使用二分
        while (low < high) {
            int days = (high - low) / 2 + low; // 所需要的天数
            if (canMake(bloomDay, m, k, days)) {
                high = days;
            } else {
                low = days + 1;
            }
        }
        return low;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int days) {
        int flowers = 0;//代表可用的花的个数
        int makeFlowers = 0;//当前天数days可以制作出花的数量
        for (int j : bloomDay) {
            if (j <= days) {
                flowers++;//只要开花所需要的天数小于等于days，说明当前花是可以用的
                if (flowers == k) {//当前花朵数量满足可以制作一束花的时候，
                    makeFlowers++;//数量加1
                    flowers = 0;//重置当前可用花的数量
                }
            } else flowers = 0;//因为需要连续的k朵花，因此只要中间有一朵花没有开，flowers进行重置
        }
        return makeFlowers >= m;//只要makeFlowers>=m，说明满足要求
    }
}
