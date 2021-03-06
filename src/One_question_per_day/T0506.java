package One_question_per_day;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2021/5/6 2:20 下午
 * @Description 1720. 解码异或后的数组
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。
 * 例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 * 示例 1：
 * 输入：encoded = [1,2,3], first = 1
 * 输出：[1,0,2,1]
 * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * 示例 2：
 * 输入：encoded = [6,2,7,3], first = 4
 * 输出：[4,2,0,7,4]
 */
public class T0506 {
    public static void main(String[] args) {
        int[] encoded = {1, 2, 3};
        int first = 1;
        System.out.println(Arrays.toString(new T0506().decode(encoded, first)));
    }

    public int[] decode(int[] encoded, int first) {
        /*
        异或：同0异1；二进制运算 ，异或具有交换律
        异或性质：
        1、相同数值异或，结果为 0
        2、任意数值与0异或，结果为数值本身
        3、异或本身满足交换律
        已知：encoded[i] = arr[i] XOR arr[i + 1] ，等式两边同时「异或」上arr[i]得到
        1、arr[i] XOR encoded[i] = arr[i] XOR arr[i] XOR arr[i + 1]
        2、结合「性质三」和「性质一」，化简等式右边得到  arr[i] XOR encoded[i] = arr[i+1] XOR 0
        3、结合「性质二」，继续化简等式右边得到，arr[i] XOR encoded[i]=arr[i+1]
        因为存在 encoded[i]=arr[i] ^ arr[i+1]
        所以arr[i+1] = encoded[i] ^ arr[i]
         */
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            arr[i + 1] = encoded[i] ^ arr[i];
        }
        return arr;
    }
}
