package Stack.T912;

/**
 * @Author tangmf
 * @Date 2020/9/12 10:57
 * @Description 331. 验证二叉树的前序序列化
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * <p>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 * 示例 1:
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 * 输入: "1,#"
 * 输出: false
 * 示例 3:
 * 输入: "9,#,#,1"
 * 输出: false
 */
public class T331 {
    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(isValidSerialization1(preorder));
    }

    //前序；根--左--右，不重构树的情况下，#表示null
    public static boolean isValidSerialization(String preorder) {
        /*
        方法一：迭代
        槽位：二叉树中任意一个节点或者空孩子节点都要占据一个槽位。
        二叉树的建立也伴随着槽位数量的变化，开始只有一个槽位，如果根节点是空节点，就消耗一个槽位，
        如果根节点不是空节点，出了要消耗一个槽位，还要为之后的子节点增加两个新的槽位，之后的节点也是同理。
        1、开始时一个槽位
        2、空节点和非空节点都需要消耗一个槽位
        3、空节点不增加槽位，非空节点增加两个新的槽位
        算法：
        1、初始化可用槽位：slots=1；
        2、根据逗号分割处理，将结果数组存储，随后遍历数组：
            2.1、空节点和非空节点都消耗一个槽位  slots = slots-1
            2.2、如果当前槽位是负数，说明是非法的，返回false
            2.3、非空节点新增两个可用槽位 if(null!='#') slots +=2;
        3、如果所有槽位消耗完，那么这个前序序列化是合法的，返回slots == 0
        时间复杂度：O(N)，其中 N 为字符串的长度。
        空间复杂度：O(N)。
         */
        int slots = 1;
        for (String node : preorder.split(",")) {
            //非空节点和空节点都消耗一个槽位
            --slots;
            if (slots < 0) {
                return false;//非法直接返回
            }
            if (!node.equals("#")) {
                slots += 2; //非空节点 新增两个槽位
            }
        }
        return slots == 0;
    }

    public static boolean isValidSerialization1(String preorder) {
        /*
        方法二：一遍过
        方法一需要用到O(N) 的空间来存储前序序列化分割之后的结果数组，但我们可以直接遍历前序序列化字符串，
        省去了通过字符串来存储变量的空间这样就不用开辟额外空间了。
        在遍历过程中，每遇到逗号符号就更新可用槽位的数量。首先，将槽位减1，其次非空节点，新增两个槽位。
        注意：最后一个节点需要单独处理，因为最后一个节点后面没有逗号
        算法：
        1、初始化可用槽位为 1：slots = 1。
        2、遍历前序序列化字符串，每遍历到逗号字符
            2.1、空节点和非空节点都消耗一个槽位  slots = slots-1
            2.2、如果当前槽位是负数，说明是非法的，返回false
            2.3、非空节点（即逗号字符前不是 #），新增两个可用槽位 if(null!='#') slots +=2;
        3、最后一个节点需要单独处理，因为最后一个节点后面没有逗号的。
        4、如果可用槽位全部被消耗完，那么该前序序列化就是合法的：返回 slots == 0
        时间复杂度：O(N)，其中 N 为字符串的长度。
        空间复杂度：O(1)，只占用常数空间。
         */
        int slots = 1;
        int n = preorder.length();
        for (int i = 0; i < n; i++) {
            if (preorder.charAt(i) == ',') {
                //非空节点和空节点都消耗一个槽位
                --slots;
                if (slots < 0) {
                    return false;//非法直接返回
                }
                if (preorder.charAt(i - 1) != '#') {
                    slots += 2; //非空节点 新增两个槽位
                }
            }
        }
        //最后一个节点单独处理为# 也就是空节点 减1，否则+1
        slots = (preorder.charAt(n - 1) == '#') ? slots - 1 : slots + 1;
        return slots == 0;
    }
}
