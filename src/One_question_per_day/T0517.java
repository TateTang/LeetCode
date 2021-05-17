package One_question_per_day;

import com.TreeNode;

import java.util.*;

/**
 * @Author tangmf
 * @Date 2021/5/17 10:04 上午
 * @Description 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * 示例 1：
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 */
public class T0517 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, null, new TreeNode(4));
        root.right = new TreeNode(3,null, new TreeNode(5));
        int x = 5;
        int y = 4;
        TreeNode.preOrderTraverse(root);
        System.out.println(new T0517().isCousins(root, x, y));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new ArrayDeque<>();//存放树的节点
        Queue<Integer> value = new LinkedList<>();//存放节点对应的值
        if (root != null) {
            queue.add(root);
            value.add(root.val);
        }
        //BFS 遍历使用队列数据结构;如果队列不为空，说明树的节点没有遍历完，就继续遍历
        while (!queue.isEmpty()) {
            int levelSize = queue.size();//BFS是从上到下一层一层的打印，levelSize表示当前层的节点个数
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();//节点和节点值同时出队
                value.poll();
                //首先判断x和y是否是兄弟节点的值，也就是判断他们的父节点是否是同一个，是同一个直接返回false
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) ||
                            (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }
                //左子节点不为空加入到队列中
                if (node.left != null) {
                    queue.add(node.left);
                    value.add(node.left.val);
                }
                //右子节点不为空加入到队列中
                if (node.right != null) {
                    queue.add(node.right);
                    value.add(node.right.val);
                }
            }
            //判断当前层是否包含这两个节点的值，如果包含就是堂兄弟节点
            if (value.contains(x) && value.contains(y)) {
                return true;
            }
        }
        return false;
    }
}
