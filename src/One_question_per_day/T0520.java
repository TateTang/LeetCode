package One_question_per_day;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author tangmf
 * @Date 2021/5/20 10:07 上午
 * @Description 692. 前K个高频单词 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * 示例 2：
 * <p>
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 */
public class T0520 {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(new T0520().topKFrequent(words, k));
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();//定义一个hash 来存储符串数组中每个字符串出现的次数
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);//直接统计次数
        }
        /*需要按出现的次数和首字母大小，对字符串进行排序，这里将map.entrySet()转换成list，
         再用collections工具类中的sort()方法完成排序操作*/
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> {
            int t = -o1.getValue().compareTo(o2.getValue());//降序
            //若传入的数据的value相同的时候，需要根据key来进行排序
            if (t == 0)
                return o1.getKey().compareTo(o2.getKey());
            return t;
        });
        entryList.stream().limit(k).collect(Collectors.toList())
                .forEach(m -> list.add(m.getKey()));//通过stream流返回前k个出现的字符串
        return list;
    }
}
