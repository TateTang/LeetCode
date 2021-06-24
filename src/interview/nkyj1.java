package interview;

/**
 * @Author tangmf
 * @Date 2021/6/23 9:16 下午
 * @Description
 */
public class nkyj1 {
    public static void main(String[] args) {
        int n = 30;
        System.out.println(new nkyj1().foo(n));
    }
    public int foo(int n) {
        if (n <= 2) {
            return 1;
        }
        return foo(n - 1) + foo(n - 2);
    }
}
