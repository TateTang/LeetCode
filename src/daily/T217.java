package daily;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author tangmf
 * @Date 2021/4/17 9:27 上午
 * @Description 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class T217 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate1(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();//元素不重复
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;//直接判断set中的元素个数是否和nums中的个数是否相等
    }

    public static boolean containsDuplicate1(int[] nums) {
        /*
        对于数组中每个元素，我们将它插入到哈希表中。
        如果插入一个元素时发现该元素已经存在于哈希表中，则说明存在重复的元素。
         */
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            //set.add set中不存在，成功添加返回true。set中存在，不能添加，返回false
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }
}
