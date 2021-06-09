package shopee;

import com.TreeNode;

import java.util.*;

/**
 * @Author tangmf
 * @Date 2021/6/9 11:06 上午
 * @Description 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class lcd102 {
    public static void main(String[] args) {
        TreeNode leftNode = new TreeNode(9);
        TreeNode node1 = new TreeNode(15);
        TreeNode node2 = new TreeNode(7);
        TreeNode rightNode = new TreeNode(20, node1, node2);
        TreeNode root = new TreeNode(3, leftNode, rightNode);
        TreeNode.inOrderTraverse(root);
        System.out.println(new lcd102().levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();//返回结果
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();//存放树的节点
        queue.offer(root);//offer优与add add()方法是抛出异常让你处理，而offer()方法是直接返回false
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();//
            int levelSize = queue.size();//BFS是从上到下一层一层的打印，levelSize表示当前层的节点个数
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();//节点出队
                list.add(node.val);//节点值设置到list中
                if (node.left != null) {
                    queue.offer(node.left);//入队
                }
                if (node.right != null) {
                    queue.offer(node.right);//入队
                }
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();//返回结果
        Queue<TreeNode> queue = new ArrayDeque<>();//存放树的节点
        queue.add(root);
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);//存放根节点
        res.add(rootList);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();//BFS是从上到下一层一层的打印，levelSize表示当前层的节点个数
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();//节点出队
                if (node != null && node.left != null) {
                    queue.add(node.left);//入队
                    list.add(node.left.val);
                }
                if (node != null && node.right != null) {
                    queue.add(node.right);//入队
                    list.add(node.right.val);
                }
            }
            if (!list.isEmpty()) {
                res.add(list);
            }
        }
        return res;
    }
}
