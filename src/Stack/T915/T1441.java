package Stack.T915;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2020/9/15 6:33 下午
 * @Description 1441. 用栈操作构建数组
 * 给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
 * <p>
 * 请使用下述操作来构建目标数组 target ：
 * <p>
 * Push：从 list 中读取一个新元素， 并将其推入数组中。
 * Pop：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 * 请返回构建目标数组所用的操作序列。
 * 题目数据保证答案是唯一的。
 * 示例 1：
 * <p>
 * 输入：target = [1,3], n = 3
 * 输出：["Push","Push","Pop","Push"]
 * 解释：
 * 读取 1 并自动推入数组 -> [1]
 * 读取 2 并自动推入数组，然后删除它 -> [1]
 * 读取 3 并自动推入数组 -> [1,3]
 * 示例 2：
 * <p>
 * 输入：target = [1,2,3], n = 3
 * 输出：["Push","Push","Push"]
 * 示例 3：
 * <p>
 * 输入：target = [1,2], n = 4
 * 输出：["Push","Push"]
 * 解释：只需要读取前 2 个数字就可以停止。
 * 示例 4：
 * <p>
 * 输入：target = [2,3,4], n = 4
 * 输出：["Push","Pop","Push","Push","Push"]
 */
public class T1441 {
    public static void main(String[] args) {
        int[] target = {1, 3};
        int n = 3;
        System.out.println(buildArray(target, n));
    }

    private static List<String> buildArray(int[] target, int n) {
        /*
        1、i从1遍历到n,同时从头开始对比target元素
        2、当元素i在target里面时只记录push操作,然后target移到下一元素
        3、否则丢弃该元素,即push再pop
         */
        Stack<String> stack = new Stack<>();
        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            //push 保留，push 和 pop 丢弃
            if (i < target[j]) {
                //当i小于target当前值时,丢弃当前元素,即记录push再pop
                stack.push("Push");
                stack.push("Pop");
            } else if (i == target[j]) {
                //出现在其中的时候，需要进行push，而且需要target往下走
                stack.push("Push");
                j++;
            }
        }
        return new ArrayList<>(stack);
    }
}
