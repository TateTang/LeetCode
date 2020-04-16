package One_question_per_day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2020/4/16 15:59
 * @Description 给出一个区间的集合，请合并所有重叠的区间。
 *
 *              示例 1:
 *
 *              输入: [[1,3],[2,6],[8,10],[15,18]] 输出: [[1,6],[8,10],[15,18]] 解释:
 *              区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]. 示例 2:
 *
 *              输入: [[1,4],[4,5]] 输出: [[1,5]] 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class T16 {
	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		System.out.println(Arrays.deepToString(merge(intervals)));
	}

	private static int[][] merge(int[][] intervals) {
        List<Integer> list = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			for (int j = 0; j < intervals[i].length; j++) {
				// System.out.println(intervals[i][j]);
				list.add(intervals[i][j]);
			}
		}
        for (Integer integer : list) {
            System.out.println(integer);
        }
		return null;
	}
}
