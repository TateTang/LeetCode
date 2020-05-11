package T430;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2020/4/30 10:52
 * @Description 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 *              在同一行的所有元素中最小 在同一列的所有元素中最大  
 *
 *              示例 1：
 *
 *              输入：matrix = [[3,7,8],[9,11,13],[15,16,17]] 输出：[15] 解释：15
 *              是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 */
public class T1 {

	public static void main(String[] args) {
		int[][] matrix = { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } };
		System.out.println(luckyNumbers(matrix));
	}

	public static List<Integer> luckyNumbers(int[][] matrix) {
		/*
		 * 在两个列表中找出并保存每一行的最小值和每一列的最大值。 然后扫描整个矩阵以找出满足条件的元素。 min数组存放每行最小值;
		 * man数组存放每列最大值; 循环比较得到每一行的最小值和每一列的最大值。 然后比较第i行最小值和第j列最大值是否为同一个数，即min[i]
		 * == max[j]
		 */
		int m = matrix.length;
		int n = matrix[0].length;
		int[] min = new int[m];
		int[] max = new int[n];
		Arrays.fill(min, Integer.MAX_VALUE);
		Arrays.fill(max, Integer.MIN_VALUE);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				min[i] = Math.min(min[i], matrix[i][j]);// 第i行最小值
				max[j] = Math.max(max[j], matrix[i][j]);// 每一列最大值与当前值比较
			}
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (min[i] == max[j])
					list.add(min[i]);
			}
		}

		return list;
	}
}
