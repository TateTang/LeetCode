package Stack.T826;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2020/8/26 10:36 下午
 * @Description 71. 简化路径以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。 在 Unix
 * 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux /
 * Unix中的绝对路径 vs 相对路径 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 /
 * 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * 示例 1：
 * <p>
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 示例 2：
 * <p>
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 示例 3：
 * <p>
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 */
public class T71 {

    public static void main(String[] args) {
        String path = "/home/";
        System.out.println(simplifyPath(path));
    }

    private static String simplifyPath(String path) {
        /*
         解题思路：
         首先需要弄清楚的, '.' 没有任何操作，'..'需要返回上一级，也就是将当前的元素进行一个出站处理
         1、首先使用栈来存储路径信息，定义字符数组，str 来分隔字符串
         2、依次遍历字符串数组内容，使用for循环， 如果是 ..还需要 再判断是为空才能够弹出栈
         3、如果不为空，也不为. ，说明当前元素是路径信息，入栈就可以了
         4、遍历完之后，先判断栈中是否有元素，没有返回 /
         5、如果有元素，使用stringbuilder来存放可变字符串，最后返回ans 就可以了
         */
        Stack<String> stack = new Stack<>();
        // 1、首先使用栈来存储路径信息，定义字符数组，str 来分隔字符串
        String[] paths = path.split("/");
        for (String s : paths) {
            //如果数组非空，并且访问到的是 .. 则说明需要返回上一级，要将当前元素出栈
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();//栈顶元素出栈，并且返回栈顶的值
                }
            } else if (!".".equals(s) && !"".equals(s)) {
                //如果不为空，也不为 . 说明就是路径信息，入栈就可以了
                stack.push(s);
            }
        }
        //栈中没有元素，说明没有路径信息，返回/ 就可以了
        if (stack.isEmpty()) {
            return "/";
        }
        //有元素，需要拼接一下下
        StringBuilder builder = new StringBuilder();
        for (String s : stack) {
            builder.append("/").append(s);
        }
        return builder.toString();
    }
}
