package hw;

import java.util.Arrays;

/**
 * @author tangmf
 * @date 2022年09月28日 10:06:​44
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class TM01 {
    public static void main(String[] args) {
        //int[] nums1 = {2,3,1,1,4};
        //int[] nums = {3, 2, 1, 0, 4};
        int[] nums1 = {5, 4, 3, 2, 1, 0, 6};
        int[] nums2 = {5, 4, 3, 3, 1, 0, 6};
        int[] nums3 = {5, 4, 3, 4, 1, 0, 0, 0, 6};
        int[] nums4 = {5, 4, 3, 4, 1, 0, 2, 0, 6};
        int[] nums5 = {5, 4, 3, 3, 1, 0, 2, 0, 3, 0, 0, 0};
        int[] nums6 = {5, 4, 3, 3, 1, 0, 2, 0, 3, 0, 0, 0, 0};
        int[] nums7 = {5, 4, 3, 3, 1, 0, 0, 2, 0, 3, 0, 0, 0};
        int[] nums8 = {0, 1};
        System.out.println(Arrays.toString(nums1) + " " + new TM01().canJump(nums1));
        System.out.println(Arrays.toString(nums2) + " " + new TM01().canJump(nums2));
        System.out.println(Arrays.toString(nums3) + " " + new TM01().canJump(nums3));
        System.out.println(Arrays.toString(nums4) + " " + new TM01().canJump(nums4));
        System.out.println(Arrays.toString(nums5) + " " + new TM01().canJump(nums5));
        System.out.println(Arrays.toString(nums6) + " " + new TM01().canJump(nums6));
        System.out.println(Arrays.toString(nums7) + " " + new TM01().canJump(nums7));
        System.out.println(Arrays.toString(nums8) + " " + new TM01().canJump(nums8));
    }

    public boolean canJump(int[] nums) {
        /*
        [2,3,1,1,4]：0 maxNum 2；1：1<=2，可以到达 maxNum=3+1=4,4>=len-1,true
        [3,2,1,0,4]：0 maxNum 3; 1：1<=3，可达，maxNum=2+1=3；2,3：1 0 <=3 可达，maxNum不变；4:4>3 不可达 丢弃
         */
        int len = nums.length;
        //可达最大长度
        int maxNum = 0;
        for (int i = 0; i < len; i++) {
            if (i <= maxNum) {
                //更新
                maxNum = Math.max(maxNum, i + nums[i]);
                // 位置
                if (maxNum >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
