package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/3/31 2:58 下午
 * @Description 74. 搜索二维矩阵
 * <p>
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 */
public class T0330 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 99;
        System.out.println(searchMatrix2(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int[] arrs;
        int len = 0;
        // 计算一维数组长度
        for (int[] element : matrix) {
            len += element.length;
        }
        // 复制元素
        arrs = new int[len];
        int index = 0;
        for (int[] element : matrix) {
            for (int element2 : element) {
                arrs[index++] = element2;
            }
        }
        return search(arrs, target, 0, arrs.length - 1);
    }

    /**
     * 二分查找算法
     *
     * @param arr   一维数组
     * @param value 需要查找的值
     * @param min   min长度
     * @param max   max长度
     */
    public static boolean search(int[] arr, int value, int min, int max) {
        int mid = (min + max) / 2;//基准值
        //咩有找到直接返回
        if (value < arr[min] || value > arr[max] || min > max) {
            return false;
        }
        if (arr[mid] < value) {
            return search(arr, value, mid + 1, max);
        } else if (arr[mid] > value) {
            return search(arr, value, min, mid - 1);
        } else {
            return true;//找到了 返回true
        }
    }


    public static boolean searchMatrix1(int[][] matrix, int target) {
        /*
         * 直接一次二分查找
         * 若将矩阵每一行拼接在上一行的末尾，则会得到一个升序数组，我们可以在该数组上二分找到目标元素。
         * 代码实现时，可以二分升序数组的下标，将其映射到原矩阵的行和列上。
         * 也是二维数组当作一维数组来做
         */
        int m = matrix.length;//行长度
        int n = matrix[0].length;//列长度
        int low = 0;//
        int high = m * n - 1;//
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int value = matrix[mid / n][mid % n];
            if (value < target) {
                low = mid + 1;
            } else if (value > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        /*
         * 坐标轴解法：
         * 某列的某个数字，该数之上的数字，都比其小；
         * 某行的某个数字，该数右侧的数字，都比其大；
         * 解题流程如下：
         * 1、以左下角为原点，建立坐标轴
         * 2、当前数大于查找数，上移：上面比其小
         * 3、当前数小于查找数，右移：右边比其大
         */
        int rows = matrix.length - 1;//初始化行坐标
        int clomus = 0;//初始化列坐标
        while (rows >= 0 && clomus < matrix[0].length) {
            int value = matrix[rows][clomus];
            if (value == target) {
                return true;
            } else if (value > target) {
                //当前数大于查找数，上移：上面比其小
                rows--;
            } else {
                //当前数小于查找数，右移：右边比其大
                clomus++;
            }
        }
        return false;
    }
}
