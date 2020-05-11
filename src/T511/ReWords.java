package T511;

/**
 * @Author tangmf
 * @Date 2020/5/11 13:43
 * @Description 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *              示例 1:
 *
 *              输入: "Let's take LeetCode contest" 输出: "s'teL ekat edoCteeL
 *              tsetnoc" 
 */
public class ReWords {

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s));
	}

	private static String reverseWords(String s) {
		StringBuilder builder = new StringBuilder();
		String[] strings = s.split(" ");
		for (String str : strings) {
			builder.append(new StringBuilder(str).reverse()).append(" ");
		}
		return builder.toString().trim();// 删除额外空白字符的字符串返回。
	}
}
