package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2021/11/9 10:13 上午 剑指 Offer 29. 顺时针打印矩阵
 * @Description 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Offer29 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Arrays.toString(new Offer29().spiralOrder(matrix)));
    }

    public int[] spiralOrder(int[][] matrix) {
        /*
         * 1.空值处理： 当 matrix 为空时，直接返回空列表 [] 即可。
         * 2.初始化： 矩阵 左、右、上、下 四个边界 l , r , t , b ，用于打印的结果列表 res 。
         * 3.循环打印： “从左向右、从上向下、从右向左、从下向上” 四个方向循环，每个方向打印中做以下三件事 （各方向的具体信息见下表） ；
         * 1.根据边界打印，即将元素按顺序添加至列表 res 尾部；
         * 2.边界向内收缩（代表已被打印）
         * 3. 判断是否打印完毕（边界是否相遇），若打印完毕则跳出。
         * 4.返回值： 返回 res 即可。
         *
         * @param matrix 打印方向     根据边界打印          边界收缩      是否打印完毕
         *               从左往右     左边界l,右边界r       上边界+1       是否t>b
         *               从上往下     上边界t,下边界b       右边界-1       是否l>r
         *               从右往左     右边界r，左边界l       下边界-1       是否t>b
         *               从下往上     下边界b，上边界t       左边界+1       是否l>r
         */
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int top = 0;//上边界
        int right = matrix[0].length - 1;//右边界：列长度-1，3
        int bottom = matrix.length - 1;//下边界：行长度-1，2
        int left = 0;//左边界
        while (true) {
            //从左向右，边界:left，right 边界收缩上边界+1
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);//取得的第一行的值，top固定，行固定，i递增
            }
            top++;
            if (top > bottom) break;
            //从上往下，边界:top,bottom 边界收缩右边界-1
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);//获得最后一列的值，i递增，right固定，列固定
            }
            right--;
            if (left > right) break;

            //从右往左，边界：right,left，边界收缩，下边界-1
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);//获得最后一行的值，bottom固定，行固定，i递减
            }
            bottom--;
            if (top > bottom) break;

            //从下往上，边界：bottom top，边界收缩，左边界+1
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);//获得第一列的值，i递减，left固定
            }
            left++;
            if (left > right) break;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
