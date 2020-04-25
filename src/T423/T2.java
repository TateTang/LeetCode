package T423;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2020/4/23 14:38
 * @Description 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 *
 *              请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
 *
 *              注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。
 *
 *               
 *
 *              示例：
 *
 *              输入：heights = [1,1,4,2,1,3] 输出：3 解释： 当前数组：[1,1,4,2,1,3]
 *              目标数组：[1,1,1,2,3,4] 在下标 2 处（从 0 开始计数）出现 4 vs 1 ，所以我们必须移动这名学生。 在下标
 *              4 处（从 0 开始计数）出现 1 vs 3 ，所以我们必须移动这名学生。 在下标 5 处（从 0 开始计数）出现 3 vs 4
 *              ，所以我们必须移动这名学生。
 */
public class T2 {

	public static void main(String[] args) {
		int[] heights = { 1, 1, 4, 2, 1, 3 };
		System.out.println(heightChecker(heights));
	}

	private static int heightChecker(int[] heights) {
		// int count = 0;
		// int[] arr = new int[heights.length];
		// /*
		// * 数组赋值： public static void (Object src, int srcPos, Object dest,
		// * int destPos,int length)
		// *
		// src:原数组；srcpos：原数组要复制的起始位置；dest：目的数组；destpost：目的数组的起始位置；length：复制的长度
		// */
		// System.arraycopy(heights, 0, arr, 0, heights.length);
		// // 冒泡排序
		// for (int i = 0; i < heights.length; i++) {
		// for (int j = 0; j < heights.length - 1 - i; j++) {
		// if (heights[j] > heights[j + 1]) {
		// int temp = heights[j];
		// heights[j] = heights[j + 1];
		// heights[j + 1] = temp;
		// }
		// }
		// }
		// for (int i = 0; i < arr.length; i++) {
		// if (arr[i] != heights[i]) {
		// count++;
		// }
		// }
		// return count;
		int arr[] = Arrays.copyOf(heights, heights.length);// 赋值数组
		Arrays.sort(arr); // 排序
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != heights[i]) {// 比较 不相等 计数器+1
				count++;
			}
		}
		return count;
	}
}
