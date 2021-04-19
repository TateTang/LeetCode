package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/4/19 2:38 下午
 * @Description 26. 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 */
public class T0418 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates1(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int left = 0;//设置不同数字的递增索引指针index,初始化为0
        //遍历数组，当nums[i]和当前index的值不同时，递增index，赋值
        for (int right = 0; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];//++在前，先加减后运算
            }
        }
        return left + 1;//返回index + 1即不同数字个数
    }

    public static int removeDuplicates1(int[] nums) {
        /*
         * 快慢指针解法：
         * fast 和slow，fast：表示遍历数组到达的下标位置，慢指针表示一个不同元素要填入的下标位置，初始时都指向下标1
         * - 数组nums长度为n fast 在[1:n-1]位置，如果存在nums[fast]!=nums[fast-1]，说明nums[fast]和之前的元素都不相同
         * 因此将nums[fast]的值复制到nums[slow]，slow++，指向下一个位置
         * - 遍历结束后，nums[0]到nums[slow-1]的每个元素都不相同且包含原数组中的每个不同的元素，因此新的长度为slow，返回即可
         */
        if (nums.length == 0) return 0;
        int fast = 1, slow = 1;//定义两个指针快慢指针
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;//返回index + 1即不同数字个数
    }
}
