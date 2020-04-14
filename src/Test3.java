import java.util.Arrays;

/**
 * @Description
 * @Author tangmf
 * @Date 2020/4/9 13:39 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *       换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *       以数组形式返回答案。 示例 1： 输入：nums = [8,1,2,2,3] 输出：[4,0,1,1,3] 解释： 对于 nums[0]=8
 *       存在四个比它小的数字：（1，2，2 和 3）。 对于 nums[1]=1 不存在比它小的数字。 对于 nums[2]=2
 *       存在一个比它小的数字：（1）。 对于 nums[3]=2 存在一个比它小的数字：（1）。 对于 nums[4]=3
 *       存在三个比它小的数字：（1，2 和 2）。
 */
public class Test3 {

	public static void main(String[] args) {
		int[] nums = { 8, 1, 2, 2, 3 };
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
		System.out.println(Arrays.toString(smallerNumbersThanCurrent1(nums)));
	}

	private static int[] smallerNumbersThanCurrent(int[] nums) {
		int[] countArr = new int[nums.length];// 初始化一个数组保存数组
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] < nums[i]) {// 满足nums[j]<nums[i],统计其中的个数
					count++;
				}
			}
			countArr[i] = count;// 将个数保存到统计数组中
		}
		return countArr;
	}

	/*
	 * 桶思想：
	 *
	 * 定义一排桶 int arr[101] , 其中 arr[i] 里存放数字 n 出现的次数 遍历 nums，初始化桶数组 arr
	 * 累加处理桶数组arr ， 使得 arr[i] 表示比 i 小的数字的个数 最后遍历 nums ，取出对应桶里的结果即可。
	 */
	private static int[] smallerNumbersThanCurrent1(int[] nums) {
		int[] bucket = new int[101];
		for (int num : nums) {
			bucket[num]++;// 初始化记数桶 记录每个数字出现的次数
		}
		// 桶中间处理，积累前面的桶结果，从前到后累加
		for (int i = 1; i < bucket.length; i++) {
			bucket[i] += bucket[i - 1];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] > 0 ? bucket[nums[i] - 1] : 0;
		}
		return nums;
	}
}
