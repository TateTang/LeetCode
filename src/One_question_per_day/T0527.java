package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/5/31 11:55 上午
 * @Description 461. 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * 示例 1：
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 示例 2：
 * 输入：x = 3, y = 1
 * 输出：1
 */
public class T0527 {
    public static void main(String[] args) {
        int x = 3;
        int y = 1;
        System.out.println(1 ^ 4);
        System.out.println(new T0527().hammingDistance(x, y));
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

    public int hammingDistance2(int x, int y) {
        /*
        右移统计
        1、每次同统计当前x和y的最后一位，统计完成后则将x和y右移一位
        2、当x和y的最高一位1都被统计过之后，循环结束
         */
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }
}
