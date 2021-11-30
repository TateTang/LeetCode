package offer;

import java.util.*;

/**
 * @Author tangmf
 * @Date 2021/11/30 3:50 下午
 * @Description 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * 示例 1：
 * 输入：[4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 */
public class Offer56I {
    public static void main(String[] args) {
        int[] nums = {1, 2, 10, 4, 1, 4, 3, 3};
        System.out.println(Arrays.toString(new Offer56I().singleNumbers(nums)));
    }

    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();//定义一个hash 来存储数组中每个数字出现的次数
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);//直接统计次数
        }
        int[] res = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res[i] = entry.getKey();
                i++;
            }
        }
        return res;
    }
}
