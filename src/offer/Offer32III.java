package offer;

import com.TreeNode;

import java.util.*;

/**
 * @Author tangmf
 * @Date 2021/11/20 4:17 下午
 * @Description 剑指 Offer 32 - III. 从上到下打印二叉树 III 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
 * [20,9],
 * [15,7]
 * ]
 */
public class Offer32III {
    public static void main(String[] args) {
        TreeNode leftNode = new TreeNode(9);
        TreeNode rightNode = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, leftNode, rightNode);
        TreeNode.inOrderTraverse(root);
        System.out.println(new Offer32III().levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();//定义list作为返回
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();//定一个一个队列，存储树的节点
        queue.offer(root);//入队
        while (!queue.isEmpty()) {
            int levelSize = queue.size();//bfs一层一层从上往下搜索，每一层的数量
            LinkedList<Integer> list = new LinkedList<>();//存储每一层的值，使用链表存储,作为双端队列使用
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                // 每加入一层就会多一个[]，总的list的size就会+1.，0%2==0 1%2==1 2%2== 0直接判断结果中的个数即可，
                if (res.size() % 2 == 0) {
                    list.addLast(node.val);//偶数层-->，需要顺序打印，队列尾部部
                } else {
                    list.addFirst(node.val);//奇数层-->，需要反序打印，队列头部
                }
                if (node.left != null) queue.offer(node.left);//左子节点入队
                if (node.right != null) queue.offer(node.right);//右子节点入队
            }
            res.add(list);
        }
        return res;
    }
}
