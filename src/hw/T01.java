package hw;

import java.util.*;

/**
 * @author tangmf
 * @date 2022年09月16日 10:07:​32
 * 【字符串中的第一个唯一字符】给定一个字符串 input，
 * 找到它的不重复的第一个字符，并返回它的值。
 * 如果不存在，则返回空[空字符串]
 */
public class T01 {
    public static void main(String[] args) {
        //String input="ilovestudy";
        String input = "goodgoodstudy";
        //String input = "goodgoodstudy";
        System.out.println(new T01().findFirstChar(input));
        double a=1;int b=2;
        Scanner in = new Scanner(System.in);
        //while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        //    int a = in.nextInt();
        //    int b = in.nextInt();
        //    System.out.println(a + b);
        //}

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }

    public String findFirstChar(String input) {
        //插入排序，统计次数，取出第一个即可
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = input.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);
        String res = "";
        for (Character character : map.keySet()) {
            if (map.get(character) == 1) {
                res = String.valueOf(character);
                break;
            }
        }
        // write code here
        return res;
    }
}
