package Stack.T916;

import com.TreeNode;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2020/9/16 7:05 下午
 * @Description 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class T103 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        TreeNode.preOrderTraverse(root);
        System.out.println("---------------");
        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /*
         * 1、遍历第二层的节点的的顺序是从左到右，而输出第二层的顺序是从右到左，满足栈的思想，用栈来遍历第二层节点
         * 2、遍历输出第二层节点，还需要将第三层节点按照从右到左存储，但是不能将第二层存储到这个栈中，因为会打乱第二层的顺序
         * 3、所以创建另外一个栈来存储第三层的元素，这样层与层之间不会相互干扰
         * 4、交替使用两个栈遍历所有的层级
         */
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //栈1来存储右节点到左节点的顺序
        Stack<TreeNode> stack1 = new Stack<>();
        //栈2来存储左节点到右节点的顺序
        Stack<TreeNode> stack2 = new Stack<>();
        //跟节点入栈
        stack1.push(root);
        //每次循环都是一个栈为空，一个栈不为空，结束的条件为两个都为空
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> subList = new ArrayList<>();//存储这一层的数据
            TreeNode curNode;
            //此时栈1 不为空，栈2 为空，用栈2来存储从左到右的顺序
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {//遍历栈1中所有元素，即当前层的所有元素
                    curNode = stack1.pop();
                    subList.add(curNode.val);//存储当前层所有元素
                    if (curNode.left != null) {
                        stack2.push(curNode.left);//左节点不为空，加入下一层
                    }
                    if (curNode.right != null) {
                        stack2.push(curNode.right);//右节点不为空，加入下一层
                    }
                }
                list.add(subList);
            }
            //此时栈2 不为空，栈1 为空，用栈1 来存储从右到左的顺序
            else {
                while (!stack2.isEmpty()) {//遍历栈2中所有元素，即当前层所有元素
                    curNode = stack2.pop();
                    subList.add(curNode.val);//存储当前层所有元素
                    if (curNode.right != null) {
                        stack1.push(curNode.right);//右节点不为空，加入下一层
                    }
                    if (curNode.left != null) {
                        stack1.push(curNode.left);//左节点不为空，加入下一层
                    }

                }
                list.add(subList);
            }
        }
        return list;
    }
}
