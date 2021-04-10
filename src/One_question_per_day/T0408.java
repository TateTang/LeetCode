package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/4/8 6:23 下午
 * @Description 153. 寻找旋转排序数组中的最小值
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * 例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]]旋转一次的结果
 * 为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。
 * 请你找出并返回数组中的 最小元素 。
 * 示例 1：
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
 */
public class T0408 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin1(nums));
    }

    public static int findMin(int[] nums) {
        /*
        旋转排序数组 3 4 5 1 2
        1、假设最小值出现的位置是pivot，那么[0:pivot-1] > [pivot:N-1]，
        而且[0:pivot-1] 以及 [pivot:N-1]区间 是单调递增的，所以根据二分中点mid的元素大小和nums[left]比较，
        就能知道当前mid是处于[0:pivot-1] 还是 [pivot:N-1]区间
        2、定义left 和 right 包含最小值pivot的左边界和右边界，闭区间
            - 刚开始搜索时，nums[left]<nums[right]，说明数组是有序的，直接返回left的位置
            - 否则，输入是一个旋转有序数组，则pivot在left和right之中，根据定义，left 和 right移动的过程中，
            也一定存在nums[left]>nums[right]
        🌰 [3，4，5，1，2]
        1、left 和right 指向0 和 4 ，mid 指向2
        2、此时 nums[mid]>=nums[left]，说明mid处于[0:pivot-1]中，此时最小值在mid右边，left指向mid的位置
        3、left和right分别指向2 和4 ，mid指向3，nums[mid]<nums[left]说明mid处于[pivot:N-1]中，此时最小值
        在mid左边，right指向mid的位置3
        4、left和right分别指向2 和 3，由于pivot在[left:right]，说明最小元素是right（因为）移动过程中
        存在nums[left]>nums[right]，
         */
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        int mid = left;
        while (nums[left] >= nums[right]) {
            if (left + 1 == right) {
                mid = right;//有序直接返回
                break;
            }
            mid = (left + right) / 2;//中间基准值
            if (nums[mid] >= nums[left]) {
                //说明mid处于[0:pivot-1]中，此时最小值在mid右边，left指向mid的位置
                left = mid;
            } else if (nums[mid] <= nums[right]) {
                //说明mid处于[pivot:N-1]中，此时最小值在mid左边，right指向mid的位置
                right = mid;
            }
        }
        return nums[mid];
    }

    public static int findMin1(int[] nums) {
        /*
        官方解法：
        1、区间[0:mid-1]递增的，区间[mid:N-1]也是递增的
        2、最小值右侧的元素都严格小于x，最小值左侧的元素都严格大于x
        2、定义左边界left，右边界right，中间点mid，
            - nums[mid]<nums[right]，说明nums[mid]在最小值的右边，然后找左边
            - nums[mid]>nums[right]，说明nums[mid]在最小值的左边，然后找右边
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
                //说明nums[mid]是最小值右侧的元素，然后找左边
                right = mid;//有可能之间元素就是最小值
            } else {
                //说明nums[mid]是最小值左侧的元素，然后找右边
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
