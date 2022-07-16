package offer;

import java.net.URLDecoder;

/**
 * @Author tangmf
 * @Date 2021/7/29 5:12 下午
 * @Description 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 */
public class Offer04 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        //int[][] matrix = {{1},{1}};
        int target = 5;
        System.out.println(new Offer04().findNumberIn2DArray(matrix, target));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        /*
        1、直接一次二分查找

         */
        String callbackUrl = "https://wxis.91160.com/wxis/act/zhenzhongUnitaryEntry.do?buss_type=selfExamAppt&environment=wechat&unit_id=104";
            callbackUrl = URLDecoder.decode(callbackUrl);
            String[] strs = callbackUrl.split("unit_id=");
            System.out.println(strs[1]);
        return false;
    }

    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        /*
         * 坐标轴解法：
         * 某列的某个数字，该数之上的数字，都比其小；
         * 某行的某个数字，该数右侧的数字，都比其大；
         * 解题流程如下：
         * 1、以右上角为原点，建立坐标轴
         * 2、当前数等于查找数，直接返回
         * 3、当前数大于查找数，左移：左边比其小
         * 4、当前数小于查找数，下移：下面比其大
         */
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = 0; //定义行坐标
        int columns = matrix[0].length - 1;//定义列坐标
        System.out.println(matrix[rows][columns]);
        while (0 <= columns && rows < matrix.length ) {
            int value = matrix[rows][columns];//初始值 就是右上角,matrix[rows][columns]
            if (value == target) {
                return true;//找到直接返回
            } else if (value > target) {
                //左移 columns--
                columns--;
            } else {
                //下移 rows++
                rows++;
            }
        }
        return false;
    }
}
