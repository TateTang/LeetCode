package Brix;

/**
 * @author tangmf
 * @date 2022年09月16日 18:23:​11
 * 有效的 HackerRank 电子邮件的格式为 user@hackerrank.com，用户的特征是：
 * 1.它以字符类[az]表示的1到 6个小写英文字母开头。
 * 2.小写字母后跟可选的下划线，即下划线〞”字符出现零次或一次。
 * 3.可选下划线后跟0到4个可选数字，由字符类/0-9/表示。
 */
public class T03 {
    public static void main(String[] args) {
        String s = "^[a-z]{1,6}[_]?[0-9]{0,4}@hackerrank.com";
    }

}
