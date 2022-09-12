package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author tangmf
 * @date 2022年09月10日 16:59:​17
 * HJ6 质数因子
 * 描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * <p>
 * <p>
 * 数据范围： 1 \le n \le 2 \times 10^{9} + 14 \1≤n≤2×10
 * 9
 * +14
 * 输入描述：
 * 输入一个整数
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
 * 示例1
 * 输入：
 * 180
 * 输出：
 * 2 2 3 3 5
 */
public class HJ6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 2; i <= num; ) {
            if (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            } else {
                i++;
            }
        }
    }
}
