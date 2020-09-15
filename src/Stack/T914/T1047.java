package Stack.T914;

/**
 * @Author tangmf
 * @Date 2020/9/14 18:46
 * @Description 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，
 * 其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
public class T1047 {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String S) {
        /*
         *当前字母和栈顶的字母相同，弹出栈顶字母
         *当前字母和栈顶字母不相同，放入当前字母
         */
//        Stack<Character> stack = new Stack<>();
//        StringBuilder builder = new StringBuilder();
//        for (char ch : S.toCharArray()) {
//            if (!stack.isEmpty()) {
//                if (stack.peek() != ch) {
//                    stack.push(ch);
//                } else {
//                    //需要加入的元素等于栈顶元素不进行入栈操作
//                    stack.pop();
//                }
//            } else {
//                stack.push(ch);
//            }
//        }
//        for (Character character : stack) {
//            builder.append(character);
//        }
//        return builder.toString();

        StringBuilder builder = new StringBuilder();
        int builderLength = 0;
        for (char character : S.toCharArray()) {
            if (builderLength != 0 && character == builder.charAt(builderLength - 1))
                builder.deleteCharAt(builderLength-- - 1);
            else {
                builder.append(character);
                builderLength++;
            }
        }
        return builder.toString();

    }
}
