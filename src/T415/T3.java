package T415;

/**
 * @Author tangmf
 * @Date 2020/4/15 15:30
 * @Description 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *               
 *
 *              示例 1：
 *
 *              输入：s = "We are happy." 输出："We%20are%20happy."
 *
 */
public class T3 {

	public static void main(String[] args) {
		String s = "We are happy.";
		System.out.println(replaceSpace(s));

	}

	public static String replaceSpace(String s) {
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if ((s.charAt(i) == ' ')) {
//                builder.append("%20");
//            } else {
//                builder.append(s.charAt(i));
//            }
//        }
//        return builder.toString();
        return s.replaceAll(" ","%20");
    }
}
