package offer;

import com.TreeNode;

import java.util.*;

/**
 * @Author tangmf
 * @Date 2021/8/17 10:25 上午
 * @Description 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * [3,9,20,15,7]
 */
public class Offer32I {
    public static void main(String[] args) {
        TreeNode leftNode = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode rightNode = new TreeNode(3);
        TreeNode root = new TreeNode(1, leftNode, rightNode);
        TreeNode.preOrderTraverse(root);
        System.out.println(Arrays.toString(new Offer32I().levelOrder(root)));
    }

    public int[] levelOrder(TreeNode root) {
        /*
        广度优先搜索
         */
        //List<Integer> list = new ArrayList<>();
        //bfs(root, list);
        ////就得先转成IntStream。这里就通过mapToInt()把Stream<Integer>调用Integer::valueOf来转成IntStream
        ////而IntStream中默认toArray()转成int[]。
        //return list.stream().mapToInt(Integer::valueOf).toArray();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new ArrayDeque<>();//存放树的节点
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();//节点弹出
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);//左节点入队
            }
            if (node.right != null) {
                queue.offer(node.right);//右节点入队
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}

