package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author tangmf
 * @Date 2021/8/17 9:56 上午
 * @Description 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 */
public class Offer39 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(new Offer39().majorityElement1(nums));
    }

    public int majorityElement(int[] nums) {
        /*哈希*/
        Map<Integer, Integer> map = new HashMap<>();//定义一个hash 来存储数组中每个数字出现的次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);//直接统计次数
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        System.out.println(map);
        return 0;
    }

    public int majorityElement1(int[] nums) {
        /*直接排序，然后操作*/
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
