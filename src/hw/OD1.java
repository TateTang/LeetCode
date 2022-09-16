package hw;

import java.util.*;

/**
 * @author tangmf
 * @date 2022年09月16日 15:16:​24
 * 某学校举行运动会，学生们按编号(1、2、3。。n)进行标识，现需要按照身高由低到高排列，对身高相同的人，按体重由轻到重排列；
 * 对于身高体重都相同的人，维持原有的编号顺序关系。请输出排列后的学生编号。
 * 4
 * 100 100 120 130 身高
 * 40 30 60 50 体重
 */
public class OD1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //个数标识
        int n = sc.nextInt();
        // 两个集合存储学生体重和身高map，插入排序先,list 两个值 身高：下标0，体重：   下标1，序号：下标 2
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        // 为身高 体重map 赋值
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(sc.nextInt());
            map.put(i, list);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.get(i);
            list.add(sc.nextInt());
            list.add(i + 1);//序号
            map.put(i, list);
        }
        compare(map);
        //输出序号
        map.keySet().forEach(x -> System.out.print(map.get(x).get(2) + " "));
    }

    public static void compare(Map<Integer, List<Integer>> map) {
        // 遍历进行判断，冒泡排序，判断其中每一个的值的比较
        int heightIndex = 0;
        int weightIndex = 1;
        for (int i = 0; i < map.size() - 1; i++) {
            for (int j = 0; j < map.size() - i - 1; j++) {
                // 条件：身高比较低->高；身高相同 体重低->高，都相同，维持原来的
                if (map.get(j).get(heightIndex) > map.get(j + 1).get(heightIndex)) {
                    // 身高 低->高，进行交换
                    List<Integer> tempList = map.get(j);
                    map.put(j, map.get(j + 1));
                    map.put(j + 1, tempList);
                } else if (map.get(j).get(heightIndex).equals(map.get(j + 1).get(heightIndex))) {
                    if (map.get(j).get(weightIndex) > map.get(j + 1).get(weightIndex)) {
                        // 相等，体重低->高，交换
                        List<Integer> tempList = map.get(j);
                        map.put(j, map.get(j + 1));
                        map.put(j + 1, tempList);
                    }
                }
            }
        }
    }
}
