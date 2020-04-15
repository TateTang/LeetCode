package T415;

/**
 * @Author tangmf
 * @Date 2020/4/15 10:27
 * @Description 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 
 *
 *              请你统计并返回 grid 中 负数 的数目。
 *
 *               
 *
 *              示例 1：
 *
 *              输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]] 输出：8
 *              解释：矩阵中共有 8 个负数。
 *
 *
 */
public class T1 {

	public static void main(String[] args) {
		int[][] grid = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
		System.out.println(countNegatives(grid));
	}

	private static int countNegatives(int[][] grid) {
	    int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]<0){
                    count++;
                }
            }
        }
		return count;
	}
}
