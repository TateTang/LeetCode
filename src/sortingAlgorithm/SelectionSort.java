package sortingAlgorithm;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2022/2/13 10:24 上午
 * @Description 排序算法：选择排序
 * 平均时间复杂度 最好情況 最坏情况 空间复杂度
 * O(n^2)       O(n^2)    O(n^2)   O(1)
 * 选择排序是一种简单直观的排序算法，无论什么数据进去都是 O(n²) 的时间复杂度。
 * 所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 9, 1};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] sourceArray) {
        /*
        1、首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
        2、再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
        3、重复第二步，直到所有元素均排序完毕。
        [6, 3, 8, 2, 9, 1] --> [1, 3, 8, 2, 9, 6] --> [1, 2, 8, 3, 9, 6]
         */
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;//定义最小的元素的下标
            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
                // 将找到的最小值和i位置所在的值进行交换
                if (i != min) {
                    int tmp = arr[i];
                    arr[i] = arr[min];
                    arr[min] = tmp;
                }
            }
        }
        return arr;
    }
}
