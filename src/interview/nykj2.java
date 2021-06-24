package interview;

import java.util.ArrayList;

/**
 * @Author tangmf
 * @Date 2021/6/23 10:11 下午
 * @Description
 */
public class nykj2 {
    public static void main(String[] args) {
        int[] a = {-10, 6, 7};
        int[] b = {-15, 1, 3, 4, 5, 6, 7, 8, 9, 10, 15};
        ArrayList<Integer> mix = new nykj2().fun1(a, b);
        for (int i : mix) {
            System.out.print(i + " ");
        }
    }

    public int[] fun(int[] a, int[] b) {
        for (int numa : a) {
            for (int numb : b) {
                if (numa == numb) {
                    System.out.print(numa);
                }
            }
        }
        return null;
    }

    public ArrayList<Integer> fun1(int[] a, int[] b) {
        /*
        从a b的头开始
        若当前遍历的位置a[i]==b[j]，则次=此数为两个数组的交集，记录下来，并且继续向后遍历a1,b1.
        若a[i] > b[j] ,则继续向后遍历b
        若a[i] < b[j], 则继续向后遍历a,直到有一个数组结束遍历即停止。
         */
        ArrayList<Integer> mix = new ArrayList<>();
        int aLen = a.length, bLen = b.length;
        int i = 0, j = 0;
        while (i < aLen && j < bLen) {
            if (a[i] == b[j]) {
                mix.add(a[i]);//说明存在交集 ,记录，a b 向后遍历
                i++;
                j++;
            } else if (a[i] > b[j]) {
                //说明a中元素大于b b 向后遍历
                j++;
            } else {
                //说明a中元素小于b a向后遍历
                i++;
            }
        }
        return mix;
    }
}
