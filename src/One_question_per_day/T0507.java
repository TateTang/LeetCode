package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/5/7 5:50 下午
 * @Description 1486. 数组异或操作
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * 示例 1：
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 * "^" 为按位异或 XOR 运算符。
 * 示例 2：
 * 输入：n = 4, start = 3
 * 输出：8
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 * 示例 3：
 * 输入：n = 1, start = 7
 * 输出：7
 * 示例 4：
 * 输入：n = 10, start = 5
 * 输出：2
 */
public class T0507 {
    public static void main(String[] args) {
        int n = 10;
        int start = 5;
        System.out.println(new T0507().xorOperation1(n, start));
    }

    public int xorOperation(int n, int start) {
        /*
        数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
        * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
         */
        int[] num = new int[n];//定义一个数组先
        for (int i = 0; i < n; i++) {
            num[i] = start + 2 * i;
        }
        int result = num[0];
        for (int i = 1; i < num.length; i++) {
            result = result ^ num[i];
        }
        return result;
    }

    public int xorOperation1(int n, int start) {
        /*
        按照题意模拟即可
        1、初始化ans=0
        2、遍历区间[0,n-1]中的每一个整数i,令ans与每一个start+2×i做异或运算;
        3、最终返回ans,即我们需要的答案。
         */
        int ans = 0;//定义一个数组先
        for (int i = 0; i < n; i++) {
            ans = ans ^ (start + 2 * i);
        }
        return ans;
    }
}
