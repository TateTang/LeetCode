package newoffer.offerII;

/**
 * @author tangmf
 * @date 2022年09月09日 09:10:​18
 * 剑指 Offer II 072. 求平方根
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
 * 正数的平方根有两个，只输出其中的正数平方根。
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * 输入: x = 4
 * 输出: 2
 * 示例 2:
 * 输入: x = 8
 * 输出: 2
 * 解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
 */
public class T072 {
    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(new T072().mySqrt1(x));
    }

    public int mySqrt(int x) {
        // 直接解法
        return (int) Math.sqrt(x);
    }

    public int mySqrt1(int x) {
        /* 二分查找
         *x平方根的整数部分 k^2 <=x的最大k 值，因此对k进行二分查找，得到答案
         * 1.二分查找左边界为 0,右边界为x，二分查找的每一步中，只需要比较元素mid的平方和x的大小关系
         * 2.通过比较结果，调整左右边界，所有运算为整数运算，不回存在误差
         * 3.得到最终答案后，直接返回即可
         * */
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;//等价于 left + right >>1 left + right /2
            //需要注意int * int 的最大值 转换为long
            if ((long) mid * mid <= x) {
                //满足条件，记录并且调整左边界，说明在右边区域
                ans = mid;
                left = mid + 1;
            } else {
                //不满足条件，调整右边界，说明在左边区域
                right = mid - 1;
            }
        }
        return ans;
    }

}
