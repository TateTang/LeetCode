package hw;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author tangmf
 * @date 2022年09月10日 16:41:​57
 * 进制转换
 * 描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * 数据范围：
 * 输入描述：
 * 输入一个十六进制的数值字符串。
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 * 示例1
 * 输入：
 * 0xAA
 * 输出：
 * 170
 */
public class HJ5 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            //只截取后面2个字符，0x 是16字符的固定写法 AA——>10*16 +10*1=170
            String s1 = str.substring(2);
            int a = Integer.valueOf(s1, 16);
            System.out.println(a);
        }
    }
}
