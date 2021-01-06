package Stack.T0106;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2021/1/6 2:58 下午
 * @Description 1598. 文件夹操作日志搜集器
 * 每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。
 * <p>
 * 下面给出对变更操作的说明：
 * <p>
 * "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
 * "./" ：继续停留在当前文件夹。
 * "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
 * 给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。
 * <p>
 * 文件系统启动时位于主文件夹，然后执行 logs 中的操作。
 * <p>
 * 执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。
 * 输入：logs = ["d1/","d2/","../","d21/","./"]
 * 输出：2
 * 解释：执行 "../" 操作变更文件夹 2 次，即可回到主文件夹
 * 输入：logs = ["d1/","d2/","./","d3/","../","d31/"]
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：logs = ["d1/","../","../","../"]
 * 输出：0
 */
public class T1598 {
    public static void main(String[] args) {
        String[] logs = {"d1/","../","../","../"};
        System.out.println(minOperations(logs));
    }

    public static int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String log : logs) {
            if (!log.equals("../") && !log.equals("./")) {
                stack.push(log);//入栈
            } else if (!stack.isEmpty() && log.equals("../")) {
                //到父文件夹，如果已经在主文件夹下则继续停留在当前文件夹。
                stack.pop();//出栈
            }
        }
        return stack.size();
    }
}
