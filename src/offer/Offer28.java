package offer;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2021/8/10 2:10 下午
 * @Description 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class Offer28 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(2);
        node.left = leftNode;
        node.right = rightNode;
        leftNode.left = new TreeNode(3);
        leftNode.right = new TreeNode(4);
        rightNode.left = new TreeNode(4);
        rightNode.right = new TreeNode(3);
        TreeNode.preOrderTraverse(node);
        System.out.println(new Offer28().isSymmetric(node));
    }

    public boolean isSymmetric(TreeNode root) {
        /*
         * 1、对称二叉树定义：对于树中 任意两个对称节点L和R，一定有
         * - L.val = R.val 两对称节点值相等
         * - L.left.val = R.right.val： L的左子节点 和R的右子节点对称
         * - L.right.val = L.left.val   L的右子节点 和 R的左子节点对称
         * 2、根据规则，从顶到底递归，判断每一对节点是否为对称二叉树
         * 3、算法流程
         *  - 根节点为空，直接返回true，
         * recur(L,R)
         * 终止条件
         * - 当L和R同时越过叶节点：此树从顶至底的节点都对称，因此返回true
         * - 当L或R中只有一个越过叶节点：此树不对称，因此返回fasle
         * - 当节点L！= 节点R：不对称，直接返回fasle
         * 递推工作
         * - 判断L.left 和 R.right是否堆成，就是recur(L.left,R.right)
         * - 判断L.right 和 R.left是否堆成，就是recur(L.right,R.left)
         * 返回值
         * - 两对节点都对称的时候，才是对称树，因此有&&
         */
        return root == null || recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true; //都为空直接返回ture
        if (L == null || R == null || L.val != R.val) return false; //一个不成立 直接返回false
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
