package newoffer.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangmf
 * @date 2022年09月10日 09:37:​23
 * 剑指 Offer II 010. 和为 k 的子数组
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 * 示例 1：
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 * 示例 2：
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2
 */
public class T010 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(new T010().subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        /*
         * 这是一道经典的前缀和运用题。
         * 统计以每一个 nums[i]n为结尾，和为 k 的子数组数量即是答案。
         * 我们可以预处理前缀和数组 sum（前缀和数组下标默认从 1 开始），
         * 1.对于求解以某一个 nums[i] 为结尾的，和为 k 的子数组数量，
         * 2.本质上是求解在 [0, i]中，sum 数组中有多少个值为 sum[i+1]−k 的数，
         * 3.这可以在遍历过程中使用「哈希表」进行同步记录。
         */
        int n = nums.length, ans = 0;
        int[] sum = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            //前缀和
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        //初始化，前缀和sum[0]的下标是1
        map.put(0, 1);
        for (int i = 1; i <= n; i++) {
            // 前缀和s=sum[i]，d 满足的值
            int s = sum[i], d = s - k;
            // 记录sum数组中有多少个值为sum[i+1]-k的数量
            ans += map.getOrDefault(d, 0);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return ans;
    }
}
