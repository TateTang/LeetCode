package newoffer.offerII;

/**
 * @author tangmf
 * @date 2022年09月08日 09:17:​24
 * 剑指 Offer II 069. 山峰数组的顶部
 * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
 * <p>
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给定由整数组成的山峰数组 arr ，返回任何满足
 * arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
 * 示例 1：
 * 输入：arr = [0,1,0]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：arr = [1,3,5,4,2]
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * <p>
 * 示例 5：
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 */
public class T069 {
    public static void main(String[] args) {
        //int[] arr = {0, 10, 5, 2};
        int[] arr = {3, 5, 3, 2, 0};
        System.out.println(new T069().peakIndexInMountainArray1(arr));
        System.out.println(new T069().peakIndexInMountainArray2(arr));

    }

    public int peakIndexInMountainArray(int[] arr) {
        /*
        线性扫描解法：arr[i]是临界点，arr[i]>arr[i]+1则代表到达峰顶
        从左往右扫描直到山的高度不再增长为止，停止增长就是峰顶
        时间复杂度：O(N)，其中 N 是 山峰 的长度。
         */
        int n = arr.length;
        int ans = -1;
        for (int i = 1; i < n - 1; ++i) {
            if (arr[i] > arr[i + 1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }


    public int peakIndexInMountainArray1(int[] arr) {
         /*
        二分查找法：
        由于 arr 数值各不相同，因此峰顶元素左侧必然满足严格单调递增，峰顶元素右侧必然不满足。
        因此 以峰顶元素为分割点的 arr 数组，根据与 前一元素/后一元素 的大小关系，具有二段性：
        峰顶元素左侧满足 arr[i-1] < arr[i] 性质，右侧不满足
        峰顶元素右侧满足 arr[i] > arr[i+1] 性质，左侧不满足
        记满足题目要求要求下标i 为 ians，可以发现
        i < ians时候， arr[i] < arr[i+1] 恒成立
        i >= ians时候， arr[i] >= arr[i+1] 恒成立
        因此 i an即为「最小的满足arr[i] >arr[i+1]的下标i]，我们可以用二分查找的方法来找出 i ans
        时间复杂度：O(logN)
        空间复杂度：O(1)
         */
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = left + right >> 1;
            if (arr[mid] > arr[mid + 1]) {
                //说明峰顶元素右侧满足，左侧不满足，不需要找右边了，直接再找左边即可 right = mid-1
                ans = mid;
                right = mid - 1;
            } else {
                // 说明峰顶元素左侧满足，右侧不满足，不需要找左边了，直接再找右边即可，left = mid +1
                left = mid + 1;
            }
        }
        return ans;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        /*
        查看中间元素的变化趋势
        如果是递增的,在右边找
        如果是递减的，在左边找
        先增后减，直接返回
         */
        if (arr.length == 3) {
            return 1;
        }
        // 肯定不是 0 和 arr.length - 1，范围是 [1，n-1]
        int low = 1, high = arr.length - 2;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                // 满足条件，返回
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                // 如果是递增的,在右边找
                low = mid + 1;
            } else {
                // 如果是递减的，在左边找
                high = mid - 1;
            }
        }
        return -1;
    }
}
