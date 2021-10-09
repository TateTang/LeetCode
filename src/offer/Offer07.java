package offer;

import com.TreeNode;

import java.util.HashMap;

/**
 * @Author tangmf
 * @Date 2021/10/8 2:36 下午
 * @Description 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
public class Offer07 {
    HashMap<Integer, Integer> map = new HashMap<>();//标记中序遍历，存储中序遍历的值与索引的映射
    int[] preorder;//保留的先序遍历，方便递归的时候依据索引查看先序遍历的值

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(new Offer07().buildTree(preorder, inorder));

        TreeNode.inOrderTraverse(new Offer07().buildTree(preorder, inorder));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        前序：根 [左] [右] 中序：[左] 根 [右]，
        例子：前序遍历 [3 | 9| 20 15 7]，中序 [9 | 3 | 15 20 7]
        根据以上可以得出如下结论
        - 前序遍历的首元素就是树的根节点node的值
        - 在中序遍历中搜索跟节点 node 的索引，将中序遍历划分为[左子树 ｜ 根节点 ｜ 右子树]
        - 根据中序遍历中的 左右子树的节点数量，将 前序遍历划分为 [根节点 ｜ 左子树 ｜ 右子树]
        通过上面的三个步骤，可以确定三个节点
        - 树的根节点 3
        - 左子树的根节点 9
        - 右子树的根节点 20
        根据【分治算法】思想，对于树的左右子树，仍可以用以上方法划分子树的左右子树，这就是分治

        分治算法解析
        - 递推参数：根节点在前序遍历的索引root、子树在中序遍历的左边界left，子树在中序遍历的右边界right
        - 终止条件：left > right 时候，代表已经越过叶节点，此时返回null
        - 递推工作
          - 建立根节点node：节点值为preorder[root]
          - 划分左右子树：查找根节点在中序遍历 inorder 中的索引i；用哈希表存储中序遍历的值与索引的映射
          - 构建左右子树：开启左右子树递归
                     根节点索引           中序遍历左边界   中序遍历右边界
          左子树       root+1              left         i-1
          右子树       i-left+root+1       i+1             right
          TIPS： i-left+root+1 含义为：【根节点索引+1+左子树长度】
        “i - left + root + 1”，其实就是右子树根节点=(中序根节点坐标-中序左边界）+先序根节点坐标+1，其中括号内=左子树长度
        先序遍历 根 [左] [右] ，左子树的长度 + 先序根节点左边+1 就到了右子树的根节点了【因为这个是在先序遍历中的，遵循 根 左 右的遍历】
        - 返回值：回溯返回node，作为上一层递归中根节点的左/右子节点
         */
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);//将中序遍历的值与索引放在map中，方便递归时获取左子树与右子树的数量及其根的索引
        }
        return recur(0, 0, inorder.length - 1);
    }

    /**
     * @param root  当前根的索引
     * @param left  递归树的左边界，即数组左边界
     * @param right 递归树的右边界，即数组右边界
     */
    public TreeNode recur(int root, int left, int right) {
        if (left > right) return null;//递归终止条件
        TreeNode node = new TreeNode(preorder[root]);//建立根节点，就是节点值为preorder[root]
        int i = map.get(preorder[root]);//划分根节点、左右子树，找根节点在中序遍历 inorder 中的索引i
        //开启左子树递归，左子树的根的索引为【先序中的根节点+1】 ，左边界为【原来的中序索引left】，右边界【中序中的根节点索引-1】
        node.left = recur(root + 1, left, i - 1);
        //开启右子树递归，右子树的根的索引为【先序中的当前根位置 + 左子树的数量 + 1】，左边界【中序中当前根节点+1】，右边界【原来的右子树边界】
        node.right = recur(i - left + root + 1, i + 1, right);
        //“i - left + root + 1”，其实就是右子树根节点=(中序根节点坐标-中序左边界）+先序根节点坐标+1，其中括号内=左子树长度
        return node;//回溯返回根节点
    }
}
