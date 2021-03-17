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
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] matrix = {{2, 3}};
        //System.out.println(spiralOrder1(matrix));
        //System.out.println(spiralOrder(matrix));
        System.out.println(spiralOrder1(matrix));
    }

    /**
     * 外部向内部逐层打印矩阵，最外面一圈打印完成，里面依旧是一个矩阵
     * 统计矩阵的层数，每一层最多两行或者两列，最少一列或者一行，只有一行或者一列 也算一个矩阵
     *
     * @param matrix 数组
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int m = matrix.length;//行
        int n = matrix[0].length;//列
        int count = (Math.min(m, n) + 1) / 2;//层数
        System.out.println("行：" + m);
        System.out.println("列：" + n);
        System.out.println("层数：" + count);
        int i = 0;//计数

        while (i < count) {
            //第一行，第一个，从左到右，j 从i开始，jd<列数-i；到达第一行最后一列的值
            for (int j = i; j < n - i; j++) {
                list.add(matrix[i][j]);
            }
            //最后一列，第二个 从上往下，j 从i+1开始，也就是跳过第一行最后一列一个值，j < 行数-i，到达最后一行最后一列的值
            for (int j = i + 1; j < m - i; j++) {
                list.add(matrix[j][(n - 1) - i]);//n-1-i边界值
            }
            //最后一行，从右往左，j 从 行数-1 - (i+1) 开始，跳过最后一行最后一列的值，获取到最后一行的列下标，列下标递减，
            // j >=i m-1表示数组行的边界值， -i 表示遍历最外层向最里层递推，层数变大，边界值变小，达到最后一行第一列
            for (int j = (n - 1) - (i + 1); j >= i && (m - 1 - i) != i; j--) {
                list.add(matrix[(m - 1) - i][j]);//m-1-i边界值
            }
            //第一列，从下往上，j 从列数-1 -(i+1)开始，跳过最后一行第一列的值，获取到第一列的下标，列下标递减
            //j>=i+1 跳过第一行 第一个值需要， n -1 表示数组列的边界值，-i 表示遍历最外层向最里层递推，层数变大，
            // 边界值变小，达到最后即可，然后开始循环下面一层
            for (int j = (m - 1) - (i + 1); j >= i + 1 && (n - 1 - i) != i; j--) {
                list.add(matrix[j][i]);
            }
            i++;//层数依次遍历
        }
        return list;
    }

    /**
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
    public static List<Integer> spiralOrder1(int[][] matrix) {
        //
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int top = 0;//上边界
        int right = matrix[0].length - 1;//右边界：列长度-1
        int bottom = matrix.length - 1;//下边界：行长度-1
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
                list.add(matrix[i][right]);//取得最后一列的值，i递增，right固定，列固定
            }
            right--;
            //从右往左，边界:right left，边界收缩 下边界-1
            if (left > right) break;
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);//取得最后一行的值，bottom固定，行固定，i递减
            }
            bottom--;
            if (top > bottom) break;
            //从下往上，边界：bottom，top 边界收缩，做边界+1
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);//取得第一列的值，i递减，left固定:列固定
            }
            left++;
            if (left > right) break;
        }
        return list;
    }
}
