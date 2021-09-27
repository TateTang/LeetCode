package offer;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2021/9/27 4:00 下午
 * @Description 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 */
public class Offer68I {
    public static void main(String[] args) {
        TreeNode leftRL = new TreeNode(3);
        TreeNode leftRR = new TreeNode(5);
        TreeNode leftL = new TreeNode(0);
        TreeNode leftR = new TreeNode(4, leftRL, leftRR);
        TreeNode left = new TreeNode(2, leftL, leftR);

        TreeNode rightL = new TreeNode(7);
        TreeNode rightR = new TreeNode(9);
        TreeNode right = new TreeNode(8, rightL, rightR);
        TreeNode root = new TreeNode(6, left, right);
        TreeNode.preOrderTraverse(root);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);

        System.out.println();
        System.out.println(new Offer68I().lowestCommonAncestor(root, p, q).val);
        System.out.println(new Offer68I().lowestCommonAncestor2(root, p, q).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        迭代的方法
        二叉搜索树特性：所有左子节点的值小于根节点，所有右子节点的值大于根节点
        根节点进行遍历
        - 如果当前节点的值大于p和q的值，说明p，q是在当前节点的左子树，将当前节点移动到他的左子节点
        - 如果当前节点的值小于p和q的值，说明p，q是在当前节点的右子树，将当前节点移动到他的右子节点
        - 如果当前节点的值不满足上述两条要求，那么说明当前节点就是「分岔点」。
        此时，p，q要么在当前节点的不同的子树中，要么其中一个就是当前节点
         */
        TreeNode res = root;
        while (true) {
            if (p.val < res.val && q.val < res.val) {
                res = res.left; //p，q当前节点的左子树，移动到左子节点
            } else if (p.val > res.val && q.val > res.val) {
                res = res.right; //p，q当前节点的左子树，移动到左子节点
            } else {
                break;//找到了跳出
            }
        }
        return res;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        /*
        递归操作
        - p,q都在右子树的时候，右子树递归
        - 否则 左子树递归
         */
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
