package hw.jsms.lx;

import java.util.Scanner;

/**
 * @author tangmf
 * @date 2022年10月19日 10:19:​44
 * 有一个数字游戏叫做2048，此游戏的规则为，两个相同的数字能进行相加。
 * 例如:两个2可以相加，则相加后4的个数加一，2的个数会减二。
 * 现在有一串数字，为目前已知的数字的数量。问至少还需要几次相加，才能获得2048 (题目保证能够相加得到2048)。
 * 输入描述:
 * 第一行为样例数T，代表后面会跟随工组测试数据。
 * 每组测试数据输入10个数，分别代表
 * 2,4,8,16,32,64,128,256,512,1024的个数。
 * 每种数字的个数不超过1024。
 * 输出描述:
 * 对于每组数据， 输出一个数， 表示需要得到2048最少需要相加的次数。
 * 输入
 * 2
 * 2 1 1 1 1 1 1 1 1 1
 * 1 1 1 1 1 1 1 1 1 2
 * 输出
 * 10
 * 1
 */
public class T04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int times = scan.nextInt();
        int[][] arr = new int[times][10];
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < times; i++) {
            System.out.println(leastCount(arr[i]));
        }
    }

    // 寻找一维数组的最少的合成次数
    public static int leastCount(int[] arr) {
        /*
        1、一行10个数，只要最后一个大于等于2便能凑出2048
        2、要想最少合成次数，每次从下标为8这个元素开始向左遍历，遇到大于等于2的数值，则该数值减去2，该数值的右边那个数加1，
        同时记录合成次数的变量加1，然后重复这个步骤直到第10个数等于2。
         */
        //count：计数，index：下标位置
        int count = 0, index;
        while (arr[9] < 2) {
            //从下标为8这个元素开始遍历
            index = 8;
            //从右边找到第一个大于等于2的数字
            while (index >= 0 && arr[index] < 2) {
                index--;
            }
            //当前数值-2，当前数值右边数值+1
            arr[index] -= 2;
            arr[index + 1] += 1;
            count++;
        }
        return ++count;
    }
}
