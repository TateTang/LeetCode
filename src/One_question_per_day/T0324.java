package One_question_per_day;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2021/3/24 2:29 下午
 * @Description 456. 132 模式 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列
 * 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * <p>
 * 示例 2：
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2]
 * <p>
 * 示例 3：
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 */
public class T0324 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(find132pattern2(nums));
    }

    public static boolean find132pattern(int[] nums) {
        // nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j]
        /*
        我选择的方法是维护132模式中间的那个数字3，因为3在132的中间的数字、也是最大的数字。
        我们的思路是个贪心的方法:我们要维护的1是3左边的最小的数字；2是3右边的比3小并且比1大的数字。
        从左到右遍历一次,遍历的数字是nums[j]也就是132模式中的3。
        根据上面的贪心思想分析,我们想让1 是3左边最小的元素,然后使用暴力在nums[j+1...N-1]中找到132模式中的2就行。
         */
        int numsi = nums[0];//定义最小元素 i
        for (int j = 0; j < nums.length; j++) {
            for (int k = nums.length - 1; k > j; k--) {
                //找到nums[i]<nums[k] 切 nums[k] < nums[j]
                if (numsi < nums[k] && nums[k] < nums[j]) {
                    return true;
                }
                numsi = Math.min(numsi, nums[j]);//最小值替换
            }
        }
        return false;
    }

    public static boolean find132pattern1(int[] nums) {
        /*
        对应关系
        nums[i]<nums[k]<nums[j]
        1           3           2
        nums[i]     nums[j]    nums[k]
        单调栈：维护132模式中的3，希望1 尽可能的小，2尽可能的大
        思路：
            遍历的位置j相当于132模式中的3，即nums[j];
            找到3左边最小的元素为1,即nums[i];
            找到3右边最大的元素为2,即nums[k]

            暴力求解中求得2的方法满足两个条件：
            比3小，在nums[j+1 .... N-1]中最大，也就是132中的2
        为了可以找到这样的元素，可以使用一个单调的栈，
        所谓的单调栈：栈中的元素都是依次递增或者递减的，方便我们维护一个数组区间内的最大值和次大值等等。
        要想要一个比3小的最大元素，则需要一个单调递减的栈，这样的话，最大元素在栈底，次大元素在栈低的第二元素

        本题目的实现方式
            1、求任何位置的左边的最小元素nums[i]，可以提前遍历一遍得到
            2、使用单调递减栈，把nums[j]进行入栈的时候，把栈里面比他小的元素都需要pop出来，由于越往栈底越大，
               所以最后一个pop出来的元素,就是比3小的最大元素 也就是2，nums[k]
            3、如果nums[i]<nums[k] 就是一个132模式了，因为第二步满足了 nums[k] < 3(nums[j])
            4、单调栈建立在3的右边的，所以是有从右向左遍历

        当3入栈的时候，比3小的最大元素nums[k]会不会pop出去？
        确实被pop()出去，pop()出去的 最后一个元素，就是比3小的最大元素nums[k]
         */
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        //递减栈，栈里元素都是比k大元素 即j
        Deque<Integer> stack = new ArrayDeque<>();//双端队列
        int k = Integer.MIN_VALUE;//定义一个最小值
        // 逆序 这里保证 k的位置一定在 栈元素的 后边
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;//找到nums[i]<nums[k]即可 返回就是132 模式了，因为已经保证了nums[k]<nums[j]
            }
            //找到次大值即可，也就是2，nums[k]。不为空且最后一个元素(不弹出)小于当前nums[i]
            while (!stack.isEmpty() && stack.peekLast() < nums[i]) {
                k = Math.max(k, stack.pollLast());//找到k 和 栈底元素 中的最大值，也就是要找到次大元素2 nums[k]
            }
            stack.addLast(nums[i]);//栈底插入当前元素
        }
        return false;
    }

    public static boolean find132pattern2(int[] nums) {
        int len = nums.length;
        int k = Integer.MIN_VALUE; // 132中的2 j
        Stack<Integer> stack = new Stack<>();// 用来存储132中的3 nums[j]
        if (len < 3)
            return false;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;// 若出现132中的1则返回正确值 nums[i]<nums[k]
            }
            // 若当前值大于或等于2则更新2（2为栈中小于当前值的最大元素，也就是次大值）
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                k = stack.pop();//这里保证了 nums[k]<nums[j]
            }
            stack.push(nums[i]);// 将当前值压入栈中
        }
        return false;
    }
}
