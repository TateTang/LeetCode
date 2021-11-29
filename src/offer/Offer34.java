package offer;

import com.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2021/11/29 11:28 上午
 * @Description 剑指 Offer 34. 二叉树中和为某一值的路径
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * <p>
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 */
public class Offer34 {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode leftNode = new TreeNode(4);
        TreeNode rightNode = new TreeNode(8);
        leftNode.left = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        rightNode.left = new TreeNode(13);
        rightNode.right = new TreeNode(4, new TreeNode(5), new TreeNode(1));
        TreeNode root = new TreeNode(5, leftNode, rightNode);
        TreeNode.preOrderTraverse(root);
        int target = 22;
        System.out.println(new Offer34().pathSum(root, target));
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        /*
         * 典型的二叉树方案搜索问题，使用回溯法解决，包含 先序遍历+路径记录两部分
         * - 先序遍历：按照 根 左 右 顺序，遍历树的所有节点
         * - 路径记录：先序遍历中，记录从根节点到当前节点的路径。当路径为 1：根节点到叶节点形成，
         * 且 2：各节点值的和等于目标值 sum 时，将此路径加入结果列表。
         * 题目定义：从树的根节点开始往下一直到叶节点所经过的节点形成一条路径
         *
         * 算法流程：
         * pathSum(root,sum)函数
         * - 初始化：结果列表res，路径列表path
         * - 返回值：返回res即可
         *
         * recur(root,target)函数
         * - 递推参数：当前节点root，当前目标值target
         * - 终止条件：若节点root为空，则直接返回
         * - 递推工作：
         *  1.路径更新：当前节点值root.val加入路径path列表
         *  2.目标值更新：target = target-root.val（目标值target从sum减至0）
         *  3.路径记录：当 1 root为叶节点 且 2路径和等于目标值，则将次路径path加入res
         *  4.先序遍历：递归左/右 子节点
         *  5.路径恢复：向上回溯前，需要将当前节点从路径path中删除，即执行path.removeLast()
         */
        recur(root, target);
        return res;
    }

    public void recur(TreeNode root, int target) {
        if (root == null) return;
        path.add(root.val);// 路径更新，当前节点值加入路径path列表
        target = target - root.val;//目标值更新
        if (target == 0 && root.left == null && root.right == null) {
            //得注意的是，记录路径时若直接执行res.add(path) ，则是将 path 对象加入了 res后续 path 改变时，
            // res 中的 path 对象也会随之改变。res.add(new LinkedList<>(path)) ，相当于复制了一个 path 并加入到 res 。
            res.add(new LinkedList<>(path));//路径path加入res
        }
        recur(root.left, target);//递归左子树
        recur(root.right, target);//递归右子树
        path.removeLast();//向上回溯前，需要将当前节点从路径path中删除，删除并返回此列表中的最后一个元素
    }
}
