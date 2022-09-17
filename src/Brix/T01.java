package Brix;

/**
 * @author tangmf
 * @date 2022年09月16日 18:03:​56
 * 给定一个整数，如果该数是素数，则返回1。否则返回大于1的最小除数。
 * 例子
 * n=24
 * 数字24 不是素数：它的除数是[1，2，3，4 6，8，12，24]。大于1的最小除数是2。
 */
public class T01 {
    public static void main(String[] args) {
        long n = 24;
        System.out.println(isPrime(n));
    }

    public static int isPrime(long n) {
        if (n == 1) {
            return 1;
        }
        int max = (int) Math.sqrt(n);
        for (int i = 2; i <= max; i++) {
            if (n % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
