package One_question_per_day;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2021/4/13 9:38 上午
 * @Description 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 */
public class T0413 {
    private static int ans1 = Integer.MAX_VALUE;
    private static TreeNode prev1 = null;//前一个节点

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode leftNode = new TreeNode(0);
        TreeNode rightNode = new TreeNode(48);
        treeNode.left = leftNode;
        treeNode.right = rightNode;
        rightNode.left = new TreeNode(12);
        rightNode.right = new TreeNode(49);
        TreeNode.inOrderTraverse(treeNode);
        System.out.println();
        System.out.println("sdafdsa：" + minDiffInBST1(treeNode));
        System.out.println("sdafdsa：" + minDiffInBST2(treeNode));
    }

    public static int minDiffInBST(TreeNode root) {
        /*
        二叉树的中序是递增的，中序遍历后的值序列即能用上文提及的方法来解决
        1、经过一次中序遍历将值保存在一个数组中国呢进行遍历求解
        2、在中序遍历过程中用pre遍历保存前驱节点的值，即能遍历也能更新答案。
        3、需要注意的是pre的初始值需要设置成任意负数标记开头，下文代码设置为1；
         */
        List<Integer> res = new ArrayList<>();
        dfs(root, res);//dfs 中序遍历 有序的，所有节点存于数组中
        int ans = Integer.MAX_VALUE;//定义一个最大值，返回，用来获取差值中的最小值
        //遍历求取差值
        for (int i = 1; i < res.size(); i++) {
            int curr = Math.abs(res.get(i) - res.get(i - 1));
            ans = Math.min(ans, curr);
        }
        return ans;
    }

    public static void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }

    public static int minDiffInBST1(TreeNode root) {
        /*
            模仿二叉树的迭代的写法
         */
        int ans = Integer.MAX_VALUE;//记录前后两个节点差值的最小值
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, prev = null;//记录前一个节点
        while (curr != null || !stack.isEmpty()) {
            //这里是去遍历左边
            if (curr != null) {
                stack.push(curr);//入栈
                curr = curr.left;//遍历左边
            } else {
                curr = stack.pop(); //节点为空，说明左边已经走完了，需要弹出节点，并且加入到list中
                //记录差值的最小值
                if (prev != null)
                    ans = Math.min(ans, curr.val - prev.val);
                prev = curr;//当前节点遍历之后就变成了前一个节点
                curr = curr.right;//遍历右边
            }
        }
        return ans;
    }

    public static int minDiffInBST2(TreeNode root) {
        /*
            直接递归，使用的前一个节点
         */
        dfs1(root);
        return ans1;
    }

    public static void dfs1(TreeNode root) {
        if (root == null) return;
        dfs1(root.left);
        //记录当前节点和前一个节点的差值
        if (prev1 != null)
            ans1 = Math.min(ans1, root.val - prev1.val);
        //当前节点遍历之后就变成了前一个节点
        prev1 = root;
        dfs1(root.right);
    }

}
