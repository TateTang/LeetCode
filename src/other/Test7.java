package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2020/4/9 15:24
 * @Description 给你一个以行程长度编码压缩的整数列表 nums 。
 *
 *              考虑每对相邻的两个元素 freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >=
 *              0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
 *
 *              请你返回解压后的列表。 示例：
 *
 *              输入：nums = [1,2,3,4] 输出：[2,4,4,4] 解释：第一对 [1,2] 代表着 2 的出现频次为
 *              1，所以生成数组 [2]。 第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
 *              最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
 */
public class Test7 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(decompressRLElist(nums)));
	}

	/**
	 * 因为事先不知道最终数组有多少个元素，所以先定义一个列表list； 然后遍历给定数组的数组对，
	 * 因为是成对出现，所以遍历次数只需要给定数组长度的一半；
	 * 向列表list中加入解码的元素（上一步中数组对中的第一个元素作为频次，第二个元素作为数组中出现的数）；
	 * 定义一个int类型数组resultArr作为最终结果； 将list转换为int数组，即将list中数据存入resultArr；
	 * 返回结果数组resultArr
	 */
	private static int[] decompressRLElist(int[] nums) {
		List<Integer> list = new ArrayList<>();// 事先不知道最终数组有多少个元素，所以先定义一个列表list,然后遍历给定数组的数组对
		for (int i = 0; i < nums.length / 2; i++) {// 因为是成对出现，所以遍历次数只需要给定数组长度的一半；
			for (int j = 0; j < nums[2 * i]; j++) { // nums[2*i]为频次
				list.add(nums[2 * i + 1]);// num[2*j+1] 为次数
			}
		}
		int[] arr = new int[list.size()];// 创建数组
		for (int i = 0; i < list.size(); i++) {// list转换成数组
			arr[i] = list.get(i);
		}
		return arr;
	}
}
