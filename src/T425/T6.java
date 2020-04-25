package T425;

/**
 * @Author tangmf
 * @Date 2020/4/25 11:56
 * @Description 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
 *
 *              返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
 *
 *               
 *
 *              示例 1：
 *
 *              输入：n = 4 输出："pppz" 解释："pppz" 是一个满足题目要求的字符串，因为 'p' 出现 3 次，且 'z'
 *              出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ohhh" 和 "love"。
 *
 */
public class T6 {

	public static void main(String[] args) {
		int n = 4;
		System.out.println(generateTheString(n));
	}

	private static String generateTheString(int n) {
		if (n % 2 == 0) {// 则返回仅由'a'形成的大小为n的字符串

		} else {// 否则返回由n-1'a'和1'b'形成的字符串。

		}
		return null;
	}
}
