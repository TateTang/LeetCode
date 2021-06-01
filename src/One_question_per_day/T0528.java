package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/6/1 2:04 下午
 * @Description 477. 汉明距离总和
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 给你一个整数数组 nums，请你计算并返回 nums 中任意两个数之间汉明距离的总和。
 * 示例 1：
 * 输入：nums = [4,14,2]
 * 输出：6
 * 解释：在二进制表示中，4 表示为 0100 ，14 表示为 1110 ，2表示为 0010 。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6
 * 示例 2：
 * 输入：nums = [4,14,4]
 * 输出：4
 */
public class T0528 {
    public static void main(String[] args) {
        int[] nums = {4, 14, 4};
        System.out.println(new T0528().totalHammingDistance2(nums));
    }

    /*循环的方式，单独求值，会超出时间限制*/
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum += hammingDistance(nums[i], nums[j]);
            }
        }
        return sum;
    }

    public int hammingDistance(int x, int y) {
        /*
        异或性质：
        1、相同数值异或，结果为 0
        2、任意数值与0异或，结果为数值本身
        3、异或本身满足交换律
        异或，不同为1，相同为0
        异或后统计其中1的个数
         */
        return Integer.bitCount(x ^ y);
    }

    public int totalHammingDistance2(int[] nums) {
        /*
         *位运算的方法
         * 1、设定二进制数的范围，因为数组元素的最大值位10^9，这里可以设置二进制数为30位，因为10^9 < 2^30
         * 2、使用位运算，逐一比较数据元素的每一位二进制是否为1，使用(nums[j]>>i) & 1判断，计算出当前位上为1的数组元素有几个
         * 3、计数完一位，便计算不同的数量，使用c*(numSize -c )，numSize数组元素的个数
         * 4、2～3步骤不断进行，对结果进行累加，得到正确答案
         */
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; i++) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }
}
