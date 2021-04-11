package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/4/9 11:36 上午
 * @Description 154. 寻找旋转排序数组中的最小值 II
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次的结果为数组
 * [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，
 * 并按上述情形进行了多次旋转。请你找出并返回数组中的最小元素 。
 * 示例 1：
 * 输入：nums = [1,3,5]
 * 输出：1
 * 示例 2：
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 */
public class T0409 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        /*
        官方解法：
        1、区间[0:mid-1]递增的，区间[mid:N-1]也是递增的
        2、最小值右侧的元素都严格小于等于x，最小值左侧的元素都严格大于等于x，通过二分法找出最小值
        2、定义左边界left，右边界right，中间点mid，
            - nums[mid]<nums[right]，说明nums[mid]在最小值的右边，忽略mid的右边，然后找左边（忽略二分查找右半部分）
            - nums[mid]>nums[right]，说明nums[mid]在最小值的左边，忽略mid的左边，然后找右边（忽略二分查找左半部分）
            - nums[mid] ==nums[right]，由于重复元素的存在，不能够确定其nums[mid]在最小值的
            左边还是右边。唯一可以知道的是，由于它们的值相同，无论nums[right]是不是最小值，
            都有一个替代品nums[mid]，因此可以忽略也就是nums[mid]=nums[right]的时候
            可以忽略二分查找右端点
        3、区间长度为1 结束查找 区间就是left = right-1 也就是left <right而不是left<=right
        4、规律的说法
        当 while (left < right) 时，对应的更新式是 left = middle + 1 ， right = middle
        当 while (left <= right) 时，对应的更新式是 left = middle + 1，right = middle - 1
         */
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;//中间基准值
            if (nums[mid] < nums[right]) {
                //nums[mid]在最小值的右边，找左边
                right = mid;
            } else if (nums[mid] > nums[right]) {
                //nums[mid]在最小值的左边，忽略mid的左边，然后找右边
                left = mid + 1;
            } else {
                right -= 1;
            }
        }
        return nums[left];
    }
}
