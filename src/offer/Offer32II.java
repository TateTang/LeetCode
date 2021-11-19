package offer;

import com.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author tangmf
 * @Date 2021/8/17 10:25 上午
 * @Description 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class Offer32II {
    public static void main(String[] args) {
        TreeNode leftNode = new TreeNode(9);
        TreeNode rightNode = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, leftNode, rightNode);
        TreeNode.inOrderTraverse(root);
        System.out.println(new Offer32II().levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();//定义队列，先进献出
        queue.offer(root);//根节点入队
        while (!queue.isEmpty()) {
            int levelSize = queue.size();//bfs是一层一层打印的，用这个控制每次
            List<Integer> list = new ArrayList<>();//定义list存储每一层的值
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();//出队
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);//左子节点入队
                if (node.right != null) queue.offer(node.right);//右子节点入队
            }
            res.add(list);
        }
        return res;
    }
}
