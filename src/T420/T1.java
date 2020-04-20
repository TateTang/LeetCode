package T420;

/**
 * @Author tangmf
 * @Date 2020/4/20 13:40
 * @Description 给你一个仅由数字 6 和 9 组成的正整数 num。
 *
 *              你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 *
 *              请返回你可以得到的最大数字。
 *
 *               
 *
 *              示例 1：
 *
 *              输入：num = 9669 输出：9969 解释： 改变第一位数字可以得到 6669 。 改变第二位数字可以得到 9969 。
 *              改变第三位数字可以得到 9699 。 改变第四位数字可以得到 9666 。 其中最大的数字是 9969 。 示例 2：
 *
 *              输入：num = 9996 输出：9999 解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
 */
public class T1 {

	public static void main(String[] args) {
		int num = 9996;
		System.out.println(maximum69Number(num));
	}

	public static int maximum69Number(int num) {
		// 可以将这个数转换成字符串进行处理，从左到右进行遍历，找到第一个6，转换成9后结束遍历；如果没有找到6，则不作任何处理。
		StringBuilder builder = new StringBuilder(String.valueOf(num));
		for (int i = 0; i < builder.length(); i++) {
			if (builder.charAt(i) == '6') {// 寻找 没有找到返回 找到转换成9后结束
				builder.setCharAt(i, '9');
				break;
			}
		}
		return Integer.parseInt(builder.toString());
	}
}
