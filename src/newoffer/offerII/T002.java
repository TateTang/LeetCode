package newoffer.offerII;

/**
 * @author tangmf
 * @date 2022年08月31日 15:45:​01
 * 剑指 Offer Il 002. 二进制加法
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 示例 1:
 * 输入: a = "11", b = "10"
 * 输出: "101"
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class T002 {
    public static void main(String[] args) {
        String a = "11";
        String b = "10";
        System.out.println(new T002().addBinary1(a, b));
    }

    public String addBinary(String a, String b) {
        /**
         * 如果字符串超过 3333 位，不能转化为 Integer
         * 如果字符串超过 6565 位，不能转化为 Long
         * 如果字符串超过 500000001500000001 位，不能转化为 BigInteger
         */
        // 出现溢出问题，进制转换问题
        Integer i1 = Integer.valueOf(a, 2);
        Integer i2 = Integer.valueOf(b, 2);
        return Integer.toBinaryString(i1 + i2);
    }

    public String addBinary1(String a, String b) {
        //二进制运算中 【逢二进一】
        StringBuilder bf = new StringBuilder();
        // 定义变量n，carry 进位，0代表不进位，1代表进位
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; i++) {
            // 从最低位开始，只要位数多的那个数还没有运算完毕就继续运算
            // ai a的最低位开始，bi b的最低位开始
            int ai = i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            int bi = i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            // 当前位，进位
            int curr = (ai + bi + carry) % 2;
            carry = (ai + bi + carry) / 2;
            bf.append(curr);
        }
        if (carry == 1) {
            //最高位存在进位的时候
            bf.append(carry);
        }
        return bf.reverse().toString();//从最低位开始，所以需要翻转
    }
}
