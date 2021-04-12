package daily;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2021/4/12 2:16 下午
 * @Description 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class Toffer45 {
    public static void main(String[] args) {
        int[] nums = {0, 0};
        System.out.println(minNumber(nums));

    }

    public static String minNumber(int[] nums) {
        /*
            1、将数组内元素逐个转换成字符串后，直接通过compareTo方法比较
            2、a.compareTo(b)：从头开始比较对应字符的大小(ASCII码顺序)
            3、如果a的第一个字符和b的第一个字符不相等，结束比较，返回他们之间的长度差值
            4、如果a的第一个字符和b的第一个字符相等，则a的第二个字符和b的第二个字符比较，以此类推，直到
            比较的字符活被比较的字符有一方结束
         */
        int len = nums.length;
        String[] numsToWord = new String[len];
        for (int i = 0; i < len; i++) {
            numsToWord[i] = String.valueOf(nums[i]);
        }
        //compareTo()方法比较按照ASCII码逐位比较，通过比较(a+b)和(b+a)判断谁在前面
        //比较两个字符串的大小，然后进行升序排列。
        //所以[3,30,34]排序后变为[34,3,30]，[233，23333]排序后变为[23333，233]
        Arrays.sort(numsToWord, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(numsToWord[i]);
        }
        return builder.toString();
    }
}
