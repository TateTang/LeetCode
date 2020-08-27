package Stack.T827;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2020/8/27 11:27
 * @Description 94. 二叉树的中序遍历给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class T94 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        treeNode.left = leftNode;
        treeNode.right = rightNode;
        leftNode.left = new TreeNode(4);
        leftNode.right = new TreeNode(5);
        rightNode.left = new TreeNode(6);
        //TreeNode.inOrderTraverse(treeNode);

        System.out.println(inorderTraversal(treeNode));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //infix(root, list);//递归方式

        //非递归实现，基于栈的遍历
        /*
        1、模拟递归的调用，每走一次就将当前节点保存到栈中。
        2、当前节点为空，说明左边走到头了，从栈中弹出节点，并且保存
        3、然后转向右边节点，继续上面的过程
         */
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            //这里是去遍历左边
            while (curr != null) {
                stack.push(curr);//入栈
                curr = curr.left;//遍历左边
            }
            curr = stack.pop(); //节点为空，说明左边已经走完了，需要弹出节点，并且加入到list中
            list.add(curr.val);//把值加入到list中
            curr = curr.right;//遍历右边
        }
        return list;
    }

    //前序遍历 根-左-右
    private static void pre(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        // 遍历左子树
        TreeNode tempLeft = root.left;
        if (tempLeft != null) {
            infix(tempLeft, list);
        }
        // 遍历右子树
        TreeNode tempRight = root.right;
        if (tempRight != null) {
            infix(tempRight, list);
        }
    }

    //中序遍历 左-根-右
    private static void infix(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // 遍历左子树
        TreeNode tempLeft = root.left;
        if (tempLeft != null) {
            infix(tempLeft, list);
        }
        list.add(root.val);
        // 遍历右子树
        TreeNode tempRight = root.right;
        if (tempRight != null) {
            infix(tempRight, list);
        }
    }

    //后序遍历 左-右-根
    private static void post(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // 遍历左子树
        TreeNode tempLeft = root.left;
        if (tempLeft != null) {
            infix(tempLeft, list);
        }
        // 遍历右子树
        TreeNode tempRight = root.right;
        if (tempRight != null) {
            infix(tempRight, list);
        }
        list.add(root.val);
    }


}
