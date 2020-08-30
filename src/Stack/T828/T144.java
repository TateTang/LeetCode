package Stack.T828;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2020/8/29 10:32
 * @Description 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 */
public class T144 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        treeNode.left = leftNode;
        treeNode.right = rightNode;
        leftNode.left = new TreeNode(4);
        leftNode.right = new TreeNode(5);
        rightNode.left = new TreeNode(6);
        TreeNode.preOrderTraverse(treeNode);
        System.out.println("---------------");
        System.out.println(preorderTraversal(treeNode));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //pre(root, list);
        //利用迭代算法实现,非递归实现，基于栈的遍历
        /*
        1、模拟递归的调用，每走一次就将当前节点保存到栈中。
        2、当前节点为空，说明左边走到头了，从栈中弹出节点，并且保存
        3、然后转向右边节点，继续上面的过程
         */
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);//当前节点保存到栈中
                list.add(curr.val);//当前节点不为空，说明是根节点，直接进行入栈即可
                curr = curr.left;//遍历左边
            }
            //节点为空，左边走到了，转向右边节点
            curr = stack.pop();//将当前的栈顶弹出，也就是退回到父节点，这样在通过父节点去获取左子树或者右子树
            curr = curr.right;//遍历右边
        }
        return list;
    }

    //递归实现
    //前序遍历 根-左-右
    private static void pre(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        //遍历左子树
        TreeNode treeLeft = root.left;
        if (treeLeft != null) {
            pre(treeLeft, list);
        }
        //遍历右子树
        TreeNode treeRight = root.right;
        if (treeRight != null) {
            pre(treeRight, list);
        }
    }
}
