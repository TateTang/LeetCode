package T416;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2020/4/16 13:38
 * @Description 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 *
 *              完成所有替换操作后，请你返回这个数组。
 *
 *               
 *
 *              示例：
 *
 *              输入：arr = [17,18,5,4,6,1] 输出：[18,6,6,6,1,-1]
 */
public class T3 {

	public static void main(String[] args) {
		int[] arr = { 17, 18, 5, 4, 6, 1 };
		System.out.println(Arrays.toString(replaceElements(arr)));
	}

	// private static int[] replaceElements(int[] arr) {
	// for (int i = 0; i < arr.length; i++) {
	// int max = 0;// 定义最大值，为i的后面一个，如果是最后一个元素就为-1
	// if (i == arr.length - 1) {
	// arr[arr.length - 1] = -1;
	// } else {
	// max = arr[i + 1];
	// }
	// for (int j = i + 1; j < arr.length; j++) {// 遍历找出最大值
	// if (max < arr[j]) {
	// max = arr[j];// 找出最大值
	// }
	// arr[i] = max;// 直接赋值
	// }
	// }
	// return arr;
	// }
	/*
	 * 从前往后修改的思路比较麻烦，但是从后往前来维护一个最大值变量max，就忽然变得很简单。
	 *
	 * 如果当前的数比max小，则把当前的数变成max；
	 *
	 * 如果比max大，则把max改成当前的数。
	 */
	private static int[] replaceElements(int[] arr) {
		int max = -1;
		for (int i = arr.length - 1; i >= 0; i--) {
			int temp = arr[i];// 变量存储当前值
			arr[i] = max;// 把最大值赋给当前下标对应的值
			max = temp > max ? temp : max;// 找出最大值比较大于 就是当前，否则就是最大值
		}
		return arr;
	}
}
