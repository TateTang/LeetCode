package offer;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2021/9/28 9:07 下午
 * @Description 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 */
public class Offer68II {
    public static void main(String[] args) {
        TreeNode leftRL = new TreeNode(7);
        TreeNode leftRR = new TreeNode(4);
        TreeNode leftL = new TreeNode(6);
        TreeNode leftR = new TreeNode(2, leftRL, leftRR);
        TreeNode left = new TreeNode(5, leftL, leftR);

        TreeNode rightL = new TreeNode(0);
        TreeNode rightR = new TreeNode(8);
        TreeNode right = new TreeNode(1, rightL, rightR);
        TreeNode root = new TreeNode(3, left, right);
        TreeNode.preOrderTraverse(root);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);

        System.out.println();
        System.out.println(new Offer68II().lowestCommonAncestor(root, p, q));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        二叉树
       最近公共祖先定义：
        对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
        满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）
        节点root是p，q的某公共祖先，若左子节点root.left和右子节点root.right都不是p,q的公共祖先，称root是"最近公共祖先"
        root是p，q的最近公共祖先，只可能为下面情况之一
        - p,q root的子树中，分别在左右子树中
        - p=root，且q在root的左或右子树中
        - q=root，且p在root的左或右子树中
        节点7的祖先：3 5 2 7
        p=7 q= 8 3 是7 8 的公共祖先，5不是8的祖先，1不是7的祖先，所以3是7 8的最近公共祖先

        递归对二叉树进行先序遍历，遇到节点p，q返回，从底至顶回溯，当节点p，q在节点root的不同侧的时候，节点root就是
        最近公共祖先，向上直接返回root即可
        1、递归终止条件
        - 当越过叶节点，则直接返回null
        - 当root等于p，q，直接返回root
        2、递推工作
        - 开启递归左子节点，返回值为left；
        - 开启递归右子节点，返回值为right；
        3、返回值：根据left和right，四种情况
        - left right 同时为空：说明root的左/右子树 都不包含p,q，返回null
        - left right 同时不为空：说明p,q在root的不同侧（分别左右子树），root为最近公共祖先，返回root
        - left为空，right不为空：p,q都不在root的左子树中，直接返回right
         - p，q其中一个在root的右子树中，此时right指向p；
         - p，q两节点都在root的右子树中，此时的ritht指向 最近公共祖先节点
        - 当left 不为空，right为空：上面同理，p,q都不在root的左子树中，直接返回left
         - p，q其中一个在root的左子树中，此时left指向p；
         - p，q两节点都在root的左子树中，此时的left指向 最近公共祖先节点
         */
        if (root == null || root == p || root == q) return root;//递归终止条件
        TreeNode left = lowestCommonAncestor(root.left, p, q);//递归左子节点
        TreeNode right = lowestCommonAncestor(root.right, p, q);//递归右子节点
        if (left == null && right == null) return null;//同时空的时候，都不包含p，q 返回null
        if (left == null) return right;//left空，right 不空，返回右子节点
        if (right == null) return left;//right空，left不空，返回左子节点
        return root;//都不为空的时候，在不同侧，直接返回root
    }
}
