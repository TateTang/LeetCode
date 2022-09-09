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
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(new T008().minSubArrayLen2(target, nums));
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

    public int minSubArrayLen1(int target, int[] nums) {
        /*
        滑动窗口：指针处在数组同一方向，根据条件移动左右指针，用于范围和等等
        滑动窗口解题模板
        不同于咱们第一章学习的整数那般没有规律，滑动窗口可是有模板可套的。通过模板我们可以快速完成解题，
        但前提是，首先你要知道，题目属于滑动窗口的解题范围。那么滑窗的题目怎么识别呢？一般题目中都会有明确的“连续子数组”、“连续子串”等关键字，另外可能会附带最大、最小的限定词进行补充。
        那么遇到这类型题目，该如何思考呢？分为以下几步：
        1.初始化窗口左边界为0，右边界可以为0，也可以根据题意固定大小。
        2.我们需要初始化一个ret的返回值，默认为0或者根据题意默认为最大值。
            2.1最小值根据题意选择0 或者Java: Integer.MIN_VALUE ; Python:-float('inf')
            2.2最大值根据题意选择 Java: Integer.MAX_VALUE Python： float('inf')
        3.窗口的大小需要根据题目条件进行调整
        3.1 最大连续...尽量扩张右边界，直到不满足题意再收缩左边界
        3.2 最小连续...尽量缩小左边界，直到不满足题意再扩大右边界
        4.在执行3操作的过程中，不断与ret进行比较
        5.最终返回ret结果即可。
        具体模板如下：
        初始化左边界 left = 0
        初始化返回值 ret = 最小值 or 最大值
        for 右边界 in 可迭代对象:
	        更新窗口内部信息
	        while 根据题意进行调整：
		        比较并更新ret(收缩场景时)
		        扩张或收缩窗口大小
	        比较并更新ret(扩张场景时)
        返回 ret
        套模板
        长度最小的限制：分析题意滑窗思维没毛病。
        题目条件：满足滑窗内数字之和需要大于等于target。
        返回值ret：符合条件的子数组长度。
         */
        int left = 0;
        int total = 0;
        int ret = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            total += nums[right];//求和
            while (total >= target) {
                //数字之和大于等于target时候，更新ret，
                ret = Math.min(ret, right - left + 1);
                total = total - nums[left++];
            }
        }
        return ret > nums.length ? 0 : ret;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        /*
         * 滑动窗口在方法一中，每次确定子数组的开始下标，然后得到长度最小的子数组，因此时间复杂度较高。为了降低时间复杂度，可以使用滑动窗口的方法。
         * 1.定义两个指针 start 和 end 分别表示子数组（滑动窗口窗口）的开始位置和结束位置，
         * 2.维护变量 sum 存储子数组中的元素和（nums[start] 到nums[end] 的元素和）。
         * 3.初始状态下，start 和 end 都指向下标 0,sum 的值为 0。
         * 4.每一轮迭代，将 ums[end] 加到 sum，如果 sum≥s，则更新子数组的最小长度
         *  4.1此时子数组的长度是 end−start+1，
         *  4.2然后将nums[start] 从 sum 中减去并将 start 右移，直到 sum<s，在此过程中同样更新子数组的最小长度。
         *  4.3在每一轮迭代的最后，将 end 右移。
         */
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        //定义返回值，start end 左右边界，sum nums[start] 到 nums[end]的和
        int ans = Integer.MAX_VALUE, start = 0, end = 0, sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                //大于目标值，更新子数组的最小长度(子数组的长度 end-start+1)
                // ，将nums[start]从sum 中剔除并且 start 右移动，直到sum<target，同样要更新子数组的最小长度
                ans = Math.min(ans, end - start + 1);
                sum = sum - nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
