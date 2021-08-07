package offer;

/**
 * @Author tangmf
 * @Date 2021/7/31 11:17 上午
 * @Description Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class Offer11 {
    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 1, 2};
        System.out.println(new Offer11().minArray(numbers));
    }

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;//基准值
            if (numbers[mid] < numbers[right]) {
                //numbers[mid]是最小值右侧的元素
                //mid 的右边一定不是最小数字，mid 有可能是，下一轮搜索区间是 [left, mid]
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                //numbers[mid]是最小值左侧的元素
                //[3,4,5,1,2] mid以及mid左边一定不说最小数字，下一轮搜索区间[mid+1,right]
                left = mid + 1;
            } else {
                //不能确定numbers[mid] 究竟在最小值的左侧还是右侧 numbers[mid]=numbers[high]
                // 只能把 right 排除掉，下一轮搜索区间是 [left, right - 1]
                right = right - 1;
            }
        }
        return numbers[left];
    }
}
