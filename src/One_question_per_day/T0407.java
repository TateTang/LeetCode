package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/4/7 9:42 上午
 * @Description 81. 搜索旋转排序数组 II
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
 * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * 示例 1：
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * 示例 2：
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 */
public class T0407 {
    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        //Arrays.sort(nums);//二分查找基于有序
        //return binarySearch(nums, target, 0, nums.length - 1);
        /*由于是旋转排序数组，可将数组分为左数组和右数组
        二分，判断mid在左数组还是右数组
        1、nums[mid] = target直接返回true
        2、如果nums[left]、nums[mid]、nums[right]数值相等，例如[1,0,1,1,1]和[1,1,1,0,1],无法判断0在左还是右，只能顺序查找
        3、如果mid在左数组，如果target在nums[left]和nums[mid]之间，right = mid - 1
        否则：left = mid + 1
        4、如果mid在右数组，如果target在nums[mid]和nums[right]之间，left = mid + 1
        否则：right = mid - 1
         */
        int min = 0, max = nums.length - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[min] == nums[mid]) {
                min++;
                continue;
            }
            if (nums[min] <= nums[mid]) {
                //处于左数组，左边
                if (nums[min] <= target && target < nums[mid]) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            } else {
                //处于右数组，右边
                if (nums[mid] < target && target <= nums[max]) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
        }
        return false;
    }

    /**
     * 二分查找算法
     *
     * @param arr   一维数组
     * @param value 需要查找的值
     * @param min   min长度
     * @param max   max长度
     */
    public static boolean binarySearch(int[] arr, int value, int min, int max) {
        int mid = (min + max) / 2;//基准值
        //没有找到值直接返回
        if (value < arr[min] || value > arr[max] || min > max) {
            return false;
        }
        if (arr[mid] < value) {
            return binarySearch(arr, value, mid + 1, max);
        } else if (arr[mid] > value) {
            return binarySearch(arr, value, min, mid - 1);
        } else {
            return true;//找到了 返回true
        }
    }
}
