package sortingAlgorithm;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2022/2/13 10:15 上午
 * @Description 排序算法：冒泡排序
 * 平均时间复杂度 最好情況 最坏情况 空间复杂度
 * O(n^2)       O(n)    O(n^2)   O(1)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 9, 1};
        sort(arr);
        //for (int i : arr) {
        //    System.out.print(i + " ");
        //}
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] sourceArray) {
        /*
        原理：比较两个相邻的元素，将值大的元素交换到右端。
        1、依此比较相邻两个数，小的数放在前面，大的数放在后面
        2、第一趟比较第1，2个数，小前大后；比较第2，3个数，小前大后，直至比较到把其中最大数放到最右端
        3、第一趟之后，最后一个一定最大，比较第二趟，第二趟第一个不参与，把第二大的数放到倒数第二个位置
        4、第二趟之后，倒数第二个数第二大，第三趟最后两个数不参与
        5、依此类推，每一趟比较次数-1
         */
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {//相邻元素两两比较，大的放在后面
                    int temp = arr[j];//元素交换
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

}
