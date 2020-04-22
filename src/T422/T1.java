package T422;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2020/4/22 11:00
 * @Description 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 *              水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 *              反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0,
 *              0]。
 *
 *              示例 1:
 *
 *              输入: [[1,1,0],[1,0,1],[0,0,0]] 输出: [[1,0,0],[0,1,0],[1,1,1]] 解释:
 *              首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]； 然后反转图片:
 *              [[1,0,0],[0,1,0],[1,1,1]]
 */
public class T1 {

	public static void main(String[] args) {
		int[][] A = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
		System.out.println(Arrays.deepToString(flipAndInvertImage(A)));
	}

	private static int[][] flipAndInvertImage(int[][] A) {
		/*
		 * 1.遍历每一行,定义两个左右指针; 2.左指针从左向右,右指针从右向左遍历; 3.数字不同继续遍历,数字相同0→1,1→0;
		 * 4.指针指向同一位置,说明行元素为奇数个,0→1,1→0; 5.完结。
		 */
		for (int i = 0; i < A.length; i++) {
			int start = 0, end = A.length - 1;// 定义左右指针
			while (start < end) {
				if (A[i][start] != A[i][end]) { // 不同遍历
					start++;
					end--;
				} else {
					A[i][start] = A[i][start] == 1 ? 0 : 1;
					A[i][end] = A[i][end] == 1 ? 0 : 1;
					start++;
					end--;
				}

			}
			if (start == end) {// 指向同一位置。 0->1 1->0
				A[i][start] = A[i][start] == 1 ? 0 : 1;
			}
		}
		return A;
		// int C = A[0].length;// c为列数
		// for (int[] row : A)
		// for (int i = 0; i < (C + 1) / 2; ++i) {
		// int tmp = row[i] ^ 1;
		// row[i] = row[C - 1 - i] ^ 1;
		// row[C - 1 - i] = tmp;
		// }

	}
}
