package One_question_per_day;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author tangmf
 * @Date 2021/6/3 10:02 上午
 * @Description 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * 示例 1:
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 */
public class T0603 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1};
        System.out.println(new T0603().findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {
        /*
        前缀和+哈希表
        1、由于题目说明「0和1的数量相同」等价于「1的数量减去0的数量等于0」，可以将数组中的0视为-1，原问题转换为
        「求最长的连续子数组，元素和为0」
        2、nums长度为n，nums转换后得到长度相等的新数组newNums;对于0<=i<n，
          - nums[i]=1，newNums[i]=1
          - nums[i]=0，newNums[i]=-1
        3、为了快速计算newNums的子数组的元素和，首先需要计算newNums的前缀和。
          - prefixSums[i]：表示newNums从下标0到下标i的前缀和
          - newNums从下标j+1 到下标k的子数组的元素和为 prefixSums[k]-prefixSums[j]，长度为k-j
          - prefixSums[k]-prefixSums[j]=0时候，得到newNums的一个长度为k-j的子数组元素和为0
          - 对应nums的一个长度为k-j的子数组中拥有相同数量的0和1
        4、实现，不需要创建数组newNums和prefixSums。只需要维护一个变量counter存储newNums的前缀和即可
          - 遍历数组nums，遇到元素1时加1，遇到元素0减1。
          - 遍历过程中使用哈希表存储每个前缀和第一次出现的下标
        5、具体实现
          - 规定空的前缀的结束下标为-1，由于空的前缀的元素和为0，因此遍历之前，首先在哈希表中存入键值对（0，1），
          遍历过程中，每个下标i，进行如下操作
           - 如果counter的值在哈希表中已经存在，取出counter在哈希表中对应的下标prevIndex，nums从下标prevIndex+1
           到下标i的子数组中有相同数量的0和1，该子数组的长度为i-prevIndex,使用该子数组的长度更新最长连续子数组的长度
           - 如果counter的值在哈希表中不存在，将当前余数和当前下标i的键值对存入哈希表中
        6、由于哈希表存储的counter的每个取值第一次出现的下标，因此遇到重复的前缀和的时候，根据当前下标和哈希表中存储的下标
        计算得到的子数组长度是以当前下标结尾子数组中满足有相同数量的0和1的最长子数组的长度。遍历结束的时候，可得到nums中的有
        相同的0和1的最长子数组的长度
         */
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;//存储newnums的前缀和
        map.put(counter, -1);//规定空的前缀的结束下标为-1，由于空的前缀的元素和为0，因此遍历之前，首先在哈希表中存入键值对（0，1）
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                //哈希表中存在，取出prevIndex
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);//更新
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }

    public int findMaxLength2(int[] nums) {
        /*
        前缀和+哈希表
        转化为「求最长的连续子数组，元素和为0」问题
        步骤：
        1.创建一个哈希表，用key来储存cur值，value来储存当前index。
        2.假设我们碰到0就将cur decrement (减- -), 碰到1则increment (加一)。
        3.如果我们能在哈希表中找到当前的cur 值，则取出对应的pos,在看当前的index 一pos 是否比
        ans大，取其中的最优解。
        核心：由于碰1加1，碰0减1的操作，0 1 数量一致的时候，连续数组的和为0，因此我们知道数组前面的
        cur值是什么，到达该连续数组尾部时不会改变。因此只需要坚持哈希表中是否存在相同的cur值即可

        为什么在哈希表中找到了相同的 cur 值则算找到了一串连续数组？
        “如果这是一串连续子数组，那么cur的值，在到达该子数组尾部时(紫色箭头处)，与在该子数组前一位时(绿色箭头处)，是相等的”@bingo-70
        为什么要在哈希表中插入{0, -1}?
        这是为了辅助讨论该连续数组的起始点在 index == 0 的位置的情况，如果最长连续数组在数组的最前方，不插入{0,-1}会得到错误的答案，
        因此我们一定要插入该辅助键值！具体可以看看动图中的前几位数字看看{0,-1}是如何辅助我们得到答案的！
         */
        int cur = 0, ans = 0;
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length, 1.05f);// 避免扩容
        map.put(0, -1);
        for (int i = 0; i < length; i++) {
            nums[i] = nums[i] == 0 ? --cur : ++cur;// 遇到 0 减一；遇到 1 加一
            if (map.containsKey(cur)) {
                // 关于长度为什么不是 i - map.get(cur) + 1
                // 可以参考一下答主你问我答第一个回答的图片
                // 当 map 中存在一样的 key 时
                // 数组中满足条件的位置应该是[map.get(cur) + 1, i]
                ans = Math.max(ans, i - map.get(cur));
            } else {
                map.put(cur, i);
            }
        }
        return ans;
    }
}
