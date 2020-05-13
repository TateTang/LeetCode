package T513;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author tangmf
 * @Date 2020/5/13 10:30
 * @Description 给定两个数组，编写一个函数来计算它们的交集。
 *
 *              示例 1:
 *
 *              输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2]
 */
public class Section {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		System.out.println(Arrays.toString(intersection1(nums1, nums2)));
	}

	private static int[] intersection(int[] nums1, int[] nums2) {

		// 方法2：双指针
		// 先将nums1 与nums2 排序，然后游走两个指针，情况都写出来了，没有用else
		// 时间复杂度：O(nlogn)
		Set<Integer> set = new HashSet<>();// set中元素不重复
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				// 相同元素
				set.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {// 小于 nums1的指针游走
				i++;
			} else if (nums1[i] > nums2[j]) {// 大于 nums2的指针游走
				j++;
			}
		}
		int[] res = new int[set.size()];
		int index = 0;
		for (int num : set) {
			res[index++] = num;
		}

		return res;

	}

	private static int[] intersection1(int[] nums1, int[] nums2) {
		// 方法一：set解题
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
		Set<Integer> parentSet = new HashSet<>();
		Set<Integer> childSet = new HashSet<>();
		for (int num : nums1) {
			parentSet.add(num);// 添加到set中
		}
		for (int num : nums2) {
			if (parentSet.contains(num)) {
				childSet.add(num);// 存在才加入到其中
			}
		}
		int[] resArr = new int[childSet.size()];
		int index = 0;
		for (int value : childSet) {
			resArr[index++] = value;// 加减在后先运算 后加减
		}
		return resArr;
	}

}
