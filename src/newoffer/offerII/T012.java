package newoffer.offerII;

import java.util.Arrays;

/**
 * @author tangmf
 * @date 2022年09月01日 10:11:​48
 * 剑指 Offer II 012. 左右两边子数组的和相等
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * 示例 1：
 * 输入：nums = [1,7,3,6,5,6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * <p>
 * 示例 2：
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * <p>
 * 示例 3：
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 */
public class T012 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(new T012().pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        /*
         * 对于中心下标，该下标将数组分成三个部分：左侧子数组，中心下标，右侧子数组
         * 用总的数组和total,减去当前数组和sum,如果差等于当前数组和减去当前值（sum-nums[i]）,则找到该坐标i
         * 左侧元素之和sum，右侧元素和为 total-num[i]-sum ，sum = total-num[i]-sum
         * 2sum + num[i] = total
         */
        // total 总和，sum：左边之和
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            //左侧元素之和sum==右侧元素和为 total-num[i]-sum ，sum = total-num[i]-sum --> 2sum + num[i] = total
            if (total == 2 * sum + nums[i]) {
                return i;
            }
            // 左侧元素之和，需要加上
            sum += nums[i];
        }
        return -1;
    }
}
