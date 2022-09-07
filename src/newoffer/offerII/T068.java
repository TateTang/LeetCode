package newoffer.offerII;

import java.util.Arrays;

/**
 * @author tangmf
 * @date 2022年09月07日 09:36:​25
 * 剑指 Offer II 068. 查找插入位置
 * 给定一个排序的整数数组 nums 和一个整数目标值 target ，
 * 请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 示例 4:
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * <p>
 * 示例 5:
 * 输入: nums = [1], target = 0
 * 输出: 0
 */
public class T068 {
    public static void main(String[] args) {
        //int[] nums = {1, 3};
        //int target = 0;
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(new T068().searchInsert1(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        //在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置
        int mid = search(nums, target);
        if (mid != -1) {
            //找到目标值，直接返回
            return mid;
        } else {
            // 没有找到目标值，在插入值并且排序后的新数组中继续查找
            int[] res = Arrays.copyOf(nums, nums.length + 1);
            res[res.length - 1] = target;
            Arrays.sort(res);
            return search(res, target);
        }
    }

    public int search(int[] nums, int target) {
        // 二分查找
        int min = 0, max = nums.length - 1;
        // 注意，min 有可能等于max
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (nums[mid] > target) {
                max = mid - 1;// 比中间索引的数字小则关键字在左区域
            } else if (nums[mid] < target) {
                min = mid + 1;// 比中间索引的数字大则关键字在右区域
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int searchInsert1(int[] nums, int target) {
        /*
         * 因为不存在数组中的时候需要返回按顺序插入的位置，考虑插入的位置 pos，成立条件
         * nums[pos-1] < target <= nums[pos]
         * 1.如果存在目标值，返回的索引也是pos，因此何必得出最后的目标[在一个有序数组中找第一个大于等于target 的目标]
         * 2.
         */
        int min = 0, max = nums.length - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (nums[mid] > target) {
                max = mid - 1;// 比中间索引的数字小则关键字在左区域
            } else if (nums[mid] < target) {
                min = mid + 1;// 比中间索引的数字大则关键字在右区域
            } else {
                return mid;
            }
        }
        //出现 min >max，则目标值不存在，插入位置是left，直接返回
        return min;
    }
}
