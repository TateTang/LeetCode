package T420;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2020/4/20 14:39
 * @Description 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。 示例 1：
 *              输入：n = 5 输出：[-7,-1,1,3,4] 解释：这些数组也是正确的
 *              [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 *
 *              示例 2： 输入：n = 3 输出：[-1,0,1] 示例 3：
 *
 *              输入：n = 1 输出：[0]
 */
public class T3 {

	public static void main(String[] args) {
		int n = 4;
		System.out.println(Arrays.toString(sumZero(n)));
	}

	private static int[] sumZero(int n) {
		// 先判断n的奇偶性，n为偶数就把数组的左半边等于负的右半边，这样数组之和就为0；
		// n为奇数的话，要注意右半边数组的取值，且令下标为n/2的元素为0，也就是数组的中间元素。
		int[] arr = new int[n];
		if (n % 2 == 0) {// n 为偶数 数组左半边等于右半边
			for (int i = 0; i < n / 2; i++) {
				arr[i] = i + 1;// 第一个数与最后一个数，第二个数与倒数第二个数 。。。 对称
				arr[i + n / 2] = -(i + 1);
			}
		} else {// n 为奇数 ，
			for (int i = 0; i < n / 2; i++) {
				arr[i] = i + 1;
				arr[i + n / 2 + 1] = -(i + 1);
			}
			arr[n / 2] = 0;// n为奇数，中间为0
		}
		return arr;
	}
}
