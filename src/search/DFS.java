package search;

import com.TreeNode;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2021/3/16 3:54 下午
 * @Description Depth First Search
 * 广度优先搜索
 */
public class DFS {
    public static void main(String[] args) {
        //f(3);
        TreeNode treeNode = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        treeNode.left = leftNode;
        treeNode.right = rightNode;
        leftNode.left = new TreeNode(4);
        leftNode.right = new TreeNode(5);
        rightNode.left = new TreeNode(6);
        rightNode.right = new TreeNode(7);
        DFSWithRecursion(treeNode);
        //DFSWithStack(treeNode);

    }

    public static void f(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        f(n - 1);
        System.out.println(n);
    }
    /*
    输出：
    3
    2
    1
    1
    2
    3
     main中调用f()函数
     n=3 输出3 调用f(n-1)//第一层函数
     n=2 输出2 调用f(n-1);//第二层函数
     n=1 输出1 调用f(n-1);//第三层函数
     n=0 return 返回到上一次函数，第三层输出1
     然后返回到第二层 n=2
     最后第一层 n=1
     f()函数结束
     */

    /**
     * 递归实现DFS遍历二叉树
     *
     * @param root 二叉树节点
     */
    public static void DFSWithRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        //在这里处理遍历到的TreeNode节点
        System.out.println(root.val);
        if (root.left != null)
            DFSWithRecursion(root.left);
        if (root.right != null)
            DFSWithRecursion(root.right);
    }

    /**
     * DFS迭代实现
     *
     * @param root 二叉树节点
     */
    public static void DFSWithStack(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            //在这里处理遍历到的TreeNode
            if (treeNode.right != null)
                stack.push(treeNode.right);
            if (treeNode.left != null)
                stack.push(treeNode.left);
            System.out.println(treeNode.val);
        }
    }

}
