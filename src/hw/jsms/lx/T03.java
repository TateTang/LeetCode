package hw.jsms.lx;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author tangmf
 * @date 2022年10月13日 11:05:​19
 * 给定一个二叉树，返回它的 后序 遍历
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */
public class T03 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        treeNode.left = leftNode;
        treeNode.right = rightNode;
        leftNode.left = new TreeNode(4);
        leftNode.right = new TreeNode(5);
        rightNode.left = new TreeNode(6);
        TreeNode.postOrderTraverse(treeNode);
        System.out.println(postorderTraversal(treeNode));
    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //post(root, list);//递归算法
        /*
        1、模拟递归的调用，每走一次就将当前节点保存到栈中。
        2、当前节点为空，说明左边走到头了，从栈中弹出节点
        3、然后转向右边节点，继续上面的过程
         */
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode last = null;//标明最后一次访问的节点所在
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);//入栈
                curr = curr.left;//左子树遍历
            }
            //节点为空，左边走到头了，从栈中弹出节点，转向右节点
            curr = stack.peek();//更新当前节点为用户栈出栈节点
            //右孩子为空或者访问过，访问当前节点，更新当前节点为空，为下一步出栈准备
            if (curr.right == null || curr.right == last) {
                list.add(curr.val);//元素入栈处理
                stack.pop();//弹出元素
                last = curr;//更新最后一次访问的节点为当前节点
                curr = null;//更新当前节点为空
            } else {
                //右孩子不为空，并且右孩子被访问过，更新当前节点为右孩子
                curr = curr.right;//右子树遍历
            }
        }

        return list;
    }

    //后序遍历 左-右-根
    private static void post(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        //遍历左子树
        TreeNode leftTree = root.left;
        if (leftTree != null) {
            post(leftTree, list);
        }
        //遍历右子树
        TreeNode rightTree = root.right;
        if (rightTree != null) {
            post(rightTree, list);
        }
        //根结点
        list.add(root.val);
    }
}
