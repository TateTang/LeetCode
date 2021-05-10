package One_question_per_day;

import com.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2021/5/10 2:03 下午
 * @Description 872. 叶子相似的树
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * 🌰1
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * 示例 2：
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 * 示例 3：
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 * 示例 4：
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 */
public class T0510 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root2 = new TreeNode(1, new TreeNode(3), new TreeNode(2));
        System.out.println(new T0510().leafSimilar(root1, root2));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        /*
          叶值序列:从左到右
         *叶子节点：没有子节点的节点，首先需要找到叶子节点
         */
        List<Integer> l1 = new LinkedList<>();
        dfs(root1, l1);
        List<Integer> l2 = new LinkedList<>();
        dfs(root2, l2);
        //if (l1.size() == l2.size()) {
        //    for (int i = 0; i < l1.size(); i++) {
        //        if (!l1.get(i).equals(l2.get(i))) {
        //            return false;
        //        }
        //    }
        //    return true;
        //}
        return l1.equals(l2);
    }

    public static void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        dfs(root.left, res);
        dfs(root.right, res);
    }
}
