package offer;

/**
 * @Author tangmf
 * @Date 2021/12/13 11:23 上午
 * @Description 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 */
public class Offer65 {
    public static void main(String[] args) {
        int a = 8;
        int b = 9;
        System.out.println(new Offer65().add(a, b));
    }

    public int add(int a, int b) {
        /*
         使用位运算实现加法，设两数字的二进制形式a，b，求和s = a+b ，a(i)代表二进制第i位，分为下面四种情况
         a(i)   b(i)    无进位和n(i)    进位c(i+1)
          0      0          0              0
          0      1          1              0
          1      0          1              0
          1      1          0              1
          观察发现 [无进位和] 与异或运算算规律相同，同0异1
          [进位] 与 [与运算]规律相同(并且需要左移动一位)，&：同时1才是1，左移一位：*2
          因此得出计算公式
            n = a^b       非进位和：异或运算
            c = a & b <<1 进位：与运算 + 左移一位
            （和s） = （非进位和n） + （进位c），s=a+b ==> s = n + c，
          循环求n 和 c，直至进位c=0，此时s = n，直接返回n即可

          例子 20,17
          20        0 0 0 1 0 1 0 0
          17        0 0 0 1 0 0 0 1
     (异或)非进位和   0 0 0 0 0 1 0 1
       (&)进位       0 0 0 1 0 0 0 0
          和s        0 0 0 1 0 1 0 1 ===>37
            Q：若数字a和b中有负数，则变成了减法，如何处理
            A：计算机系统中，数值一律用补码来表示和存储，补码优势：加法、减法可以统一处理。因此，以上方法同时适用于
            正数和负数的加法

         */
        //因为不允许用+号，所以求出异或部分和进位部分依然不能用+ 号，所以只能循环到没有进位为止
        while (b != 0) {//当进位为 0 的时候跳出
            int c = (a & b) << 1;//c = 进位；保存进位值，下次循环用
            a = a ^ b;//a = 非进位和：异或求值，也就是n，保存不进位值，下次循环用
            b = c;//b = 进位，也就是s，如果还有进位，再循环，如果没有，则直接输出没有进位部分即可
        }
        return a;
    }
}
