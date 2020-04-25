package T424;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2020/4/24 9:36
 * @Description 自除数 是指可以被它包含的每一位数除尽的数。
 *
 *              例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 *
 *              还有，自除数不允许包含 0 。
 *
 *              给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 *              示例 1：
 *
 *              输入： 上边界left = 1, 下边界right = 22 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9,
 *              11, 12, 15, 22]
 */
public class T1 {

	public static void main(String[] args) {
		int left = 128;
		int right = 128;
		System.out.println(selfDividingNumbers(left, right));
	}

	private static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> list = new ArrayList<>();
		// 数字转化成字符数字
		for (int i = left; i <= right; i++) {
			char[] chars = String.valueOf(i).toCharArray();
			boolean sign = true;// 自然数标识
			for (char c : chars) {
				// 数字转换为字符数字
				int temp = (c - 48);
				if (temp == 0 || i % temp != 0) {//等于0 或者 i%temp!=0 就不是自然数，sign=false 跳出循环
					sign = false;
					break;
				}
			}
			if (sign) {
				list.add(i);
			}
		}
		return list;
	}
}
