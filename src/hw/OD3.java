package hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tangmf
 * @date 2022年09月16日 16:56:​54
 * 给定一组整数（非负），重排顺序后输出一个最大的整数。
 * <p>
 * 示例1：
 * <p>
 * 输入：[10，9]
 * <p>
 * 输出：910
 * <p>
 * 说明：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class OD3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(fun(s));
    }

    public static String fun(String s) {
        String[] arr = s.split(" ");
        Arrays.sort(arr, (str1, str2) -> {
            //自定义排序规则，一种是 o2o1组合，一种是o1o2组合，返回其中的最大值
            return (str2 + str1).compareTo((str1 + str2));
        });
        StringBuilder res = new StringBuilder();
        for (String str : arr) {
            //得到两两比较中的最大值，最后相加即可
            res.append(str);
        }
        return res.toString();
    }
}
