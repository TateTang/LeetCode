package daily;

/**
 * @Author tangmf
 * @Date 2021/4/10 10:52 上午
 * @Description 264. 丑数 II
 * 编写一个程序，找出第 n 个丑数。
 * <p>
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
public class T264 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }

    public static int nthUglyNumber(int n) {
        /*
            1、这里需要找到第n个丑数，代表我们的思维需要从下往上，从小的数值向大寻找
            2、设置三个指针，i2,i3,i5 三个指针对应的作用对应这2，3，5的倍数
            3、丑数就是质因数只包含2，3，5的正整数，所以从小开始，一个一个丑数放进结果数组中，直到要找的个数为止
         */
        int[] nums = new int[n];//定义数组 存放丑数
        nums[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;//三个指针
        //算出所有丑数，直到所需的第n个位置
        for (int i = 1; i < n; i++) {
            //从小到大，按照丑数的定义收集丑数
            int ugly = Math.min(nums[i2] * 2, Math.min(nums[i3] * 3, nums[i5] * 5));
            nums[i] = ugly;//丑数的结果放进到丑数数组中
            if (nums[i] == nums[i2] * 2) i2++;// 指针移动，从小到大地寻找丑数
            if (nums[i] == nums[i3] * 3) i3++;
            if (nums[i] == nums[i5] * 5) i5++;
        }
        return nums[n-1];//返回第n个丑数
    }
}
