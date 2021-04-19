package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/4/19 11:42 上午
 * @Description 27. 移除元素
 * 给你一个数组 nums 和一个值 val，
 * 你需要原地移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1：
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * 示例 2：
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 */
public class T0419 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 2;
        System.out.println(removeElement(nums, val));
        for (int num : nums) {
            System.out.println(num);
        }

    }

    public static int removeElement(int[] nums, int val) {
        /*
        双指针解法：
        右指针right指向当前要处理的元素，左指针left指向下一个要赋值的位置
         - 如果右指针元素不等于val(nums[i]!=val)，一定是输出数组的一个元素，将右指针指向的元素复制到
           左指针位置，左右指针同时右移；
         - 右指针指向的元素等于val，不能在输出数组里，此时左指针不动，右指针右移一位
         保存不变的性质：区间[0:left]中的元素都不等于val，左右指针遍历完输入数组后，left就是输出数组的长度
         */
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;//左指针
        //右指针指向当前元素
        for (int right = 0; right < nums.length; right++) {
            if (val != nums[right]) {
                nums[left] = nums[right];
                left++;//左右指针同时右移
            }
        }
        return left;
    }

    public static int removeElement1(int[] nums, int val) {
        /*
        双指针优化解法：
        题目中提示[元素的顺序可以改变]，如[1,2,3,4,5] val =1，实际上可以将5和1交换。
        定义两个指针，left 和right，分别指向首尾，向中间遍历
        - 左指针left指向的元素等于val，此时将right指针指向的元素复制到left位置，右指针right左移以一位
        - 赋值过来的元素刚好等于val num[right]=val，把右指针right指向的元素赋值过来(左指针left指向的
        等于val的元素的位置被覆盖)，直到左指针指向的元素不等于val为止
        - 重合的时候，左右指针遍历完数组的所有元素
        - 这样的放在两个指针在最坏的情况下合起来只遍历了数组一次。避免了需要保留的元素的重复赋值操作
         */
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;//左指针
        int right = nums.length;//右指针
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;//右指针左移
            } else {
                left++;//左指针右移
            }
        }
        return left;
    }
}
