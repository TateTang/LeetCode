package hw;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author tangmf
 * @date 2022年09月10日 16:29:​13
 * HJ4 字符串分隔
 * 描述
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 */
public class HJ4 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            split(s);
        }
    }

    public static void split(String s) {
        while (s.length() >= 8) {
            //大于8，先以8位作为一段截取，再判断剩余字符串长度与8比较，
            // 如果小于8,照上述操作，大于8，先截取8位，再判断剩下的...如此循环操作。
            System.out.println(s.substring(0, 8));
            s = s.substring(8);
        }
        if (s.length() > 0) {
            //小于8,在后面补上0，只截取8位
            s += "00000000";
            System.out.println(s.substring(0, 8));
        }
    }
}
