package One_question_per_day;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2021/4/12 10:26 上午
 * @Description 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 * 输入：nums = [10]
 * 输出："10"
 */
public class T0412 {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 9, 5};
        System.out.println(largestNumber(nums));

    }

    public static String largestNumber(int[] nums) {
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
        //比较两个字符串的大小，然后进行降序排列
        //所以[3,30,34]排序后变为[34,3,30]，[233，23333]排序后变为[23333，233]
        Arrays.sort(numsToWord, (a, b) -> (b + a).compareTo(a + b));
        if (numsToWord[0].equals("0")) {
            return "0";//排序后第一个元素为0，可直接返回0；
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(numsToWord[i]);
        }
        return builder.toString();
    }
}
