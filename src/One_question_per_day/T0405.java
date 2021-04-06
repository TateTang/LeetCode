package One_question_per_day;

import java.util.*;

/**
 * @Author tangmf
 * @Date 2021/4/6 10:17 上午
 * @Description 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * <p>
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 */
public class T0405 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;//nums1元素个数
        int[] nums2 = {2, 5, 6};
        int n = 3;//nums2元素个数
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m + n];//定义一个新的数组
        int i = 0, j = 0;//定义两个指针，i，j
        int cur;//定义一个变量接收当前值，直接放入到sorted数组中去
        while (i < m || j < n) {
            if (i == m) {
                cur = nums2[j++];//nums1元素个数为0；当前元素就是nums2中的元素
            } else if (j == n) {
                cur = nums1[i++];//nums2元素个数为0；当前元素就是nums1中的元素
            } else if (nums1[i] < nums2[j]) {
                cur = nums1[i++];//nums1的元素小于nums2的元素，当前元素为nums1中的元素
            } else {
                cur = nums2[j++];//nums1的元素大于nums2的元素，当前元素为nums2中的元素
            }
            sorted[i + j - 1] = cur;//当前元素赋值给到sorted数组
        }
        for (int k = 0; k != m + n; ++k) {
            nums1[k] = sorted[k];//nums数组重新赋值为sorted数组
        }
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
