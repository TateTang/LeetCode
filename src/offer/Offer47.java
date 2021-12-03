package offer;

/**
 * @Author tangmf
 * @Date 2021/12/3 11:12 上午
 * @Description 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）
 * 。你可以从棋盘的左上角开始拿格子里的礼物，并
 * 每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 示例 1:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 */
public class Offer47 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        //System.out.println(new Offer47().maxValue(grid));
        System.out.println(new Offer47().maxValue2(grid));
    }

    public int maxValue(int[][] grid) {
        /*
        从棋盘的左上角开始拿格子里的礼物，并每次 向右 或者 向下 移动一格、直到到达棋盘的右下角。
        根据题目说明，易得某单元格只可能从上边单元格或左边单元格到达。
        - 设f(i,j) 为从棋盘左上角走至单元格(i，j)的礼物最大累计价值，得到一下递推关系
        - f(i,j) 等于f(i,j-1) f(i-1,j)中的较大值，然后还需要加上当前单元格礼物的价值grid(i,j)
            f(i,j)= Max[f(i,j-1),f(i-1,j)] + grid(i,j)

        动态规划解析：
        状态定义：设动态规划矩阵dp,dp(i,j)代表从棋盘的左上角开始，到达单元格(i,j)时能够拿到礼物的最大累计价值
        转移方程：
            - 当 i=0 && j=0  时，为起始元素
            - 当 i=0 && j!=0 时，为矩阵第一行元素，只可以从左边到达
            - 当 i!=0 && j=0 时，矩阵第一列元素，只可以从上边到达
            - 当 i!=0 && j!=0 时候，可以从左边或者右边到达
             dp(i,j) =
             - grid(i,j) i=0 && j=0
             - grid(i,j) + dp(i,j-1) i=0&&j!=0
             - grid(i,j) + dp(i-1,j) i!=0 && j=0
             - grid(i,j) + max[dp(i-1,j),dp(i,j-1)] + grid(i,j) i!=0 && j!=0
        初始状态： dp[0][0] = grid[0][0]，即到达单元格(0,0)时能拿到礼物的最大累计价值为grid[0][0];
        返回值：dp[m-1][n-1]，m，n分别为矩阵的行高和列宽，返回dp矩阵右下角元素

        空间复杂度优化：
        - 由于dp[i][j] 只与dp[i-1][j],dp[i][j-1]，grid[i][j]有关系，因此可以将原矩阵grid用作dp矩阵
        直接在grid上修改即可
        - 应用此方法可以省去dp矩阵使用的额外空间，因此空间复杂度从O(MN)降至O(1)
         */
        int row = grid.length;//行
        int column = grid[0].length;//列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    //矩阵第一行只可以左边到达
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (j == 0) {
                    //矩阵第一列只可以上边到达
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    //可以左边和上边同时到达
                    grid[i][j] = grid[i][j] + Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[row - 1][column - 1];
    }

    public int maxValue1(int[][] grid) {
        //多开一行一列的空间能够让代码更简洁
        int row = grid.length;//行
        int column = grid[0].length;//列
        //动态规划矩阵dp,dp(i,j)代表从棋盘的左上角开始，到达单元格(i,j)时能够拿到礼物的最大累计价值
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }

    public int maxValue2(int[][] grid) {
        int row = grid.length;//行
        int column = grid[0].length;//列
        //动态规划矩阵dp,dp(i,j)代表从棋盘的左上角开始，到达单元格(i,j)时能够拿到礼物的最大累计价值
        int[][] dp = new int[row][column];
        dp[0][0] = grid[0][0];//初始化
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    //矩阵第一行只可以左边到达
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    //矩阵第一列只可以上边到达
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    //可以左边和上边同时到达
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[row - 1][column - 1];
    }
}
