package hw.jsms.lx;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author tangmf
 * @date 2022年10月19日 10:37:​09
 * 962. 最大宽度坡
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 * 示例 1：
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * 示例 2：
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 */
public class T05 {
    public static void main(String[] args) {
        int[] nums = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        System.out.println(new T05().maxWidthRamp(nums));
    }

    public int maxWidthRamp(int[] nums) {
        /*
        1、构建单调栈（寻找坡底）
            1.1 宽度最大，A[i]尽可能小，A[j]尽可能大，从左往右遍历，构建一个单调递减栈
            1.2 假设存在一个元素索引为k，不存在于单调递减序列中，则最大宽度为j-k,也就说明k是小于单调递减序列中的数的，可是k既然小于这些数，则k也必然存在于单调递减栈中，
            与假设相反，因此我们所求的符合要求的最小A[i]的i必然在我们构建的单调递减栈中。这一步骤其实是在找坡底的过程。
        2、遍历求最大宽度（寻找坡顶）
            2.1 已经可以将坡底的可能元素找出,那么就是一个找坡顶的过程，
            2.2 必然是从右往左开始遍历寻找，而且此时坡顶索引只要小于等于坡底索引，遍历就可以提前结束了
         */
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            // 栈中存放的是元素索引,构建单调栈的通用过程
            while (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }
        for (int i = nums.length - 1; i > ans; i--) {
            //从右往左开始遍历寻找，坡顶所以只要小于坡底元素，遍历提前结束
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                int curr = stack.pop();
                ans = Math.max(ans, i - curr);
            }
        }
        return ans;
    }
}
