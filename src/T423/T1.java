package T423;

/**
 * @Author tangmf
 * @Date 2020/4/23 14:38
 * @Description
 */
public class T1 {

	public static void main(String[] args) {
		int n = 11;
        System.out.println(5>>1);
		System.out.println(hammingWeight(n));
	}

	private static int hammingWeight(int n) {
		// int count = 0;
		// String str = Integer.toBinaryString(n);// 转为二进制字符串
		// for (int i = 0; i < str.length(); i++) {
		// if (str.charAt(i) == '1')
		// count++;
		// }
		// return count;

		// 我们每次将此数&1 ，如果结果等于1，证明此数的最后一位是1,count++； 然后在将数右移一位，
		// 循环下去，直到此数==0，即可统计出其中1的个数
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {//判断二进制末尾是不是1，是，count++ 将i右移一位
				count++;
			}
			n = n >>> 1;// 向右移一位相当于 i /2的一次方
		}
		return count;
	}
}
