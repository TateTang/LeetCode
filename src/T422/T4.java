package T422;

/**
 * @Author tangmf
 * @Date 2020/4/22 14:45
 * @Description 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 *
 *              字符（'a' - 'i'）分别用（'1' - '9'）表示。 字符（'j' -
 *              'z'）分别用（'10#' - '26#'）表示。  返回映射之后形成的新字符串。
 *
 *              题目数据保证映射始终唯一。
 *
 *               
 *
 *              示例 1：
 *
 *              输入：s = "10#11#12" 输出："jkab" 解释："j" -> "10#" , "k" -> "11#" , "a"
 *              -> "1" , "b" -> "2".
 */
public class T4 {

	public static void main(String[] args) {
		String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
		System.out.println(freqAlphabets(s));
	}

	private static String freqAlphabets(String s) {
		/*
		 * 将26个字母放到一个数组里 遍历字符串值，如果遇到#，则根据#前两位算出对应字母，否则根据当前位算出对应字母 注意：这里 char 转
		 * int 效率高的方法是 '1' - '0' = 1 ,如果 (int)'1' = 49 是错误的结果
		 */
		// 49 1 65 A 97 a
		char[] alphabetChars = new char[27];
		for (int i = 1; i < alphabetChars.length; i++) {
			alphabetChars[i] = (char) (96 + i); // 26个字母放入到数组中去
		}
		StringBuilder builder = new StringBuilder();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i < chars.length - 2 && chars[i + 2] == '#') {// 根据#前两位算出对应字母
				builder.append(alphabetChars[(chars[i] - '0') * 10 + (chars[i + 1] - '0')]);// 获取到组装后的元素位置的元素
				i += 2;
			} else {
				builder.append(alphabetChars[(chars[i] - '0')]);// 直接获取在字母数组中的对应位置的元素
			}
		}
		return builder.toString();
	}
}
