package One_question_per_day;

import java.util.*;

/**
 * @Author tangmf
 * @Date 2021/6/24 10:13 上午
 * @Description 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class T0622 {
    //存放结果
    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(Arrays.toString(new T0622().permutation(s)));
    }

    public String[] permutation(String s) {
        /*
        * 返回所有不重复的列，需要进行去重
        * 1、去重一定要对元素经行排序，这样我们才方便通过相邻的节点来判断是否重复使用了。
        * 2、组合问题和排列问题是在树形结构的叶子节点上收集结果，而子集问题就是取树上所有节点的结果。
        * 3、排列问题，树层上去重和树枝上去重，都是可以的，但是树层上去重效率更高！
        * 说明同树层前一位重复读取了used[i - 1] == false
        * if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
            continue;
             }
          说明同树支前一位重复读取了used[i - 1] == true
          * if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == true) {
        continue;
        }
        * */
        StringBuilder builder = new StringBuilder();
        boolean[] used = new boolean[s.length()];
        Arrays.fill(used, false);
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        backtracking(arr, used, builder);
        return list.toArray(new String[0]);
    }


    public void backtracking(char[] chars, boolean[] used, StringBuilder builder) {
        if (chars.length == builder.length()) {
            list.add(builder.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }
            //如果同⼀树⽀nums[i]没使⽤过开始处理
            if (!used[i]) {
                used[i] = true;//标记同⼀树⽀nums[i]使⽤过，防止同一树支重复使用
                builder.append(chars[i]);
                backtracking(chars, used, builder);
                builder.deleteCharAt(builder.length() - 1);//回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
                used[i] = false;//回溯
            }
        }
    }


}
