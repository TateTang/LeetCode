package newoffer.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangmf
 * @date 2022年09月12日 15:26:​50
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * 示例 1：
 * <p>
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * 示例 2：
 * <p>
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 */
public class T011 {
    public static void main(String[] args) {
        //int[] nums = {0, 1};
        int[] nums = {0, 1, 0};
        //int[] nums = {0, 1, 0, 1, 0, 1};
        System.out.println(new T011().findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {
        /*
        由于题目说明「0和1的数量相同」等价于「1的数量减去0的数量等于0」，可以将数组中的0视为-1，原问题转换为
        「求最长的连续子数组，元素和为0」
        1.根据题意，我们可以轻易发现如下性质：如果答案非 0，那么子数组长度必然为偶数，且长度至少为 2。
        2.具体的，我们在预处理前缀和时，将 nums[i] 为 0 的值当做 −1 处理。
        3.从而将问题转化为：如何求得最长一段区间和为 0 的子数组。
        4.同时使用「哈希表」来记录「某个前缀和出现的最小下标」是多少。
         */
        int n = nums.length, ans = 0;
        int[] sum = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            //前缀和，0当作-1处理即可，非0其实就是只有1
            sum[i] = sum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        //初始化，前缀和 0 出现的最小下标是0
        map.put(0, 0);
        for (int i = 1; i <= n; i++) {
            //前缀和 s=sum[i]，d满足的值
            int s = sum[i];
            if (map.containsKey(s)) {
                //前缀和存在，直接取值即可，最长子数组的长度
                ans = Math.max(ans, i - map.get(s));
            }
            if (!map.containsKey(s)) {
                //「哈希表」来记录「某个前缀和出现的最小下标」是多少
                map.put(s, i);

            }
        }
        return ans;
    }
}
