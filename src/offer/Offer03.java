package offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author tangmf
 * @Date 2021/7/28 10:32 上午
 * @Description 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class Offer03 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(new Offer03().findRepeatNumber1(nums));
    }

    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();//定义一个hash 来存储数组中每个数字出现的次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);//直接统计次数
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public int findRepeatNumber1(int[] nums) {
        /*
         * 利用set
         */
        Set<Integer> set = new HashSet<>();
        int count = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                count = num;
                break;
            }
        }
        return count;
    }
}
