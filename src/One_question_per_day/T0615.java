package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/6/15 11:29 上午
 * @Description 852. 山脉数组的峰顶索引
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * 示例 1：
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * 示例 3：
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * 示例 4：
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * 示例 5：
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 */
public class T0615 {
    public static void main(String[] args) {
        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        System.out.println(new T0615().peakIndexInMountainArray3(arr));
    }

    public int peakIndexInMountainArray(int[] arr) {
        /*
        线性扫描解法：arr[i]是临界点，arr[i]>arr[i]+1则代表到达峰顶
        从左往右扫描直到山的高度不再增长为止，停止增长就是峰顶
        时间复杂度：O(N)，其中 N 是 山峰 的长度。
         */
        int i = 0;
        while (arr[i] < arr[i + 1]) {
            i++;
        }
        return i;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        /*
        二分查找法：
        1、将山脉数组中所有满足 arr[i]<arr[i+1]的i点标记为true，不满足标记为false。
        2、则可以将一个山脉数组标记为[true,true,false,false]，如[3,4,5,1]标记为[true,true,false,fasle]
        3、使用二分查找，找出满足arr[i]<arr[i+1]的最大i
        时间复杂度：O(logN)
        空间复杂度：O(1)
         */
        int min = 0, max = arr.length - 1;
        while (min < max) {
            int mid = (min + max) / 2;
            if (arr[mid] < arr[mid + 1]) {
                // 找出 arr[i]>arr[i+1]的最大i
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    public int peakIndexInMountainArray3(int[] arr) {
        /*
        二分查找法：
        往常使用「二分」进行查找，需要确保序列本身满足「二段性」：当选定一个端点（基准值）后，结合
        「一段满足 & 另一段不满足」特性实现「折半」的查找效果
        1、本题求的是峰顶索引值，如果选定数组头部或者尾部元素，无法根据大小关系将数组分成两段
        2、利用题目如下性质：【由于arr数组各不相同，因此峰顶元素左侧必然满足严格单调递增，峰顶元素右侧必然不满足】
        3、因此，【以峰顶元素为分割点的arr数组，根据与前一元素/后一元素的大小关系，具有二段性】
        - 峰顶元素左侧满足 arr[i-1]<arr[i]性质，右侧不满足
        - 峰顶元素右侧满足 arr[i]>arr[i+1]性质，左侧不满足
        时间复杂度：O(logN)
        空间复杂度：O(1)
         */
        // 根据 arr[i] > arr[i+1] 在 [0,n-2] 范围内找值
        // 峰顶元素为符合条件的最靠近中心的元素
        int left = 0, right = arr.length - 2;//rigth-1 代表长度，再除去最后一个小于峰顶元素的值
        while (left < right) {
            int mid = left + right >> 1;//等价于 (left+right)/2
            if (arr[mid] > arr[mid + 1]) {
                //说明峰顶元素右侧满足，左侧不满足，不需要找右边了，直接再找左边即可 right = mid
                right = mid;
            } else {
                //说明峰顶元素左侧满足，右侧不满足，不需要找左边了，直接再找右边即可，left = mid +1
                left = mid + 1;
            }
        }
        return right;

    }
}
