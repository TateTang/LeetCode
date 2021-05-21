package One_question_per_day;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author tangmf
 * @Date 2021/5/14 2:58 下午
 * @Description 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，
 * 即为两个并列的 1。12 写做 XII ，即为 X + II 。
 * 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。
 * 但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 * 示例 1:
 * 输入: num = 3
 * 输出: "III"
 * 示例 2:
 * 输入: num = 4
 * 输出: "IV"
 * 示例 3:
 * 输入: num = 9
 * 输出: "IX"
 */
public class T0514 {
    public static void main(String[] args) {
        int num = 8;
        System.out.println(new T0514().intToRoman(num));
    }

    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC ");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        //map中有值直接返回
        if (map.get(num) != null) {
            return map.get(num);
        } else {
            if (num > 10) {
                return null;
            }else {
                //num是一个数字的时候
            }
        }

        StringBuilder builder = new StringBuilder();
        if (num > 10) {
            int count = num / 10;//需要处理的次数
        }
        return null;
    }

}
