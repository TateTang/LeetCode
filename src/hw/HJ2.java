package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author tangmf
 * @date 2022年09月10日 16:10:​29
 * HJ2 计算某字符出现次数
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 * <p>
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000
 * 输入描述：
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
 * <p>
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 */
public class HJ2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        // 完整字符串
        String str1 = scanner.nextLine();
        // 单个字符串
        String str2 = scanner.nextLine();
        // 完整字符的长度-单个字符长度 = 出现的次数
        String str3 = str1.toUpperCase().replaceAll(str2.toUpperCase(), "");
        System.out.println(str1.length() - str3.length());
    }
}
