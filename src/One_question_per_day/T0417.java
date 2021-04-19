package One_question_per_day;

import java.util.TreeSet;

/**
 * @Author tangmf
 * @Date 2021/4/19 10:23 上午
 * @Description 220. 存在重复元素 III
 * 给你一个整数数组 nums 和两个整数 k 和 t 。
 * 请你判断是否存在 两个不同下标 i 和 j，
 * 使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * 如果存在则返回 true，不存在返回 false。
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 */
public class T0417 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        int t = 0;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        /*
            滑动窗口&二分
            对于任意一个位置i(假设值为u)，希望在下标范围为[max(0,i-k):i]内找范围[u-t,u+t]的数
            朴素想法：每次遍历到任意位置i的时候，往后检查k个元素，时间复杂度o(nk)超时
            优化【检查后面k个元素】过程
            希望使用一个[有序集合]维护长度为k的滑动窗口内的数，该数据结构最好支持高效[查询]+[插入/删除]
            - 查询：能够在[有序集合]中应用[二分查找]，快速找到[小于等于u的最大值]和[大于等于u的最小值]
            (有序集合 中最接近u的数)
            - 插入/删除：在往[有序集合]添加/删除元素时，能够在低于线性复杂度内完成(维持有序特性)

            需要找符合abs(nums[i] - nums[j]) <= t的两个值，nums[i]与nums[j]不相等，hashmap无法支持
            好的[范围查询]
            如AVL树(平衡二叉树)，导致每次的插入/删除辉出发AVL的平衡调整，一次平衡调整会伴随若干次的旋转
            红黑树：将平衡调整引发的旋转次数从[若干次]限制到[最多三次]
            因此选用 红黑树，也就是TreeSet。查找和插入具有折半的效率
            - 滑动窗口，维护TreeSet中的元素：k个
            - 对于任意位置，找到滑动窗口内离nums[i]最近的一大一小两个值
            - nums[i]==u
            - l：滑动窗口中小于等于u的最大值
            - r：滑动窗口中大于等于u的最小值
            注意：nums中的数较大，使用long存储
         */
        int len = nums.length;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            Long u = (long) nums[i];//当前数
            Long l = treeSet.floor(u);//找到小于等于u的最大值
            Long r = treeSet.ceiling(u);//找到大于等于u的最小值
            if (l != null && u - l <= t) return true;
            if (r != null && r - u <= t) return true;
            //将当前数加入到treeset中，移除下标范围不在[max(0,i-k),i]的数（维持滑动窗口的大小为k）
            treeSet.add(u);
            if (i >= k) treeSet.remove((long) nums[i - k]);
        }
        return false;
    }
}
