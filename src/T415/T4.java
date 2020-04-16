package T415;

/**
 * @Author tangmf
 * @Date 2020/4/15 17:58
 * @Description 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A
 *              和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 *
 *              如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A
 *              和 B 都是非空有效括号字符串。
 *
 *              给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... +
 *              P_k，其中 P_i 是有效括号字符串原语。
 *
 *              对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 *
 *               
 *
 *              示例 1：
 *
 *              输入："(()())(())" 输出："()()()" 解释： 输入字符串为 "(()())(())"，原语化分解得到
 *              "(()())" + "(())"， 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 */
public class T4 {

	public static void main(String[] args) {
		String s = "(()())(())";
		System.out.println(removeOuterParentheses(s));

	}

	private static String removeOuterParentheses(String S) {
		StringBuilder builder = new StringBuilder();
		int level = 0;// 差值计数器 就是其中左括号和右括号的计数器
		for (char c : S.toCharArray()) {// 遍历字符串中的全部字符
			if (c == ')')// 如果是左括号，level减1
				level--;
			if (level >= 1)// 当计数器大于等于1时，说明没有平衡进行操作即可
				builder.append(c);
			if (c == '(')// 如果是右括号，level加1
				level++;
		}
		return builder.toString();
		// 使用贪心算法
		// StringBuilder result = new StringBuilder();//结果
		// StringBuilder sb = new StringBuilder();//原语
		// int num = 0;//记录左右括号的个数是否相等
		// for (char c : S.toCharArray()) {//遍历字符串中的全部字符
		// if (c == '(') {//如果是左括号，num加1
		// num++;
		// } else {//如果是右括号，num减1
		// num--;
		// }
		// sb.append(c);//将字符添加到sb后面
		// if (num == 0) {//如果num的值为0，说明此时的sb是原语
		// result.append(sb.substring(1, sb.length() -
		// 1));//把sb左右两端的括号去掉，添加到result末尾
		// sb = new StringBuilder();//初始化sb
		// }
		// }
		// return result.toString();
	}
}
