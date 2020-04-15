package T415;

/**
 * @Author tangmf
 * @Date 2020/4/15 10:59
 * @Description 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 *              返回可以通过分割得到的平衡字符串的最大数量。 示例 1：
 *
 *              输入：s = "RLRRLLRLRL" 输出：4 解释：s 可以分割为 "RL", "RRLL", "RL", "RL",
 *              每个子字符串中都包含相同数量的 'L' 和 'R'。
 */
public class T2 {

	public static void main(String[] args) {
		String s = "RLRRLLRLRL";
		System.out.println(balancedStringSplit(s));
		int i = 10;
        if (i++ == 10) {
            ++i;
        } else {
            --i;
        }
        System.out.println(i);

	}

	private static int balancedStringSplit(String s) {
		/*
		 * 这是一个适用贪心算法的问题，在适当的位置截断源串得到平衡子串，截断后前后子串的计数不互相影响（无后效性），
		 * 且所有局部最优相加即为整体的最优解。 解决思路： 设置一个'L'与'R'的差值计数器diffCount，设置一个平衡子串计数器count；
		 * 顺序遍历源串字符，遇L则diffCount+1，遇到R则diffCount-1；
		 * 每遍历一个字符检查一次diffCount是否为0，若为0则count+1
		 */
		if (s == null || "".equals(s)) {
			return 0;
		}
		int count = 0;// 平衡子串计数器
		int diffCount = 0;// 差值计数器
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'R') {
				diffCount++;
			} else {
				diffCount--;
			}
			if (diffCount == 0) {// 差值为0，说明是平衡子串，计数器加1
				count++;
			}
		}
		return count;
	}
}
