package offer;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2021/12/15 10:32 上午
 * @Description 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */
public class Offer66 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(new Offer66().constructArr(a)));
    }

    public int[] constructArr(int[] a) {

        /*
        1，2，3，4，5 为例子
         B[0] =                     * A[1]*A[2]*A[3]*A[4]
         B[1] = A[0]                * A[2]*A[3]*A[4]
         B[2] = A[0]*A[1]           * A[3]*A[4]
         B[3] = A[0]*A[1]*A[2]      * A[4]
         B[4] = A[0]*A[1]*A[2]*A[3]

         不能使用除法，需要只用乘法 生成数组B，可以进行表格
         B[0]   1      A[1]    A[2]    ... A[n-1]  A[n]
         B[1]   A[0]    1    A[2]    ... A[n-1]  A[n]
         B[2]   A[0]   A[1]    1    ... A[n-1]  A[n]
         ...    ...   ...   ...    ...   ...     ...
         B[n-1] A[0]   A[1]    A[2]    ... 1  A[n]
         B[n]  A[0]   A[1]    A[2]    ... A[n-1]  1
         B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
         通过两轮循环，分别计算下三角 和 上三角的乘积
         算法流程：i
         - 1、初始化：数组B，其中B[0] =1 ,辅助变量tmp=1
         - 2、计算B[i] 的下三角 各元素的乘积，直接乘入B[i]
         - 3、计算B[i] 的上三角 各元素的乘积，记为tmp，乘入B[i];
         - 4、返回B
         复杂度分析
         - 时间复杂度O(N)：其中 N 为数组长度，两轮遍历数组a，使用O(N)时间
         - 空间复杂度O(1)：变量tmp使用常数大小额外空间(数组b作为返回值，不计入复杂度考虑)


         */
        if (a.length == 0) {
            return new int[0];
        }
        int[] b = new int[a.length];//初始化数组B
        b[0] = 1;
        int temp = 1;//辅助变量

        //计算b：b[i]表示 a[0....i-1]的乘积，就是下三角的乘积
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];//需要把前面一个数乘上
        }
        //计算temp：表示a[i....n-1]乘积，上三角乘积
        for (int i = a.length - 1; i >= 0; i--) {
            b[i] = b[i] * temp;
            temp = temp * a[i];//上三角乘积
        }
        return b;
    }
}
