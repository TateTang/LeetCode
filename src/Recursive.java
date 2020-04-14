/**
 * @Description
 * @Author tangmf
 * @Date 2020/1/16 13:55
 */
public class Recursive {

	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(f(3));
	}

	/**
	 * 求 n 的阶乘
	 */
	public static int factorial(int n) {
		// 第二步的临界条件
		if (n <= 1) {
			return 1;
		}

		// 第二步的递推公式
		return n * factorial(n - 1);
	}

	/**
	 *
	 * 一只青蛙可以一次跳 1 级台阶或一次跳 2 级台阶,例如:跳上第 1 级台阶只有一种跳法：直接跳 1 级即可。跳上第 2 级台阶有两种跳法：每次跳
	 * 1 级，跳两次；或者一次跳 2 级。问要跳上第 n 级台阶有多少种跳法？
	 */
	public static int f(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int result = 0;
		int pre = 1;
		int next = 2;

		for (int i = 3; i < n + 1; i++) {
			result = pre + next;
			pre = next;
			next = result;
		}
		return result;
	}
}
