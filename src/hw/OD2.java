package hw;

import java.util.Scanner;

/**
 * @author tangmf
 * @date 2022年09月16日 16:09:​01
 * 已知火星人使用的运算符为＃、＄，其与地球人的等价公式如下：
 * x#y=4*X+3*Y+2
 * X$y = 2*X+Y+3
 * 1、其中x、y是无符号整数
 * 2、地球人公式按C语言规则计算
 * 3、火星人公式中，＃的优先级高于$，相同的运算符，按从左到右的顺序计算
 * 现有一段火星人的字符串报文，请你来翻译并计算结果。
 * # 优先级高于 $
 */
public class OD2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(calculate(sc.nextLine()));
    }

    public static int calculate(String str) {
        /*
        X#Y = 4*X+3*Y+2
        X$Y = 2*X+Y+3
        # 优先级高于 $，
        不会整型溢出
        */
        // 对于符合 $ 计算，!=1说明找到了，放最前面，拦截，处理优先级问题
        int index1 = str.lastIndexOf("$");
        if (index1 != -1) {
            //说明存在了$，进行计算，左边的值，右边的值
            String leftValue = str.substring(0, index1);
            String rightValue = str.substring(index1 + 1);
            //使用递归进行计算，左边和右边的值，递归后，如果字符串包含了 #就会去先进行#的运算了
            return 2 * calculate(leftValue) + calculate(rightValue) + 3;
        }
        //对于符号 # 计算，优先级最高，最先算 !=1说明找到了，lastIndexOf，子字符串最后一次出现的索引
        int index2 = str.lastIndexOf("#");
        if (index2 != -1) {
            //说明存在了#，进行计算，左边的值，右边的值
            String leftValue = str.substring(0, index2);
            String rightValue = str.substring(index2 + 1);
            //使用递归进行计算，左边和右边的值
            return 4 * calculate(leftValue) + 3 * calculate(rightValue) + 2;
        }
        // 都不存在 直接返回即可
        return Integer.parseInt(str);
    }
}
