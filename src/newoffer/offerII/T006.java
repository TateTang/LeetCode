package newoffer.offerII;

import java.util.Arrays;

/**
 * @author tangmf
 * @date 2022年08月31日 18:16:​51
 * 剑指 Offer II 006. 排序数组中两个数字之和
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 * 示例 1：
 * 输入：numbers = [1,2,4,6,10], target = 8
 * 输出：[1,3]
 * 解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
 * <p>
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[0,2]
 * <p>
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[0,1]
 */
public class T006 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 6, 10};
        int target = 8;
        System.out.println(Arrays.toString(new T006().twoSum(numbers, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        // 双指针解法，左指针，右指针
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            // 求和，因为是排序的，所以就行了
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                // 需要加值，左指针向右边移动
                left++;
            } else if (sum > target) {
                // 需要减值，右指针向左移动
                right--;
            } else {
                //和相等的时候，记录 left , right
                return new int[]{left, right};
            }
        }
        return new int[0];
    }
}

