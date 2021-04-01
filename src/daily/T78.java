package daily;

import java.util.*;

/**
 * @Author tangmf
 * @Date 2021/4/1 4:15 下午
 * @Description 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class T78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        /*
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
        backtrack 的含义是：未探索区域中到达结束条件的所有可能路径，path 变量是保存的是一条路径，res 变量保存的是所有搜索到的路径。所以当「未探索区域满足结束条件」时，需要把 path 放到结果 res 中。
        path.pop() 是啥意思呢？它是编程实现上的一个要求，即我们从始至终只用了一个变量 path，所以当对 path 增加一个选择并 backtrack 之后，需要清除当前的选择，防止影响其他路径的搜索。
        *
        * 模板思路：
        * 1、未探索区域：剩余的未搜索的数组：nums[index]-->nums[nums.length-1]
          2、每个path是否满足题目的条件：任何一个 path 都是子集，满足条件，需要放到res中
          3、当前path满足条件时，是否继续搜索： 是的，找到nums[0:index-1]中的子集之后，nums[index]添加到老的path中形成新的子集
          4、未探索区域当前可能的选择：每次选择可以选取s的一个字符，即nums[index]
          5、当前选择符合要求：任何nums[index]都是符合要求的，直接放到path中;
          6、新的探索区域：nums在index之后的剩余字符串，nums[index+1:n-1]
        * */
        Arrays.sort(nums);//注意如果有重复元素且又要做排列或者子集的话我们一般先排序，方便后面剪枝
        List<List<Integer>> res = new LinkedList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        dfs(nums, 0, cur, res);
        return res;
    }

    /**
     * 直接使用回溯法模板求解
     *
     * @param nums  原输入数组
     * @param index 当前决策到原输入数组中的哪一位
     * @param cur   当前方案
     * @param res   最终方案
     */
    public static void dfs(int[] nums, int index,
                           ArrayList<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));//拷贝
        //进行探索
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);//选择节点
            //继续探索新的节点 i +1;
            dfs(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);//撤销选择
        }
    }
}
