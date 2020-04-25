package T425;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author tangmf
 * @Date 2020/4/25 10:29
 * @Description 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 *              示例 1：
 *
 *              输入: s = "leetcode" 输出: false
 */
public class T2 {

	public static void main(String[] args) {
		String astr = "leetcode";
		System.out.println(isUnique(astr));
	}

	private static boolean isUnique(String astr) {
		// 方法1：用map/set存放，利用去重
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < astr.length(); i++) {
			set.add(astr.charAt(i));
		}
		return set.size() == astr.length();//set中不能存在重复元素，返回值即可
		// 方法2：indexof lastindexof

		// for (char ch : astr.toCharArray()) {
		// if (astr.indexOf(ch) != astr.lastIndexOf(ch)) {
		// return false;
		// }
		// }
		// return true;

		// 方法3：arr[ch - 'a']!=0

	}
}
