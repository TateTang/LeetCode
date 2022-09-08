package newoffer.offerII;

/**
 * @author tangmf
 * @date 2022年09月08日 10:50:​34
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class T008 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        int target = 11;
        System.out.println(new T008().minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        /*
        前缀+二分
        利用 nums[i]数据范围是[1,10^5]，可知前缀和数组满足[单调递增]
        1.先预处理出前缀和数组 sum（前缀和数组下标默认从1开始），
        2.对于nums[i]而言，假设其对应的前缀和值为 s = sum[i+1]，将 nums[i]视为子数组的右端点
        3.问题转化为：在前缀和数组下标[0,i]范围内找到满足[值小于等于 s-t] 的最大下标，充当子数组左端点的前一个值
        利用前缀和数组的[单调递增]（具有二段性），可以使用[二分]来做
        时间复杂度：预处理前缀和数组的复杂度为 O(n)，遍历前缀和数组统计答案复杂度为 O(nlogn)，整体复杂度为 O(nlogn)
        空间复杂度：O(n)
         */
        int n = nums.length, ans = n + 10;
        int[] sum = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            // 前缀和值
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            // 前缀和s=sum[i]，d 满足的值
            int s = sum[i], d = s - target;
            int l = 0, r = i;
            while (l < r) {
                // 二分查找
                int mid = l + r + 1 >> 1;
                if (sum[mid] <= d) {
                    l = mid; // 比中间索引的数字大则右边区域查找
                } else {
                    r = mid - 1;// 比中间索引的数字小则左边区域查找
                }
            }
            if (sum[r] <= d) {
                // 满足条件，找到 ans 中最小的值
                ans = Math.min(ans, i - r);
            }
        }
        return ans == n + 10 ? 0 : ans;
    }
}
