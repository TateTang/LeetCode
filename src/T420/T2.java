package T420;

/**
 * @Author tangmf
 * @Date 2020/4/20 14:10
 * @Description 实现函数 ToLowerCase()，该函数接收一个字符串参数
 *              str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 *               
 *
 *              示例 1：
 *
 *              输入: "Hello" 输出: "hello"
 */
public class T2 {

	public static void main(String[] args) {
		String str = "Hello";
		System.out.println(toLowerCase(str));
	}

	private static String toLowerCase(String str) {
		return str.toLowerCase();
	}
}
