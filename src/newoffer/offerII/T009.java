package newoffer.offerII;

/**
 * @author tangmf
 * @date 2022年09月09日 10:19:​45
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 * 示例 1:
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * <p>
 * 示例 2:
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 */
public class T009 {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(new T009().numSubarrayProductLessThanK(nums, k));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        /*
         * 滑动窗口
         * 我们固定子数组 [i, j]的右端点 j 时，显然左端点 i 越大，子数组元素乘积越小。
         * 1.对于子数组 [i, j]当左端点 i>l1时，所有子数组的元素乘积都小于 k，当左端点 l<l1时，所有子数组的元素乘积都大于等于 k。
         * 2.对于右端点为j+1 的所有子数组，它的左端点 i 就不需要从 0 开始枚举，因为对于所有 i<l1的子数组，它们的元素乘积都大于等于 k。
         * 3.我们只要从 i = l1处开始枚举，直到子数组 i = l2时，子数组 [l2, j + 1]的元素乘积小于 kk，那么左端点 i >=l2,所有子数组的元素乘积都小于 k。
         * 4.根据上面的分析，我们枚举子数组的右端点 j，并且左端点从 i = 0，
         *  4.1 i=0 开始，用 prod 记录子数组 [i,j] 的元素乘积。
         *  4.2 每枚举一个右端点 j，如果当前子数组元素乘积 prod 大于等于 k，那么我们右移左端点 i 直到满足当前子数组元素乘积小于 k 或者 i > j
         *  4.3那么元素乘积小于 kk 的子数组数目为 j - i + 1j−i+1。返回所有数目之和。
         */
        //i：左边界，ret 返回值,prod 子数组 [i,j]的乘积，j 右边界
        int i = 0, ret = 0, prod = 1, n = nums.length;
        for (int j = 0; j < n; j++) {
            prod = prod * nums[j];//更新窗口内部信息
            while (i <= j && prod >= k) {
                //当前子数组乘积 >= k，右移动左边界i，直到满足当前子数组元素小于i或者i>j，
                // 那么元素乘积小于 k的子数组数目为 j−i+1。返回所有数目之和
                prod = prod / nums[i];
                i++;
            }
            //代表是满足条件的直接ret 更新即可：固定j时，连续子数组的长度
            ret += j - i + 1;
        }
        return ret;
    }
}
