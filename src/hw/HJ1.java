package hw;

import java.util.Scanner;

/**
 * @author tangmf
 * @date 2022年09月10日 16:06:​08
 */
public class HJ1 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        System.out.println(s[s.length - 1].length());
    }
}
