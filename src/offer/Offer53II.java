package offer;

/**
 * @Author tangmf
 * @Date 2021/9/7 9:59 上午
 * @Description 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class Offer53II {
    public static void main(String[] args) {
        int[] nums = {0, 1, 3};
        System.out.println(new Offer53II().missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        /*
        二分查找法
        1、初始化，左边界0，右边界r=nums.length-1,代表区间[l,r]
        2、循环二分，当 i≤j 时循环 （即当闭区间 [i，j为空时跳出） ；
        - 计算mid = i+j /2
        - nums[mid] = mid，则右子数组的首位元素一定在闭区间[m+1,r]中，l=m+1;
        - nums[mid] != mid，则左子数组的末位元素一定在闭区间[l,m-1]中，r=m-1;
         */
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] == mid) {
                l = mid + 1;//右子数组的首位元素一定在闭区间[m+1,r]中，l=m+1;
            } else {
                r = mid - 1;//左子数组的末位元素一定在闭区间[l,m-1]中，r=m-1;
            }
        }
        return l;
    }

    public int missingNumber1(int[] nums) {
        /*
        1、循环遍历做法
        2、只要比较数组下标和该下标对应的值即可，
        3、再排除缺失0和缺失最后一项两个特殊情况。
         */
        if (nums[0] == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }
}
