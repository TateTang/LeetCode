package offer;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2021/8/13 5:53 下午
 * @Description 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 */
public class Offer40 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int k = 2;
        System.out.println(Arrays.toString(new Offer40().getLeastNumbers(arr, k)));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr); //直接进行排序
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, res.length);//筛选前k个数字即可
        return res;
    }
}
