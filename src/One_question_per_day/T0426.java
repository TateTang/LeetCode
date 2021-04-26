package One_question_per_day;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2021/4/26 11:20 上午
 * @Description 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。
 * 每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * 示例 1：
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 */
public class T0426 {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 1, 1};
        int D = 4;
        System.out.println(new T0426().shipWithinDays1(weights, D));
    }

    public int shipWithinDays(int[] weights, int D) {
        /*
        官方题解：二分查找转换为判定问题
        思路与算法：
        1、假设当船的运载能力为x的时候，可以在D天内运送完所有的包裹，那么只要运载能力大于x，同样可以在D天内送完所有包裹
        我们只需要使用运载能力为x时的运送方法即可
        2、结论：存在一个运载能力「下限」Xanx ，当x>=Xanx时候，可以在 D 天内运送所有包裹，当x<Xanx时候，
        无法在D天内运送完所有包裹。Xanx即为需要求出的答案，可以用二分查找方法找出Xans的值
        3、二分查找中，实际上需要解决一个判定问题：给定船的运载能力为x，是否可以在D天内运送完所有包裹？判定问题通过贪心解决
        4、因为必须按照数组weights中包括的顺序进行运送，因此我们从数组weights的首元素开始遍历，将连续的包裹都安排在
        同一天运送。当这批包裹的重量大于运载能力x的时候，需要将最后一个包裹拿出来，安排到新的一天，并且继续往下遍历，
        当遍历完整个数组后，就得到了最少需要运送的天数
        5、将「最少需要运送的天数」与D进行比较，就可以解决这个判定问题。当其小于等于D时，忽略二分的
        右半部分区间；当其大于D时，忽略二分的左半区间部分
        6、细节：二分查找的初始左右边界如何计算
         - 对于左边界而言，由于不能「拆分」一个包裹，因此船的运载能力不能小于所有包裹中最重的那个重量
         即左边界为数组weight中元素的最大值
         - 对于右边界而言，船的运载能力不会大于所有包裹的重量之和，即右边界为数组weights中元素的和
         - 从上述左右边界进行二分查找。就可以保证找到最终的答案
         */
        //确定二分查找的左右边界：左边界：weights中元素中的最大值。右边界：所有包裹之和
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) >> 1;//等价于(left+right)/2
            int need = 1;//需要运送的天数
            int currWeight = 0;//当前这一天已经运送的包裹重量之和
            for (int weight : weights) {
                currWeight += weight;
                if (currWeight + weight > mid) {
                    need++;//累计包裹数量>mid，需要运送的天数加1
                    currWeight = weight;//当前这一天已经运送的包裹重量之和
                }
            }
            if (need <= D) {
                right = mid;//忽略右半部分
            } else {
                left = mid + 1;//忽略左半部分
            }
        }
        return left;
    }

    public int shipWithinDays1(int[] weights, int D) {
        /*
         * 另外解法：
         * 1、首先，可以明确最低运载能力必须要不小于数组中的最大值（必须要满足一天至少运一个，运载能力至少
         * 要比每个包裹的重要都要大才行，不然就会出现有包裹一直云不走），不大于数组的总和(一天全部运走),
         * 边界区间：[max(weight),sum(weight)]
         * 2、区间[max(weights), sum(weights)]内满足函数possible的值都可以作为最低运载能力的候选值，
         * 但是我们求满足条件中的最小值，这里我们采用二分法查找
         */
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) >> 1; //取中间值等价于 (left+right)/2
            if (possible(weights, D, mid)) {
                right = mid;//如果mid满足possible，代表最低运载能力为mid的时候能在D天内送达，逼近右指针，忽略右边部分
            } else {
                left = mid + 1;//否则，逼近左指针，忽略左边部分
            }
        }
        return left;
    }

    /**
     * 判断最低运载能力为H的时候能否在D天内送达
     *
     * @param weights 重量数组
     * @param D       天数
     * @param H       最低运载能力
     */
    public boolean possible(int[] weights, int D, int H) {
        int count = 1;//天数计数，初始化为1
        int currWeight = 0;//每天的包裹总数
        for (int weight : weights) {
            currWeight += weight;//累计包裹总量
            //如果累计包裹总量singleWeight > H，天数+1，当前这一天已经运送的包裹重量之和重置为当前的重量重新计算
            if (currWeight > H) {
                count++;
                currWeight = weight;
            }
            if (count > D) {
                return false;//如果当前累计的天数count > D，说明当前H不满足条件，返回false
            }
        }
        return true;//说明当前H 最低运载能力满足，返回true
    }
}
