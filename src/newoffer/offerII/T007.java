package newoffer.offerII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tangmf
 * @date 2022年09月07日 10:47:​02
 * 剑指 Offer II 007. 数组中和为 0 的三个数
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
public class T007 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new T007().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        /* 排序 + 双指针，使用三个指针 i、j、k 分别代表需要找的三个数
            1.通过枚举i 确定第一个数，另外两个指针 j,k分别从左边i+1 和右边n-1 往中间移动，
            找到满足 nums[i]+nums[j]+nums[k] == 0的所有组合
            2. j、k指针的移动逻辑，分别讨论 sums = nums[i]+nums[j]+nums[k] :
              2.1 sum > 0 : k 左移动，使 sum 变小
              2.2 sum < 0 : j 右移动，使 sum 变大
              2.3 sum = 0 ：符合条件
            3.题目答案要求不能包含重复的三元组，所以确定第一个数和第二个数时候，
            要跳过数值一样的下标（在三数之和确定的情况下，确保第一个数和第二个数不会重复，即可保证三元组不重复）。
            时间复杂度：O(n^2)
            空间复杂度：O(logN)
         */
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                //跳过数值一样的下标
                continue;
            }
            //定义 j,k 指针
            int j = i + 1, k = n - 1;
            while (j < k) {
                while (j > i + 1 && j < n && nums[j] == nums[j - 1]) {
                    j++;//确保第一个数和第二个数不重复
                }
                if (j >= k) {
                    break;//跳出本次循环
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                } else if (sum > 0) {
                    k--;//左移动，使 num 变小
                } else {
                    j++;//右移动，使 num 变大
                }
            }
        }
        return ans;
    }
}
