package Brix;

/**
 * @author tangmf
 * @date 2022年09月16日 18:11:​39
 * 给定一个由左括号和右括号组成的字符串（和）’，通过根据需要插入括号来平衡括号。确定必须插入的最小字符数。
 */
public class T02 {
    public static void main(String[] args) {
        String str = "()))";
        System.out.println(getMin(str));
    }

    public static int getMin(String s) {
        // need 变量记录右括号的需求量，res 记录左括号插入次数
        int need = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 遇到左括号，匹配右括号，对右括号的需求 + 1
                need++;
            }
            if (s.charAt(i) == ')') {
                // 遇到右括号，对右括号的需求 - 1
                need--;
                if (need == -1) {
                    // 右括号太多，插入一个左括号平衡，同时左括号计为0
                    need = 0;
                    res++;
                }
            }
        }
        //s = "))(" 插入 2 个左括号之后，还要再插入 1 个右括号，使得s变成"()()()"，才是一个合法括号串。
        return need + res;
    }
}
