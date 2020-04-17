package other;

/**
 * @Description
 * @Author tangmf
 * @Date 2020/4/9 14:27 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。 示例 1：
 *
 *       输入：n = 234 输出：15 解释： 各位数之积 = 2 * 3 * 4 = 24 各位数之和 = 2 + 3 + 4 = 9 结果 =
 *       24 - 9 = 15
 */
public class Test4 {

	public static void main(String[] args) {
		int n = 234;
		System.out.println(subtractProductAndSum(n));
	}

	private static int subtractProductAndSum(int n) {
		int sum = 0;
		int multiply = 1;
		while (n > 0) {
			sum += n % 10;// 从个位数开始计算，求出各位数之和 2 3 4
			multiply *= n % 10;// 从个位数开始计算，各位数之乘积2 3 4
			n = n / 10; // 从个位数开始剔除，每次除以10 23 2 0
		}
		return multiply - sum;
	}
}
