package One_question_per_day;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2021/5/12 5:21 下午
 * @Description 1734. 解码异或后的排列
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，
 * 满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 * 示例 1：
 * <p>
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，
 * 那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * 示例 2：
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 */
public class T0511 {
    public static void main(String[] args) {
        int[] encoded = {6, 5, 4, 6};
        System.out.println(Arrays.toString(new T0511().decode(encoded)));
    }

    public int[] decode(int[] encoded) {
        /*
        异或：同0异1；二进制运算 ，异或具有交换律
        异或性质：
        1、相同数值异或，结果为 0
        2、任意数值与0异或，结果为数值本身
        3、异或本身满足交换律
        已知：encoded[i] = perm[i] XOR perm[i + 1] ，等式两边同时「异或」perm[i]得到
        1、encoded[i] XOR  perm[i] = perm[i] XOR perm[i + 1] XOR perm[i]
        2、结合「性质三」和「性质一」，化简等式右边得到  encoded[i] XOR  perm[i] = perm[i+1] XOR 0
        3、结合「性质二」，继续化简等式右边得到，encoded[i] XOR  perm[i]=perm[i+1]
        因为存在 prem[i+1]=encoded[i] XOR perm[i]
        需要找到perm[0]
        perm 1,2,3,4,5,6,7
        encoded 1^2,2^3,3^4,4^5,5^6,6^7
        encoded[1]^encoded[3]^encoded[5] =2^3^4^5^6^7
        a^a=0;      任何数字和自己异或都是0
        0^a=a;      任何数字和0异或还是他自己
        a^b^c=a^c^b 异或运算具有交换律
        1、可以看到encoded数组中所有偶数位（下标从0开始的，是奇数)元素的异或结果其实
        就是数组perm中除第一个元素以外，其他所有元素异或的结果，我们记为m，
        m=2^3^4^5^6^7
        2、我们只需要从1到n都异或一遍然后在与m异或，结果就是数组encoded中的第一个元素了
        n= 1^2^3^4^5^6^7
        3、m ^ n = 2^3^4^5^6^7^1^2^3^4^5^6^7 ；任何数字和自己异或都是0所以最后m^n=1 也就是prem[0]
         */
        int length = encoded.length + 1;//代表prem的长度
        int allXor = 0;
        //把1到n中间的所有数字都异或一遍
        for (int i = 1; i <= length; i++) {
            allXor ^= i;

        }
        int even = 0;
        //数组encoded中第偶数个元素都异或一遍
        for (int i = 1; i < length - 1; i += 2) {
            even ^= encoded[i];
        }
        int[] prem = new int[length];
        prem[0] = allXor ^ even;
        for (int i = 0; i < length - 1; i++) {
            prem[i + 1] = prem[i] ^ encoded[i];
        }
        return prem;
    }
}
