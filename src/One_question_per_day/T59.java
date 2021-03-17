package One_question_per_day;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2021/3/17 11:12 上午
 * @Description 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 */
public class T59 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.deepToString(generateMatrix(n)));
        int newN = (int) Math.pow(n, 2);
        System.out.println(newN);
    }

    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        if (n == 1) {
            return new int[][]{{1}};
        }
        int top = 0;//上边界
        int right = arr[0].length - 1;//右边界：列长度-1
        int bottom = arr.length - 1;//下边界：行长度-1
        int left = 0; //左边界
        int newN = (int) Math.pow(n, 2);
        int count = 1;//计数
        while (count <= newN) {
            //从左向右，边界:left，right 边界收缩上边界+1
            for (int i = left; i <= right; i++) {
                arr[top][i] = count;//取得的第一行的值，top固定，行固定，i递增
                count++;//递增
            }
            top++;
            if (top > bottom) break;
            //从上往下，边界:top,bottom 边界收缩右边界-1
            for (int i = top; i <= bottom; i++) {
                arr[i][right] = count;//取得最后一列的值，i递增，right固定，列固定
                count++;//递增
            }
            right--;
            //从右往左，边界:right left，边界收缩 下边界-1
            if (left > right) break;
            for (int i = right; i >= left; i--) {
                arr[bottom][i] = count;//取得最后一行的值，bottom固定，行固定，i递减
                count++;//递增
            }
            bottom--;
            if (top > bottom) break;
            //从下往上，边界：bottom，top 边界收缩，做边界+1
            for (int i = bottom; i >= top; i--) {
                arr[i][left] = count;//取得第一列的值，i递减，left固定:列固定
                count++;//递增
            }
            left++;
            if (left > right) break;

        }
        return arr;
    }

}
