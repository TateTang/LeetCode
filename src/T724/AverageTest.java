package T724;

import java.util.Arrays;

/**
 * @Author tangmf
 * @Date 2020/7/24 15:46
 * @Description 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 *
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：salary = [4000,3000,1000,2000] 输出：2500.00000 解释：最低工资和最高工资分别是 1000 和 4000 。 去掉最低工资和最高工资以后的平均工资是
 * (2000+3000)/2= 2500 获取总和，然后减去数组中的最小值和最大值。 最后将结果除以n-2。
 */
public class AverageTest {

    public static void main(String[] args) {
        int[] salary = {4000, 3000, 1000, 2000};
        System.out.println(average(salary));
    }

    private static double average(int[] salary) {
        Arrays.sort(salary);
        System.out.println(Arrays.toString(salary));
        int sum = 0;
        for (int i = 1; i < salary.length-1; i++) {
            sum += salary[i];
        }
        return sum / ((salary.length-2)*1.0);
    }
}
