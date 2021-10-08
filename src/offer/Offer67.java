package offer;

/**
 * @Author tangmf
 * @Date 2021/10/2 9:43 上午
 * @Description 剑指 Offer 67. 把字符串转换成整数
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 */
public class Offer67 {
    public static void main(String[] args) {
        String str = "42";
        System.out.println(new Offer67().strToInt(str));
    }

    public int strToInt(String str) {
        /*
        四种字符需要考虑
        - 首部空格：删除即可
        - 符号位：三种情况，+ - "无富豪"；新建一个变量保存符号位，返回前判断正负即可
        - 非数字字符：遇到首个非数字的字符的时候，应该立即返回
        - 数字字符：
         - 字符转数字：此数字的ASCII码 和 0的ASCII码相减即可
         - 数字拼接：若从左向右遍历数字，设当前位字符为c，当前数字为x，数字结果为res，则拼接公式为
           res=10*res +x
           x = ascii(c)-ascii('0')
        数字越界处理
        - 每轮数字拼接前，判断res 在此轮拼接后是否超过2147483647，若超过则加上符号位置直接返回，
        设数字拼接边界 bindry = 2147483647//10 =   214748364，以下两种情况越界
         - res > bndry :    情况一：执行拼接 10*res > 2147483650 越界
         - res = bndry，x>7  情况二：拼接后是2147483648 或 2147483649 越界
        */
        char[] chars = str.trim().toCharArray();//去除str首位的多余空格
        if (chars.length == 0) return 0;//如果array长度为0，返回0
        int res = 0, sign = 1, i = 1;//sign表示标识位，1为正，-1为负，i代表array从何处开始遍历
        int limit = Integer.MAX_VALUE / 10;//设置限制值，因为在遍历中先判断res是否越界，再向res复制，因此对limit的要求/10
        if (chars[0] == '-') sign = -1;//如果array[0]=-表明该数是负数，sign=-1
        else if (chars[0] != '+') i = 0;//不是+号，从头遍历
        for (int j = i; j < chars.length; j++) {
            if (chars[j] > '9' || chars[j] < '0') break;//判断当前字符是否数字，不是直接退出即可
            //当res等于limit 需要判断array[j]是否大于Integer.MAX_VALUE 的末位数7
            if (res > limit || res == limit && chars[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (chars[j] - '0');//数字值拼接
        }
        return sign * res;//带上符号位置
    }
}
