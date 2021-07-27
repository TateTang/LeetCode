package One_question_per_day;

import com.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author tangmf
 * @Date 2021/7/27 10:09 上午
 * @Description 671. 二叉树中第二小的节点
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 */
public class T0727 {
    Set<Integer> set = new HashSet<>();
    int ans = -1;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(5);
        treeNode.left = leftNode;
        treeNode.right = rightNode;
        rightNode.left = new TreeNode(5);
        rightNode.right = new TreeNode(7);
        //TreeNode.inOrderTraverse(treeNode);
        System.out.println(new T0727().findSecondMinimumValue(treeNode));
    }

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        if (set.size() < 2) return -1;//说明没有
        //这里后续用有序的list处理即可，因为流中进行了倒序处理，收集成set后会重排
        List<Integer> list = set.stream().sorted().collect(Collectors.toList());
        //System.out.println(list);
        //int first = Intsceger.MAX_VALUE, sencond = Integer.MIN_VALUE;
        //for (int i : set) {
        //    if (i <= first) {
        //        sencond = first;
        //        first = i;
        //    } else if (i <= sencond) {
        //        sencond = i;
        //    }
        //}
        //return sencond;
        return list.get(1);
    }

    /**
     * 树的遍历
     */
    private void dfs(TreeNode root) {
        /*
        利用set 存储，得到去重的节点大小，
        可以通过排序找到次小值，也可以使用经典的变量&一次遍历的方式，找到次小值
         */
        if (root == null)
            return;
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public int findSecondMinimumValue1(TreeNode root) {
        /*
         * 递归解法：
         * 解法一显然没有利用到本题核心条件 :「root.val = min(root.left.val, root.right.val)」和「每个子节点数量要么是 0 要么是 2」。
         * 我们可以设计如下递归函数，含义为 从 root 为根的树进行搜索，找到值比 cur 大的最小数。然后使用全局变量 ans 存储答案。
         * 那么最终搜索范围为 dfs(root, root.val)，这是因为性质 root.val = min(root.left.val, root.right.val)，
         * 即最小值会不断往上传递，最终根节点必然是全局最小值。
          然后再结合「每个子节点数量要么是 0 要么是 2」，我们可以特判一下 ans 是否为第一次赋值，
          * 如果给 ans 赋了新值或者更新了更小的 ans，则不再需要往下搜索了。
          * val > left > right
         */
        dfs1(root, root.val);
        return ans;
    }

    public void dfs1(TreeNode root, int cur) {
        if (root == null) return;
        if (root.val != cur) {
            if (ans == -1) ans = root.val;
            else ans = Math.min(ans, root.val);
            return;
        }
        dfs1(root.left, cur);
        dfs1(root.right, cur);
    }
}
