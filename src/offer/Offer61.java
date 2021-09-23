package offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author tangmf
 * @Date 2021/9/10 3:35 下午
 * @Description 剑指 Offer 61. 扑克牌中的顺子
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A不能视为14。
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class Offer61 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new Offer61().isStraight1(nums));
    }

    public boolean isStraight(int[] nums) {
        /*
        五张牌为顺子的充分条件如下：
        - 除了大小王之外，所有的牌都没有重复
        - 五张牌中最大的为max，最小的为min，需要满足 max-min<5
        因此，转换问题为5张牌是否同时满足上面两个条件
        证明所有牌没有重复，
        0个大小王 ABCDE
        1个大小王 0ABCD
        2个大小王 00ABC
        由于大小王可以代替任何的牌，三种情况的判断保持一致
        最大-最小<5 可构成顺子
        最大-最小>=5 不可构成顺子

        集合Set+遍历解法
        - 遍历五张牌，大小王直接跳过
        - 判断重复，利用set遍历判断重复
        - 获得最大和最小的牌
         */
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) continue;//跳过大小王，跳出当前循环
            max = Math.max(max, nums[i]);//最大牌
            min = Math.min(min, nums[i]);//最小牌
            if (set.contains(nums[i])) return false;//有重复，直接返回即可
            set.add(nums[i]);
        }
        return max - min < 5;
    }

    public boolean isStraight1(int[] nums) {
        /*
         * 排序+遍历
         * -执行排序，
         * -判断重复排序数组中的相同元素位置相邻，因此可通过遍历数组，判断 nums[i]=nums[i+1] 是否成立来判重。
         * -获取最大最小牌，最大nums[4]，最小nums[joker]，joker大小王的数量
         */
        Arrays.sort(nums);
        int joker = 0;//大小王数量
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) joker++;
            else if (nums[i] == nums[i + 1]) return false;
        }
        return nums[4] - nums[joker] < 5;// 最大牌 - 最小牌 < 5 则可构成顺子
    }
}
