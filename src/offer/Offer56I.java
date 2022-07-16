package offer;

import java.util.*;

/**
 * @Author tangmf
 * @Date 2021/11/30 3:50 下午
 * @Description 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>l
 * 示例 1：
 * 输入：[4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 */
public class Offer56I {
    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 4, 1, 6};
        System.out.println(Arrays.toString(new Offer56I().singleNumbers1(nums)));
    }

    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();//定义一个hash 来存储数组中每个数字出现的次数
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);//直接统计次数
        }
        int[] res = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res[i] = entry.getKey();
                i++;
            }
        }
        return res;
    }

    public int[] singleNumbers1(int[] nums) {
        /*
        异或：二进制运算，同为0，不同为1
        规律：
        任何数和0异或，仍为本身：a⊕0 = a
        任何数和本身异或，为0：a⊕a = 0
        异或运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
        1. 遍历 nums 执行异或运算
        2. 返回出现一次的数字 x
        将nums中所有数字执行异或运算，留下的结果则为 出现一次的数字x 即：
            a⊕a⊕b⊕b⊕x=0⊕0⊕0⊕...x=x，任何数和0 异或就是本身
        难点：有两个只出现一次的数字，无法通过异或直接得到。
        设两个只出现一次的数字为x，y，由于x≠y，则x和y二进制至少有一位不同(即分别为0和1)，根 据此位可以将nums拆分为分别包含x和y的两个子数组。
        易知两子数组都满足「除一个数字之外，其他数字都出现了两次」。因此，仿照以上简化问题的思路，分别对两子数组遍历执行异或操作，即可得到两个只出现一次的数字x，y
        算法流程：
        1、遍历nums执行异或，设整型数组mams={a,a,b,b,x,y],对nums中所有数字执行异或,得到的结果为x⊕y,即
                a⊕a⊕b⊕b⊕x⊕y
                =0⊕0..⊕x⊕y
                =x⊕y
        2、循环左移计算m
        - 根据异或运算定义，若整数x⊕y某二进制位为1，则x和y的此二进制位一定不同。換言之，找到 x⊕y某为1的二进制位，即可将数组nums拆分为上述的两个子数组。根据与运算特点，可知对于任意整数a有
            - 若a&0001=1，则a的第一位为1；
            - 若a&0010=1，则a的第二位为1;
            - 以此类推
        - 因此，初始化一个辅助変量m=1，通过与运算从右向左循环判断，可获取整数x⊕y首位1，记录于m中，代码如下
           - while(z & m == 0) // m 循环左移一位，直到 z & m ！= 0
                m = m<< 1
        3、拆分 nums 为两个子数组
        4、分别遍历两个子数组执行异或
         - 通过遍历判断mums中各数字和mn做与运算的结果，可将数组拆分为两个子数组，并分别对两个子数组遍历求异或，
         则可得到两个只出现一次的数字，代码如下
         - for(int num: nums) {
                if((num & m) != 0) x ^= num;  // 若 num & m != 0 , 划分至子数组 1 ，执行遍历异或
                else y ^= num;                // 若 num & m == 0 , 划分至子数组 2 ，执行遍历异或
            }
            return new int[] {x, y};          // 遍历异或完毕，返回只出现一次的数字 x 和 y
        5、返回只出现一次的数字 x, y 即可。
        */
        int x = 0, y = 0, n = 0, m = 1;
        // 1. 遍历异或
        for (int num : nums) {
            n = n ^ num;
        }
        //2. 循环左移
        while ((n & m) == 0) {//m 循环左移一位，直到 z & m ！= 0
            m = m << 1;
        }
        //3.遍历 nums 分组，4.分别遍历两个子数组执行异或
        for (int num : nums) {
            if ((num & m) != 0) {
                x ^= num;  // 4. 当 num & m != 0
            } else {
                y ^= num;// 4. 当 num & m == 0
            }
        }
        //5.返回即可
        return new int[]{x, y};
    }
}
