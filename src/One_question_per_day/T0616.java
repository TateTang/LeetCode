package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/6/16 10:59 上午
 * @Description 877. 石子游戏
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。
 * 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 * 示例：
 * 输入：[5,3,4,5]
 * 输出：true
 * 解释：
 * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
 * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
 * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 */
public class T0616 {
    public static void main(String[] args) {
        int[] piles = {5, 3, 4, 5};
        System.out.println(new T0616().stoneGame(piles));
    }

    public boolean stoneGame(int[] piles) {
        /*
        动态规划：
        1、每次只能从行的开始或者结束处取走整堆石头，因此可以保证剩下的石头堆一定是连续的
        2、如果只剩下一堆石子，则当前玩家只能取走这堆石子；如果剩下多堆石子，则当前玩家可以选择从行的开始或者结束处取走整堆石子，
        然后轮到另外一个玩家在剩下的石子堆中取走石子，这是一个递归的过程，因此可以使用递归求解
        - 递归过程中维护一个总数，表示Alex和lee的石子数量「之差」游戏结束的时候总数大于0代表Alex胜利，否则lee胜利
        3、如果有n堆石子，则递归的时间复杂度为O(2^n)，无法通过所有的测试用例，存在大量的重复计算，使用dp
        4、定义而为数组dp，其行数和列数都等于石子的堆数。dp[i][j]表示当剩下的石子堆为下标i到下标j时，当前玩家和另外一个玩家
        的石子数量之差的最大值，注意当前玩家不一定是先手Alex
        5、只有当i<=j 时，剩下的石子堆才有意义，因此当i>j时，dp[i][j]=0
        6、i=j的时候，剩下一堆石子，当前玩家只能取走，因此对于所有 0<=i<=nums.length，都有dp[i][i]=piles[i]，即石子的数量
        7、i<j时，当前玩家可以选择取走piles[i]或者piles[j]，然后轮到另一个玩家在剩下的石子堆中取走石子。
        在两种方案中，当前玩家肯定会选择最优的方案，使得自己的石子数量最大化，可以得到如下状态方程
        dp[i][j]=max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1])
        8、最后判断dp[0][piles.length-1]的值 如果大于0，则代表alex石子数量大于lee数量，alex赢的比赛，否则lee赢的比赛
         */
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];//代表剩下一堆石子的时候，石子数量
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }

    public boolean stoneGame1(int[] piles) {
        /*
        动态规划：
        上面的使用了二维数组dp，分析状态转移方程可以看到
        dp[i][j]只和dp[i+1][j]与dp[i][j-1]有关
        在计算dp的第i行的值的时候，只需要使用到dp的第i行和i+1行的值，因此使用一维数组代替而为数组，进行空间优化
         */
        int length = piles.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = piles[i];//代表剩下一堆石子的时候，石子数量
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
            }
        }
        return dp[length - 1] > 0;
    }
}
