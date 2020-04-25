package T425;

/**
 * @Author tangmf
 * @Date 2020/4/25 10:22
 * @Description 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 *
 *              示例：
 *
 *              输入： a = 1, b = 2 输出： 2
 */
public class T1 {

	public static void main(String[] args) {
		int a = 1, b = 2;
		System.out.println(maximum(a, b));
	}

	private static int maximum(int a, int b) {
		return a > b ? a : b;
	}
}
