package newoffer.offerII;

import java.util.*;

/**
 * @author tangmf
 * @date 2022年09月10日 08:51:​29
 * 剑指 Offer II 075. 数组相对排序
 * 给定两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * 提示：
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class T075 {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(new T075().relativeSortArray(arr1, arr2)));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // arr1中各个值出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new ArrayList<>();
        //按照arr2顺序填写arr1
        for (int i : arr2) {
            for (int j = 0; j < map.get(i); j++) {
                list1.add(i);
            }
        }
        //将剩下的数添加到 list并且排序
        for (int i : arr1) {
            if (!list1.contains(i)) {
                list2.add(i);
            }
        }
        Collections.sort(list2);
        list1.addAll(list2);
        int[] res = new int[arr1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = list1.get(i);
        }
        System.out.println(map);
        System.out.println(list2);
        System.out.println(list1);
        return res;
    }
}
