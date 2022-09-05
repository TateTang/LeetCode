package newoffer.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangmf
 * @date 2022年09月05日 10:01:​12
 * 剑指 Offer II 004. 只出现一次的数字
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 示例 1：
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,1,0,1,100]
 * 输出：100
 */
public class T004 {
    public static void main(String[] args) {
        //int[] nums = {2, 2, 3, 2};
        int[] nums = {0, 1, 0, 1, 0, 1, 100};
        System.out.println(new T004().singleNumber1(nums));
    }

    public int singleNumber(int[] nums) {
        // 利用hash 解决，map 存储出现的次数；时间复杂度：O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 找到出现一次的数字，直接返回接口
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public int singleNumber1(int[] nums) {
        /*
         线性时间复杂度，不实用额外空间来实现
         异或，二进制运算，同0 不同为1
         规律：
         1.任何数和0异或，仍为本身：a⊕0 = a
         2.任何数和本身异或，为0：a⊕a = 0
         3.异或运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
         [只出现一次的元素] 称之为[答案]，一次计算答案的每一个二进制是0还是1
         1.具体地，考虑答案的第 i 个二进制位（i 从 0 开始编号），它可能为 0 或 1。
         2.对于数组中非答案的元素，每一个元素都出现了 3 次，对应着第 i 个二进制位的 3 个 0 或 3 个 1，
         无论是哪一种情况，它们的和都是 3 的倍数（即和为 0 或 3）。因此：
        答案的第 i 个二进制位就是数组中所有元素的第 i 个二进制位之和除以 3 的余数。
         */
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                //i 当前统计的位是否有1，有的话就赋给结果
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
