package T417;

/**
 * @Author tangmf
 * @Date 2020/4/17 10:37
 * @Description 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 *              给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 *              注意： 0 ≤ x, y < 231.
 *
 *              示例:
 *
 *              输入: x = 1, y = 4
 *
 *              输出: 2
 *
 *              解释: 1 (0 0 0 1) 4 (0 1 0 0) ↑ ↑
 *
 *              上面的箭头指出了对应二进制位不同的位置。
 */
public class T2 {

	public static void main(String[] args) {
		int x = 1;
		int y = 4;
		 System.out.println(hammingDistance(x, y));
//		System.out.println(1 & 0);
        System.out.println(5<<2);//5 左移两位 相当于 5 * 2^2
	}

	private static int hammingDistance(int x, int y) {
		/*
		 * 第一步：将x，y按位异或得到i，将问题转化为求i的二进制位中1的个数count。
		 * 第二步：当i不为0时，将i与1按位与，
		 * 第三步：判断二进制末尾是不是1，是，count++ 将i右移一位
		 * 第四步：重复第二，第三步，直到第二步条件不满足，，即i==0时终止统计， 即可得到i的二进制位中1的个数，解决
		 *
		 */
		int i = x ^ y; //异或 1 0 为1 00 为 0 0 1 为1
		int count = 0;
		while (i != 0) {
			if ((i & 1) == 1) { // 两位同时为“1”，结果才为“1”，否则为0统计其中1的个数
				count++;
			}
			i = i >> 1;//向右移一位相当于 i /2
		}
		return count;
	}
}
