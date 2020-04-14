package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2020/4/10 9:23
 * @Description 给定一个字符串，逐个翻转字符串中的每个单词。 示例 1：
 *
 *              输入: "the sky is blue" 输出: "blue is sky the" 示例 2：
 *
 *              输入: "  hello world!  " 输出: "world! hello" 解释:
 *              输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 示例 3：
 *
 *              输入: "a good   example" 输出: "example good a" 解释:
 *              如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 说明： 无空格字符构成一个单词。
 *              输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *              如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Test410 {

	public static void main(String[] args) {
		String s = " hello world!  ";
		System.out.println(reverseWords(s));
	}

	private static String reverseWords(String s) {
		StringBuilder builder = new StringBuilder();
		s = s.trim();// 去掉首尾空格
		if (s.equals("")) {
			return "";
		}
		String[] strArr = s.split(" ");// 中间以空格分隔 如果有多个空格，会被分隔出来，成为一个空字符串
		for (int i = strArr.length - 1; i >= 0; i--) {
			if (strArr[i].equals("")) {// 如果等于空字符串 跳出本次循环，中断循环中的迭代，不进行下一步
				continue;
			}
			builder.append(strArr[i]);
			builder.append(" ");// 追加到builder中去
		}
		return builder.toString().trim();
	}
}
