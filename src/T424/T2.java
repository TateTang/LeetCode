package T424;

import com.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author tangmf
 * @Date 2020/4/24 10:52
 * @Description
 *
 * 				给定一个 N 叉树，返回其节点值的后序遍历。
 *
 *              例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 *              返回其后序遍历: [5,6,3,2,4,1].
 */
public class T2 {

	public static void main(String[] args) {
		Node node = new Node(5);
		System.out.println(postorder(node));
	}

	private static List<Integer> postorder(Node root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return null;
		}
        while (root!=null){
//            list = root.children;
        }
		return null;
	}
}
