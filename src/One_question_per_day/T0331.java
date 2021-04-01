package One_question_per_day;

import java.util.*;

/**
 * @Author tangmf
 * @Date 2021/4/1 11:02 上午
 * @Description 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集不能包含重复的子集。返回的解集中，子集可以按 任意顺序排列。
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 回溯模板
 * res = []
 * path = []
 * <p>
 * def backtrack(未探索区域, res, path):
 * if path 满足条件:
 * res.add(path) # 深度拷贝
 * # return  # 如果不用继续搜索需要 return
 * for 选择 in 未探索区域当前可能的选择:
 * if 当前选择符合要求:
 * path.add(当前选择)
 * backtrack(新的未探索区域, res, path)
 * path.pop()
 */
public class T0331 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        /*
         * 「回溯法」实际上一个类似枚举的搜索尝试过程，
         * 主要是在搜索尝试过程中寻找问题的解，当发现已不满足求解条件时，就「回溯」返回，尝试别的路径。
         * 回溯法的整体思路是：搜索每一条路，每次回溯是对具体的一条路径而言的。对当前搜索路径下的的未探索区域进行搜索，则可能有两种情况：
            1、当前未搜索区域满足结束条件，则保存当前路径并退出当前搜索；
            2、当前未搜索区域需要继续搜索，则遍历当前所有可能的选择：如果该选择符合要求，则把当前选择加入当前的搜索路径中，并继续搜索新的未探索区域。
            3、上面说的未搜索区域是指搜索某条路径时的未搜索区域，并不是全局的未搜索区域。
            回溯法搜所有可行解的模板一般是这样的：
            res = []
            path = []
            def backtrack(未探索区域, res, path):
                if path 满足条件:
                    res.add(path) # 深度拷贝
                    # return  # 如果不用继续搜索需要 return
                for 选择 in 未探索区域当前可能的选择:
                    if 当前选择符合要求:
                        path.add(当前选择)
                        backtrack(新的未探索区域, res, path)
                        path.pop()
          */
        Arrays.sort(nums);//注意如果有重复元素且又要做排列或者子集的话我们一般先排序，方便后面剪枝
        //Set<List<Integer>> res = new HashSet<>();
        //ArrayList<Integer> cur = new ArrayList<>();
        //dfs(nums, 0, cur, res);
        //return new ArrayList<>(res); //去重解法set


        List<List<Integer>> res = new LinkedList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        dfs1(nums, 0, cur, res);
        return res;
    }

    /**
     * 配合set进行去重，这个时候的set中的东西是无序的
     *
     * @param nums  原输入数组
     * @param index 前决策到原输入数组中的哪一位
     * @param cur   当前方案
     * @param res   最终方案
     */
    public static void dfs(int[] nums, int index,
                           ArrayList<Integer> cur, Set<List<Integer>> res) {
        //所有位置都决策完成，将当前方案放入结果集
        if (nums.length == index) {
            res.add(new ArrayList<>(cur));
            return;
        }
        // 选择当前位置的元素，往下决策
        cur.add(nums[index]);
        dfs(nums, index + 1, cur, res);

        //不选当前位置的元素(回溯)，往下决策
        cur.remove(cur.size() - 1);
        dfs(nums, index + 1, cur, res);
    }

    /**
     * 直接使用回溯法模板求解，剪去枝，去重复
     *
     * @param nums  原输入数组
     * @param index 当前决策到原输入数组中的哪一位
     * @param cur   当前方案
     * @param res   最终方案
     */
    public static void dfs1(int[] nums, int index,
                            ArrayList<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));//
        for (int i = index; i < nums.length; i++) {
            //剪枝，去重
            if (i > index && nums[i] == nums[i - 1]) {
                continue;//跳出当前循环
            }
            cur.add(nums[i]);//选择节点
            //继续探索新的节点 i +1;
            dfs1(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);//撤销选择
        }
    }
}
