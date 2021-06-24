package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/6/24 9:48 上午
 * @Description 剑指 Offer 15. 二进制中1的个数
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */
public class T0623 {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(new T0623().hammingWeight(n));
    }

    public int hammingWeight(int n) {
        /*
        位运算优化：
        1、思路和解法： n & (n-1)预算结果恰好为把二进制中的最低位的1变成0的结果
        2、🌰：6 & (6-1) = 110 & 101 = 100 =4 运算结果4，为把6的二进制中的最低位变成0的结果
        3、🌰：4 &（4-1） = 100 & 011 = 000 =0 把4的二进制中的最低位变成0
        4、利用这个性质加速检查过程，不断让 n & n-1 位运算，直到n 变成0即可
        5、每次运算会使得 n 的最低位1 被翻转成0，因此每次翻转计数即可，就是二进制中1的个数

        * 时间复杂度：O(logn),循环次数等于n的二进制中1的个数，最坏情况下n的二进制的个数全部为1，需要logN次。
        * 空间复杂度：O(1)，我们只需要常数的空间保存若干变量。
         */
        int ans =0;
        while (n !=0){
            n = n & (n-1);
            ans++;
        }
        return ans;
    }
}
