package offer;

/**
 * @Author tangmf
 * @Date 2021/8/7 8:43 下午
 * @Description 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class Offer05 {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(new Offer05().replaceSpace(s));
    }

    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                builder.append("20%");
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
