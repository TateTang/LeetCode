package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/4/28 10:00 上午
 * @Description 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c 。
 * 示例 1：
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 * 输入：c = 2  1*1+1*1
 * 输出：true
 * 示例 5：
 * 输入：c = 1 1*1
 * 输出：true
 */
public class T0428 {
    public static void main(String[] args) {
        int c = 5;
        System.out.println(new T0428().judgeSquareSum1(c));
    }

    public boolean judgeSquareSum(int c) {
        /*
        前言 sqrt函数
        对于给定的非负整数c,需要判断是否存在整数a和b,使得a^2+b^2=c。
        可以枚举a和b所有可能的情况, 时间复杂度为O(c2)。但是暴力枚举有一些情况是没有必要的。
        例如:当c=20时,当a=1的时候,枚举 b的时候,只需要枚举到b=5就可以结束了,
        这是因为1^2+5^2=25>20。当b>5时,一定有1^2+b^2>20
        注意到这一点,可以使用sqrt函数或者双指针降低时间复杂度。

        枚举a
        边枚举边检查是否存在 b 使得等式成立。
        时间复杂度为O(√c)
         */
        int sqrtc = (int) Math.sqrt(c);//√c
        for (long a = 0; a <= sqrtc; a++) {
            long b = (long) Math.sqrt(c - a * a);//b的值
            if (a * a + b * b == c) return true;
        }
        return false;
    }

    public boolean judgeSquareSum1(int c) {
        /*
        双指针：由于a，b的范围都是[0:√c]，因此可以使用「双指针」在[0:√c]范围中进行扫描
        1、a^2+b^2==c：找到符合条件的a ，b 直接返回true
        2、a^2+b^2<c：当前值比目标值小，a++
        3、a^2+b^2>c：当前值比目标值大，b--
         */
        int a = 0, b = (int) Math.sqrt(c);//定义两个直接a，b分别为边界值
        while (a <= b) {
            int curr = a * a + b * b;
            if (curr == c) {
                return true;
            } else if (curr < c) {
                a++;//当前值小于目标值
            } else {
                b--;//当前值大于目标值
            }
        }
        return false;
    }
}
