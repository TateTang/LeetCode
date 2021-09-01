package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2021/8/23 5:50 下午
 * @Description 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * 限制：
 * 1 <= target <= 10^5
 */
public class Offer57II {
    public static void main(String[] args) {
        int target = 9;
        System.out.println(Arrays.deepToString(new Offer57II().findContinuousSequence(target)));
    }

    public int[][] findContinuousSequence(int target) {
        /*
        sum表示l,r 区间内的和，一共有三种情况
        1、 sum < target 说明指针r 可以继续向右扩张使得sum增大，此时r+1
        2、sum > target，说明l为起点不存在一个r 使得sum = target，此时需要枚举下一个节点，也就是l指针左移动，l+1
        3、sum = target 找到合法解，[l，r] 需要将[l,r]区间内的序列放进答案数组，我们知道以l为起点的合法解最多只有一个
        所以需要枚举下一个起点，指针l向右移动，l+1
        4、终止条件l >=r时候，指针r移动到了[target/2] +1的位置，导致l<r时候区间和始终大于target
         */
        List<int[]> vec = new ArrayList<>();
        for (int l = 1, r = 2; l < r; ) {
            int sum = (l + r) * (r - l + 1) / 2;//计算[l,r]区间内的和
            if (sum == target) {
                int[] res = new int[r - l + 1];//定义数组大小
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
            } else if (sum < target) {
                r++;//可以继续扩展
            } else {
                l++;//枚举下一个节点
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }
}
