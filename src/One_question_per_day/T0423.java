package One_question_per_day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2021/4/23 10:35 上午
 * @Description 368. 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，
 * 请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 */
public class T0423 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8};
        System.out.println(largestDivisibleSubset(nums));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        /*
         * 动态规划解法：
         * 「整除子集」：如果一个所有元素互不相同的集合中的任意元素存在整除关系，就称为整除子集。为了得到「最大整除子集」
         * 考虑从一个小的整除子集扩充称为更大的整除子集
         * 举个🌰，假设有原数组 [1,2,4,8]，“或许”我们期望的决策过程是：
        - 遍历到数字 1，此时「整除子集」为空，加到「整除子集」中；
        - 遍历到数字 2，与「整除子集」的最后一个元素（1）成倍数关系，加到「整除子集」中；
        - 遍历到数字 4，与「整除子集」的最后一个元素（2）成倍数关系，自然也与 2 之前的元素成倍数关系，加到「整除子集」中；
        - 遍历到数字 8，与「整除子集」的最后一个元素（4）成倍数关系，自然也与 4 之前的元素成倍数关系，加到「整除子集」中。
        * 但这样的做法只能够确保得到「合法解」，无法确保得到的是「最长整除子集」
        * 其本质是因为同一个数的不同倍数之间不存在必然的「倍数/约数关系」，而只存在「具有公约数」的性质，这会导致我们「模拟解法」错过最优解。
        * 比如上述 🌰，54 & 90 和 18 存在倍数关系，但两者本身不存在倍数关系。
        因此当我们决策到某一个数 nums[i] 时（nums 已排好序），我们无法直接将 nums[i] 直接接在符合「约数关系」的、最靠近位置 i 的数后面，而是要检查位置 i 前面的所有符合「约数关系」的位置，找一个已经形成「整除子集」长度最大的数。
        换句话说，当我们对 nums 排好序并从前往后处理时，在处理到 nums[i] 时，我们希望知道位置 i 之前的下标已经形成的「整除子集」长度是多少，然后从中选一个最长的「整除子集」，将 nums[i] 接在后面（前提是符合「倍数关系」）。
        * 基于上述分析：发现是一个序列DP问题：某个状态的转移依赖于与前一个状态的关系，即nums[i]能够接在nums[j]后面，取决于是否
        * 满足nums[i]%nums[j]==0，可以看作是「最长上升子序列」问题的变形
        * 1、定义dp[i]为考虑前i个数字，且以第i个数为结尾的「最长整除子集」长度
        * 2、不失一般性的考虑任意位置i，存在两种情况：
        *   - 如果在i之前找不到符合条件nums[i]%nums[j]==0的位置j，那么nums[i]不能接在位置i之前的任何数的后面，
        *    只能子集独立作为「整除子集」的第一个数，此时状态方程为dp[i]=1
        *   - 如果i之前找到符合条件nums[i]%nums[j]==0的位置j，则取所有符合条件dp[j]的最大值，
        *      - 代表如果希望找到以nums[i]为结尾的「最长整除子集」，需要将nums[i]接到符合条件的
        *      最长的nums[j]后面
        *      - 此时状态方程为：dp[i]=dp[j]+1;
        * 3、由于需要输出具体方案，需要额外使用g[]数组记录每个状态是由哪个状态转移而来
        * 4、定义g[i]为记录dp[i]由哪个下标的状态转移而来，如果dp[i]=dp[j]+1，则有g[i]=j。
        * 5、对于求方案数的题目，多开一个数组来记录状态从何转移而来是最常见的手段
        * 6、求得所有的状态值之后，对dp[]数组进行遍历，取得具体的「最长整除子集」长度和对应下标
        * 7、使用g[]数组进行回溯，取得答案
         */
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            //至少包含自身一个数，因此起始长度为1，由自身转移而来
            int len = 1, prev = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    //如果能接在更长的序列后面，则更新「最大长度」& 「从何转移而来」
                    if (dp[j] + 1 > len) {
                        len = dp[j] + 1;
                        prev = j;
                    }
                }
            }
            //记录「最终长度」何「从何转移而来」
            dp[i] = len;
            g[i] = prev;
        }
        //遍历所有的dp[i]，取得「最大长度」和「对应下标」
        int max = Integer.MIN_VALUE, idx = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                idx = i;
                max = dp[i];
            }
        }
        // 使用 g[] 数组回溯出具体方案
        List<Integer> ans = new ArrayList<>();
        while (ans.size() != max) {
            ans.add(nums[idx]);
            idx = g[idx];
        }
        return ans;
    }
}
