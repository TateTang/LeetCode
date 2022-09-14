package newoffer.offerII;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author tangmf
 * @date 2022年09月14日 08:27:​39
 * 剑指 Offer II 059. 数据流的第 K 大数值
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * <p>
 * 请实现 KthLargest 类：
 * <p>
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 */
public class T059 {
    int k;
    List<Integer> list;
    PriorityQueue<Integer> pq;//优先队列

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        int k = 3;
        T059 obj = new T059(k, nums);
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }

    //public T059(int k, int[] nums) {
    //    this.k = k;
    //    list = Arrays.stream(nums).boxed().collect(Collectors.toList());
    //}
    //
    //public int add(int val) {
    //    list.add(val);
    //    Collections.sort(list);
    //    return list.get(list.size() - k);
    //}



    public T059(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        /*
        我们可以使用一个大小为 k 的优先队列来存储前 k 大的元素，其中优先队列的队头为队列中最小的元素，也就是第 k 大的元素。
        在单次插入的操作中，我们首先将元素 val 加入到优先队列中。如果此时优先队列的大小大于 k，
        我们需要将优先队列的队头元素弹出，以保证优先队列的大小为 k。
        */
        pq.offer(val);//入队
        if (pq.size() > k) {
            // 优先队列中的大小数大于k，需要弹出当前值，永远保证队列的队头是第k大元素
            pq.poll();
        }
        //获取第k大的值
        return pq.peek();
    }
}
