package offer;

/**
 * @Author tangmf
 * @Date 2021/12/21 11:01 上午
 * @Description 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 */
public class Offer64 {
    int res = 0;

    public static void main(String[] args) {
        int n = 9;
        System.out.println(new Offer64().sumNums(n));
    }

    public int sumNums(int n) {
        /*
         * 1、平均计算用到乘除法
         * 2、迭代会用到while if
         * 3、递归，需要if  if(n == 1) return 1; 不可取
         *     n += sumNums(n - 1);
         *     return n;
         *
         * 用其他方法来终止递归
         * if(A && B) 若A 为false，则不会执行判断B，（&& 短路）
         * if(A || B) 若A 为true，则不会执行判断B，（|| 短路）
         * n > 1 && sumNums(n-1)
         * - 若n > 1 成立，开启递归 sumNums(n-1)
         * - 若n > 1 不成立，终止递归
         * 逻辑运算符的短路效应
         * 常见运算符： && || !
         * if(A && B) 若A 为false，则不会执行判断B，（&& 短路）
         * if(A || B) 若A 为true，则不会执行判断B，（|| 短路）
         * 本题需要实现"当n==1时终止递归"需求，通过短路效应实现
         * n > 1 && sumNums(n-1) 若n = 1 n>1 不成立， 此时短路，终止后续递归，
         *
         * 复杂度分析
         *  - 时间复杂度O(n)：计算n+(n-1)+(n-2)+.....+2+2 需要开启n个递归函数
         *  - 空间复杂度O(n)：递归深度达到n，系统使用O(n)大小的额外空间
         * 1、Java 中，为构成语句，需加一个辅助布尔量 flag，否则会报错
         * 2、开启递归函数需要改写为sumNums(n-1)>0，此整体作为一个布尔量输出，否则会报错
         * 3、初始化变量res，记录结果
         */
        //为构成语句，需加一个辅助布尔量 flag
        //n > 1 && sumNums(n-1) 若n = 1 n>1 不成立， 此时短路，终止后续递归，
        boolean flag = n > 1 && sumNums(n - 1) > 0;
        res += n;//res 记录结果
        return res;
    }

    public int sumNums2(int n) {
        //递归不可取，使用到了if
        if (n == 1) return 1;
        n += sumNums2(n - 1);
        return n;
    }
}
