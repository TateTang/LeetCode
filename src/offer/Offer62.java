package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2021/9/14 9:54 上午
 * @Description 剑指 Offer 62. 圆圈中最后剩下的数字
 * 0, 1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 */
public class Offer62 {
    public static void main(String[] args) {
        int n = 5, m = 3;
        System.out.println(new Offer62().lastRemaining(n, m));
    }

    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        return delete(list, m);
    }

    public int delete(List<Integer> list, int m) {
        if (list.size() > 1) {
            return delete(list, m);
        }else {
            return list.get(m);
        }
    }
}
