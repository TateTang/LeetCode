/**
 * @Description
 * @Author tangmf
 * @Date 2020/4/9 14:42 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。 示例 1： 输入：nums =
 *       [12,345,2,6,7896] 输出：2 解释： 12 是 2 位数字（位数为偶数）  345 是 3 位数字（位数为奇数）   2 是
 *       1 位数字（位数为奇数）  6 是 1 位数字 位数为奇数）  7896 是 4 位数字（位数为偶数）   因此只有 12 和 7896
 *       是位数为偶数的数字
 */
public class Test5 {

	public static void main(String[] args) {
		int[] nums = { 555, 901, 482, 1771 };
		System.out.println(findNumbers(nums));
	}

	private static int findNumbers(int[] nums) {
		int count = 0;
		for (int num : nums) {
			// 计算位数
			if (String.valueOf(num).length()% 2 == 0) {// 偶数
				count++;
			}
		}
		return count;
	}
}
