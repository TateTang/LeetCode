package T425;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2020/4/25 11:48
 * @Description 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *               
 *
 *              示例 1：
 *
 *              输入：[-4,-1,0,3,10] 输出：[0,1,9,16,100]
 */
public class T5 {

	public static void main(String[] args) {
		int[] A = { 4, -1, 0, 3, 10 };
		System.out.println(Arrays.toString(sortedSquares(A)));
	}

	private static int[] sortedSquares(int[] A) {
		// int[] arr = Arrays.copyOf(A, A.length);// 赋值数组
		int[] arr = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			arr[i] = A[i] * A[i];
		}
		Arrays.sort(arr);
		return arr;
	}
}
