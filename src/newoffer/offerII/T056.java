package newoffer.offerII;

import com.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author tangmf
 * @date 2022年09月06日 09:07:​39
 * 剑指 Offer II 056. 二叉搜索树中两个节点之和
 * 给定一个二叉搜索树的 根节点 root 和一个整数 k ,
 * 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
 * 示例 1：
 * 输入: root = [8,6,10,5,7,9,11], k = 12
 * 输出: true
 * 解释: 节点 5 和节点 7 之和等于 12
 * 示例 2：
 * 输入: root = [8,6,10,5,7,9,11], k = 22
 * 输出: false
 * 解释: 不存在两个节点值之和为 22 的节点
 */
public class T056 {
    Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        TreeNode leftNode = new TreeNode(6);
        TreeNode rightNode = new TreeNode(10);
        treeNode.left = leftNode;
        treeNode.right = rightNode;
        leftNode.left = new TreeNode(5);
        leftNode.right = new TreeNode(7);
        rightNode.left = new TreeNode(9);
        rightNode.right = new TreeNode(11);
        TreeNode.inOrderTraverse(treeNode);
        int k = 7;
        System.out.println(new T056().findTarget(treeNode, k));
    }

    public boolean findTarget(TreeNode root, int k) {
        /*
        中序遍历就是排好序的，二叉搜索树：左 < 根；根<右
        深度优先搜索 + 中序遍历 + 双指针
        时间复杂度：O(n)
        空间复杂度：O(n)
         */
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        // 双指针解法，left：左指针，right：右指针
        int left = 0, right = res.size() - 1;
        while (left < right) {
            int sum = res.get(left) + res.get(right);
            if (sum < k) {
                // 需要加值，左指针向右边移动
                left++;
            } else if (sum > k) {
                // 需要减值，右指针向左移动
                right--;
            } else {
                return true;
            }
        }
        return false;
    }


    /**
     * 中序遍历，结果保存到一个list 中
     *
     * @param root root
     * @param res  res
     */
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public boolean findTarget1(TreeNode root, int k) {
        /*
        深度优先搜索 + 哈希表：我们可以使用深度优先搜索的方式遍历整棵树，用哈希表记录遍历过的节点的值。
        1.对于一个值为 x 的节点，检查哈希表中是否存在k-x即可，如果存在对应的元素，
        2.那么就可以在该树上找到两个节点的和为k；否则，将 x 放入到哈希表中
        3.如果遍历完整树后都不存在对应的元素，那么该树上不存在两个和为k的节点
        时间复杂度：O(n)
        空间复杂度：O(n)
         */
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            // 存在，就是代表有返回即可
            return true;
        }
        //否则加入，进行遍历，包括左子树，右子树
        set.add(root.val);
        return findTarget1(root.left, k) || findTarget(root.right, k);
    }
}
