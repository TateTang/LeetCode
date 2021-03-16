package One_question_per_day;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2021/3/16 11:17 上午
 * @Description 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * 我们一个边界接一个边界向里移动。这是最基本的行动。
 * 第一行，最后一列，最后一行，第一列，然后我们向内移动1，然后重复。就这些，这就是我们需要的模拟。
 */
public class T54 {
    public static void main(String[] args) {
        //int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("行长度：" + matrix.length);
        System.out.println("列长度：" + matrix[0].length);
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        //行martxi.length 列长度：matrix[i].length
        List<Integer> list = new ArrayList<>();
        //第一行，最后一列，最后一行，第一列，向内移动列长度减2
        for (int j = 0; j < matrix[0].length; j++) {
            //第一行：i 为0 j 遍历列长度
            list.add(matrix[0][j]);
        }
        for (int k = 1; k < matrix.length; k++) {
            //最后一列，j下标固定为列长度-1 行下标i 递增
            list.add(matrix[k][matrix[0].length - 1]);
        }
        for (int m = matrix[0].length - 2; m >= 0; m--) {
            //最后一行：行下标固定为行长度-1，列长度递减 ，需要剔除前面一个
            list.add(matrix[matrix.length - 1][m]);
        }
        for (int n = matrix.length - 2; n > 0; n--) {
            //第一行：行下标为行长度递减，列下标固定 第0列，不要包含第一个
            list.add(matrix[n][0]);

        }
        for (int p = 1; p < matrix[0].length - 1; p++) {
            //向内移动2
            list.add(matrix[matrix.length - 2][p]);
        }
        return list;
    }
}
