package offer;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2021/8/20 2:20 下午
 * @Description 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 */
public class Offer57 {
    public static void main(String[] args) {
        int[] nums = {10, 26, 30, 31, 47, 60};
        int target = 40;
        System.out.println(Arrays.toString(new Offer57().twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        //双指针
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                //大于目标值，说明右指针指向的节点大了，right--
                right--;
            } else if (sum < target) {
                //小于目标值，说明左指针指向的节点小了，left++
                left++;
            } else {
                //相等的时候，直接返回该数组即可
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[0];
    }
}
