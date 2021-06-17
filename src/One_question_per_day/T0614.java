package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/6/17 9:52 上午
 * @Description * Forward declaration of guess API.
 * * @param  num   your guess
 * * @return 	     -1 if num is lower than the guess number
 * *			      1 if num is higher than the guess number
 * *               otherwise return 0
 * * int guess(int num);
 * 374. 猜数字大小
 * 猜数字游戏的规则如下：
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，
 * 返回值一共有 3 种可能的情况（-1，1 或 0）：
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 * 示例 1：
 * 输入：n = 10, pick = 6
 * 输出：6
 * 示例 2：
 * 输入：n = 1, pick = 1
 * 输出：1
 * 示例 3：
 * 输入：n = 2, pick = 1
 * 输出：1
 * 示例 4：
 * 输入：n = 2, pick = 2
 * 输出：2
 */
public class T0614 extends GuessGame {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(new T0614().guessNumber(10));
    }

    public int guessNumber(int n) {
        /*
        二分查找
        1、记选出的数字为pick，猜测的数字为x
        2、根据题目秒杀，guess(x)<=0，-1:pick<x; 0:pick=x；说明pick<=x，否则x<pick，
        可利用二分查找来求出答案pick
        3、二分时，记当前区间为[left,right]，初始化left=1,right=n；中间元素mid
        4、如果有guess(mid)<=0 则说明 pick[left,mid]，否则pick[mid+1,right]
        5、当区间左右端点相同的时候，说明找到了答案，推出循环
         */
        int left = 1, right = n;
        //循环直至区间左右端点相同
        while (left < right) {
            int mid = left + (right - left) / 2;//防止计算时候溢出
            if (guess(mid) <= 0) {
                right = mid;//答案区间[left,mid]
            } else {
                left = mid + 1;//答案区间[mid+1,right]中
            }
        }
        //此时有left == right，区间为一个点，即为答案
        return left;
    }
}
