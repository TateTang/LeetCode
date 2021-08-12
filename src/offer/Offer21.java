package offer;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2021/8/10 4:13 下午
 * @Description 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class Offer21 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new Offer21().exchange(nums)));
    }

    public int[] exchange(int[] nums) {
         /*
        双指针优化解法：
        题目中提示[元素的顺序可以改变]，如[1,2,3,4,5] val =1，实际上可以将5和1交换。
        定义两个指针，left 和right，分别指向首尾，向中间遍历
        - 左指针left指向的元素%2==0，此时将right指针指向的元素复制到left位置，右指针right左移一位
        - 重合的时候，左右指针遍历完数组的所有元素
        - 这样的放在两个指针在最坏的情况下合起来只遍历了数组一次。避免了需要保留的元素的重复赋值操作
         */
        if (nums.length == 0) {
            return new int[0];
        }
        int left = 0;//左指针
        int right = nums.length;//右指针
        while (left < right) {
            if (nums[left] % 2 == 0) {
                //左指针指向元素偶数，且右指针偶数，right左移
                if (nums[right - 1] % 2 != 0) {
                    //左指针指向元素偶数，且右指针奇数，交换
                    int temp = nums[left];
                    nums[left] = nums[right - 1];
                    nums[right - 1] = temp;
                }
                right--;//右指针左移
            } else {
                //代表左指针奇数，left++
                left++;
            }
        }
        return nums;
    }
}
