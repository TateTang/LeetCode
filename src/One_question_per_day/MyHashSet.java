package One_question_per_day;

import java.util.Stack;

/**
 * @Author tangmf
 * @Date 2021/3/13 9:52 上午
 * @Description 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * <p>
 * 实现 MyHashSet 类：
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * 示例：
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 * 解释：
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // 返回 True
 * myHashSet.contains(3); // 返回 False ，（未找到）
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // 返回 True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // 返回 False ，（已移除
 */
public class MyHashSet {

    Stack<Integer> stack;

    public static void main(String[] args) {
        /*
         * Your MyHashSet object will be instantiated and called as such:
         * MyHashSet obj = new MyHashSet();
         * obj.add(key);
         * obj.remove(key);
         * boolean param_3 = obj.contains(key);
         */
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // 返回 True
        System.out.println(myHashSet.contains(3)); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // 返回 True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // 返回 False ，（已移除）
    }

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        stack = new Stack<>();
    }

    public void add(int key) {
        if (stack.isEmpty()){
            stack.push(key);//不包含才进行入栈
        }else {
            if (!stack.contains(key)) {
                stack.push(key);//不包含才进行入栈
            }
        }
    }

    public void remove(int key) {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        if (!stack.isEmpty()) {
            for (Integer i : stack) {
                if (i == key) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }
}
