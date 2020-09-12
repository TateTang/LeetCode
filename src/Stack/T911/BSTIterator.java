package Stack.T911;

import com.TreeNode;

import java.util.LinkedList;

/**
 * @Author tangmf
 * @Date 2020/9/11 9:44
 * @Description 173. 二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * <p>
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * 示例：
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 * <p>
 * 提示：
 * <p>
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 * 左-根-右 中序遍历
 */
public class BSTIterator {
    /*
    二叉搜索树，迭代器以升序返回元素，重要特性：二叉搜索树的中序序列是升序序列，因此，中序遍历是解决方案的核心
    扁平化二叉搜索树，使用额外的数组，并将二叉搜索树展开存放到里面。我们想要的数组的元素an升序排序，则对二叉搜索树中序遍历，然后在数组中构建迭代器函数
    1、初始化空数组来存放二叉搜索树的中序遍历
    2、按照中序遍历二叉搜索树，按照左-根-右的顺序处理节点
    3、一旦所有的节点都在数组中，我们只需要一个指针或者索引来实现next() 和 hasnext()。每当调用hasNext的饿时候
    4、只需要检查索引是否达到数组末尾，每当调用next()的时候，只需要返回索引指向的元素，并且向前移动一步，模拟迭代器的进度
     */
    private LinkedList<Integer> nodeSorted = new LinkedList<>();
    private int size;//变量size，记录目前容器中元素的个数,输出时需要减一，通过size 判断是否还有元素

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(7);
        TreeNode leftNode = new TreeNode(3);
        TreeNode rightNode = new TreeNode(15);
        treeNode.left = leftNode;
        treeNode.right = rightNode;
        rightNode.left = new TreeNode(9);
        rightNode.right = new TreeNode(20);
        BSTIterator iterator = new BSTIterator(treeNode);
        System.out.println(iterator.next());   // 返回 3
        System.out.println(iterator.next());    // 返回 7
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());  // 返回 9
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next()); // 返回 15
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());     // 返回 20
        System.out.println(iterator.hasNext()); // 返回 false
    }

    public BSTIterator(TreeNode root) {
        infix(root);
        size = nodeSorted.size();
    }

    //中序遍历 左-根-右
    private void infix(TreeNode root) {
        if (root == null) {
            return;
        }
        infix(root.left);// 遍历左子树
        nodeSorted.add(root.val);
        infix(root.right);// 遍历右子树
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        size--;//输出时，需要减一。
        return nodeSorted.pollFirst();//获取并移除此列表的第一个元素，或者返回null ，如果此列表为空
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return size > 0;
    }

    /*
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
}
