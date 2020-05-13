package T513;

import com.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2020/5/13 9:52
 * @Description 给定一个 N 叉树，找到其最大深度。
 *
 *              最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 *              例如，给定一个 3叉树 :
 *
 *               
 *
 *
 *
 *               
 *
 *              我们应返回其最大深度，3。
 */
public class Depth {

	public static void main(String[] args) {
		Node root = new Node(3);
		System.out.println(maxDepth(root));
	}

	public static int maxDepth(Node root) {
		// DFS 递归广度优先搜索
		if (root == null) {
			return 0;
		}
		if (root.children.isEmpty()) {// 判断对象是否为空，如果为空 说明只有一个父节点
			return 1;
		} else {
			List<Integer> heights = new ArrayList<>();
			for (Node item : root.children) {
				heights.add(maxDepth(item));// 将最大高度添加到其中
			}
			return Collections.max(heights) + 1;// 根据元素的自然顺序，返回最大的元素，然后就是加上父节点
		}
	}
}
