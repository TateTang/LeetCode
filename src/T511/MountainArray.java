package T511;

/**
 * @Author tangmf
 * @Date 2020/5/11 14:04
 * @Description 我们把符合下列属性的数组 A 称作山脉：
 *
 *              A.length >= 3 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1]
 *              < A[i] > A[i+1] > ... > A[A.length - 1] 给定一个确定为山脉的数组，返回任何满足 A[0]
 *              < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的
 *              i 的值。
 *
 *               
 *
 *              示例 1：
 *
 *              输入：[0,1,0] 输出：1
 */
public class MountainArray {

	public static void main(String[] args) {
		int[] A = { 0, 1, 0 };
		System.out.println(peakIndexInMountainArray(A));
	}

	/*
	 * public static int peakIndexInMountainArray(int[] A) {
	 *//*
		 * 1.线性扫描 从左往右扫描直到山的高度不再增长为止，停止增长就是峰顶 时间复杂度：O(N)O(N)，其中 NN 是 A 的长度。
		 *
		 * 空间复杂度：O(1)O(1)
		 *//*
			 * int i =0; while (A[i]<A[i+1]) i++; return i; }
			 */
	public static int peakIndexInMountainArray(int[] A) {
		/*
		 * 1.二分查找 将山脉数组中所有满足 A[i] < A[i+1] 的 i 点标记为 True，不满足的点标记为
		 * False。则一个山脉数组可以标记为：[True, True, True, ..., True, False, False, ...,
		 * False]。例如山脉数组 [1, 2, 3, 4, 1] 可以标记为 True, True, True, False。
		 * 在山脉数组上使用二分查找，找出满足 A[i] < A[i+1] 的最大 i 时间复杂度：O(\log N)O(logN)，其中 NN 是
		 * A 的长度。 空间复杂度：O(1)O(1)。
		 */
		int min = 0, max = A.length - 1;
		while (min < max) {
			int mid = (min + max) / 2;
			if (A[mid] < A[mid + 1]) {// 找出 A[i]<A[i+1]的最大i
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		return min;
	}
}
