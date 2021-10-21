package offer;

import com.TreeNode;

/**
 * @Author tangmf
 * @Date 2021/10/21 10:17 上午
 * @Description 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 例如:
 * 给定的树 A:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 */
public class Offer26 {
    public static void main(String[] args) {
        TreeNode leftA = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        TreeNode A = new TreeNode(3, leftA, new TreeNode(5));
        TreeNode B = new TreeNode(4);
        B.left = new TreeNode(1);
        System.out.println(new Offer26().isSubStructure(A, B));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        /*
        解题思路，B是A的子结构，则子结构的根节点可能为树A的任意一个节点，因此，判断树A的子结构，需完成一下两部工作
        1、先序遍历A中的每个节点Na（对应函数isSubStructure(A,B)）
        2、判断书中A以Na为根节点的子树，是否包含树B （对应函数 recur(A,B)）
            - isSubStructure(A,B) 遍历树A，先访问到树节点A
            - recur(A,B)判断树A包含树B
        算法流程：
        名词规定：树A的根节点记作节点A，树B的根节点称为节点B
        recur(A,B)函数
        1、终止条件：
            - 当节点B为空，说明B匹配完成（越过叶子节点），返回true
            - 当节点A为空，说明已经越过树A叶子节点，匹配失败，返回false
            - 当节点A 和 B 的值不相同的时候，说明不匹配，返回false
        2、返回值：
            - 判断A和B的左子节点是否相等，recur(A.left,B.left)
            - 判断A和B的右子节点是否相等，recur(A.right,B.right)

        isSubStructure(A,B)函数：
        1、特例处理：当树A 为空 或者树B为空，直接返回false
        2、返回值：若树B是树A的子结构，必须满足一下三种情况之一，因此用或||连接
            -1.以节点A为根节点的子树包含树B ，对应recur(A,B)
            -2.树B是 树A左子树的子结构，对应isSubStructure(A.left,B)
            -3.树B是 树A右子树的子结构，对应isSubStructure(A.right,B)
            前面2,3是在对树A进行先序遍历，根 左 右
         */
        return (A != null && B != null) && (recur(A, B) ||
                isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;//B匹配完成，返回true
        if (A == null || A.val != B.val) return false;//说明已经越过树A叶子节点，匹配失败
        //判断A B 的左子节点和右子节点是否相等
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
