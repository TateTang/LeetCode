package newoffer.offerII;

/**
 * @author tangmf
 * @date 2022年09月13日 11:18:​23
 * 剑指 Offer II 013. 二维子矩阵的和
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * 实现 NumMatrix 类：
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 
 * 返回左上角 (row1, col1) 、右下角 (row2, col2)
 *  的子矩阵的元素总和。
 * 输入:
 * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
 * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
 * 输出:
 * [null, 8, 11, 12]
 * <p>
 * 解释:
 * NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
 */
public class T013 {
    int[][] matrix;
    // 辅助矩阵，左边sum[row+1][col+1] 存入的是matrxi[0][0]到matrix[row][col]矩阵的和
    int[][] sums;

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        T013 obj = new T013(matrix);
        System.out.println(obj.sumRegion1(2, 1, 4, 3));
        System.out.println(obj.sumRegion1(1, 1, 2, 2));
        System.out.println(obj.sumRegion1(1, 2, 2, 4));
    }

    public T013(int[][] matrix) {
        //this.matrix = matrix;
        //m行大小，n 列大小
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            //sums 的列数设为 n+1 的目的是为了方便计算每一行的子数组和，不需要对 col1=0 的情况特殊处理
            sums = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i][j + 1] = sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        /*
         * 时间复杂度 o(n^2)，直接使用暴力法两次循环操作
         */
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public int sumRegion1(int row1, int col1, int row2, int col2) {
        /*
        初始化时对矩阵的每一行计算前缀和，检索时对二维区域中的每一行计算子数组和，然后对每一行的子数组和计算总和。
        1.具体实现方面，创建 m 行 n+1 列的二维数组 sums，
        2.其中 m 和 n 分别是矩阵 matrix 的行数和列数，sums[i] 为 matrix[i] 的前缀和数组。
        3.将 sums 的列数设为 n+1 的目的是为了方便计算每一行的子数组和，不需要对 col1=0 的情况特殊处理。
        时间复杂度：O(mn)
         */
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            //计算指定区域的和，其实是计算每一行的和，然后进行相加即可
            //2,1,4,3 的时候，就是sums[2][4]-sums[2,1] +sums[3][4]-sums[3,1] +sums[4][4]-sums[4,1]
            sum += sums[i][col2 + 1] - sums[i][col1];
        }
        return sum;
    }
}
