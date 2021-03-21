package One_question_per_day;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2021/3/21 4:29 下午
 * @Description 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * <p>
 * [[1,2,3,4],[5,0,7,8],[0,10,11,12],[13,14,15,0]]
 * [[0,0,3,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]
 */
public class T0321 {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes1(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes1(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
        int[][] matrix3 = {{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        setZeroes1(matrix3);
        System.out.println(Arrays.deepToString(matrix3));
        int[][] matrix4 = {{1, 0, 3}};
        setZeroes1(matrix4);
        System.out.println(Arrays.deepToString(matrix4));
    }

    public static void setZeroes(int[][] matrix) {
        //使用每一行和每一列的单元格作为标志。此标志将确定当前的单元格是否已设置为零。
        int m = matrix.length;//行长度
        int n = matrix[0].length;//列长度
        boolean[][] booleans = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    //当前行，和列的都应该为ture
                    for (int o = 0; o < m; o++) {
                        booleans[o][j] = true;//当前列，i递增，j固定
                    }
                    for (int k = 0; k < n; k++) {
                        booleans[i][k] = true;//当前行，i固定，列递增
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (booleans[i][j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void setZeroes1(int[][] matrix) {
        //一维数组标识。
        int m = matrix.length;//行长度
        int n = matrix[0].length;//列长度
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    //当前行，和列的都应该为ture
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
