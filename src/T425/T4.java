package T425;

/**
 * @Author tangmf
 * @Date 2020/4/25 11:21
 * @Description
 *
 * 				给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 *
 *              「距离值」 定义为符合此描述的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足
 *              |arr1[i]-arr2[j]| <= d 。
 *
 *
 *
 *              示例 1：
 *
 *              输入：arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2 输出：2 解释： 对于
 *              arr1[0]=4 我们有： |4-10|=6 > d=2 |4-9|=5 > d=2 |4-1|=3 > d=2
 *              |4-8|=4 > d=2 对于 arr1[1]=5 我们有： |5-10|=5 > d=2 |5-9|=4 > d=2
 *              |5-1|=4 > d=2 |5-8|=3 > d=2 对于 arr1[2]=8 我们有： |8-10|=2
 *              <= d=2 |8-9|=1 <= d=2 |8-1|=7 > d=2 |8-8|=0 <= d=2
 */
public class T4 {

	public static void main(String[] args) {
		int[] arr1 = { 4, 5, 8 };
		int[] arr2 = { 10, 9, 1, 8 };
		int d = 2;
		System.out.println(findTheDistanceValue(arr1, arr2, d));
	}

	private static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		int ans = arr1.length;
		for (int num : arr1) {
			for (int num1 : arr2) {
				if (Math.abs(num1 - num) <= d) {
					ans--;
					break;
				}
			}
		}
		return ans;
	}
}
