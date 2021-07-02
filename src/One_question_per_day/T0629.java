package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/6/30 10:43 上午
 * @Description 168. Excel表列名称
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如：
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *  
 * 示例 1：
 * 输入：columnNumber = 1
 * 输出："A"
 * 示例 2：
 * 输入：columnNumber = 28
 * 输出："AB"
 * 示例 3：
 * 输入：columnNumber = 701
 * 输出："ZY"
 * 示例 4：
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 */
public class T0629 {
    public static void main(String[] args) {
        int columnNumber = 701;
        System.out.println(new T0629().convertToTitle(columnNumber));
    }

    public String convertToTitle(int columnNumber) {
        /*
        AB = 26^0 + 26^1 = 26
        AZ = 28+(Z-A)=28+25=53
        ZY = (Z*Z) +  =26 * 26 + 25 =701
        ZA = 26 ^2 +1 =677
        解法： 每个位置取值为[1，26]，正常的为[0,26]
        1、从1开始的26进制转换题
        2、对于一般性的进制转化题目，只需要不断地对num进行 % 取余运算取得最后一位，
        然后对 num 进行 / 除运算，将已经取得的位数去掉，直到num为0即可
        3、一般性的进制转换问题无需要进行额外的操作，因为前提的数值范围[0,x] 逢x进1
        4、本题从1开始，在「进制转换」操作钱，需要先对num进行减1操作，从而实现整体便偏移
         */
        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;//实现整体的偏移
            builder.append((char) (columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }
        builder.reverse();
        return builder.toString();
    }
}
