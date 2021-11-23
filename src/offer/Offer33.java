package offer;

/**
 * @Author tangmf
 * @Date 2021/11/22 5:36 下午
 * @Description 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 参考以下这颗二叉搜索树：
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 */
public class Offer33 {
    public static void main(String[] args) {
        int[] postorder = {1, 3, 2, 6, 5};
        System.out.println(new Offer33().verifyPostorder(postorder));

    }

    public boolean verifyPostorder(int[] postorder) {
        /*
        二叉搜索树：左子树的值小于根节点，右子树的值大于根节点
        后序遍历，左右根
        递归分治
        - 根据二叉搜索树的定义，可以通过递归，判断所有子树的正确性，若所有子树都正确，则此序列为二叉搜索树的后序遍历

        递归解析
            终止条件：i>=j 说明此子树节点数量<=1，无须判别正确性，因此直接返回true;
            递推工作
                1、划分左右子树，遍历后序遍历[i,j]区间元素，寻找第一个大于根节点的节点，所以记为m，
                此时，划分出左子树区间[i,m-1]，右子树区间[m,j-1]，根节点索引j
                2、判断是否为二叉搜索树
                - 左子树区间[i,m-1] 所有节点应该 < postorder[j]，而第一步划分，已经确保了左子树区间的正确性，因此只需要判断右子树就可以
                - 右子树区间[m,j-1] 所有节点 >postorder[j]，实现方式遍历，遇到<=postorder[j]跳出，通过p==j判断是否为二叉搜索树
        返回值：所有子树都需要正确才代表正确，因此使用 && 逻辑
        1、p==j :此树正确
        2、recur(i,m-1)：此树的左子树是否正确
        3、recur(m,j-1)：此树的右子树是否正确
         */
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        //left = right,说明只有一个节点，left > right说明没有节点，可以直接返回true
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
