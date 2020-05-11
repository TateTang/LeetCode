package T511;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2020/5/11 11:09
 * @Description 给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
 *
 *              如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
 *
 *              与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
 *
 *              注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列。
 *
 *               
 *
 *              示例 1：
 *
 *              输入：nums = [4,3,10,9,8] 输出：[10,9] 解释：子序列 [10,9] 和 [10,8]
 *              是最小的、满足元素之和大于其他各元素之和的子序列。但是 [10,9] 的元素之和最大。 
 */
public class SubSequence {

	public static void main(String[] args) {
		int[] nums = { 4, 3, 10, 9, 8 };
		System.out.println(minSubsequence(nums));
	}

	public static List<Integer> minSubsequence(int[] nums) {
		/*
		 * 首先题目对答案的额外要求：长度最短，且元素和最大，另外子数组并不需要连续。从示例来看并不要求保持原数组的相对顺序。
		 * 那就可以按从大到小的顺序挑选元素了，毕竟元素从大的选取，那么满足该子序列的元素之和 严格
		 * 大于未包含在该子序列中的各元素之和时，选的元素个数肯定最少且子序列和最大。 1、所以先将数组进行排序。
		 * 2、需要知道子序列的和，以及除去子序列后剩余元素的和。我们可以先遍历一遍原数组，求出数组所有元素之和left。
		 * 3、然后从数组最后一个元素开始第二次遍历，用sum记录子序列的和。对于每一个元素nums[i] 4、更新子序列的和sum +=
		 * nums[i] 5、更新除去子序列后剩余元素的和left -= nums[i] 6、将元素添加到子序列中res.add(nums[i])
		 * 7、判断该子序列的元素之和是否严格大于未包含在该子序列中的各元素之和，如果是中止循环。 最后返回结果List即可。
		 * 时间复杂度为O(nlog(b))O(nlog(b))。空间复杂度为O(k)O(k)，k为满足条件的子序列的最短长度。
		 */
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums);
		int sum = 0, sums = 0;
		for (int i : nums)
			sums += i;// 求出所有元素之和
		for (int i = nums.length - 1; i >= 0; i--) {
			sum += nums[i];// 子序列的和
			sums -= nums[i];// 更新除去子序列后剩余元素的和
			list.add(nums[i]);
			if (sum > sums) { // 子序列之和大于未包含在该子序列中的各元素之和 跳出整个循环
				break;
			}

		}
		return list;
	}
}
