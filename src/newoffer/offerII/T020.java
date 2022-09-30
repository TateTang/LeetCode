package newoffer.offerII;

/**
 * @author tangmf
 * @date 2022年09月29日 09:52:​03
 * 剑指 Offer II 020. 回文子字符串的个数
 * 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的
 * 字符组成，也会被视作不同的子串。
 * 示例 1：
 * <p>
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class T020 {
    public static void main(String[] args) {
        //String s = "abc";
        String s = "aaa";
        System.out.println(new T020().countSubstrings1(s));
    }

    public int countSubstrings(String s) {
        /*
        多少个回文子串：枚举法
            - 枚举出所有的子串，然后再判断这些子串是否是回文；
            - 枚举每一个可能的回文中心，然后用两个指针分别向左右两边拓展，当两个指针指向的元素相同的时候就拓展，否则停止拓展。
        中心搜索法：遍历每一种可能的中心，再从该中心尝试向外扩张，成功扩张则累计
        两种情况
        1.奇数长区间的单点中心
        2.偶数长区间的双点中国女性
        发现最多 2n-1个子区间，并且区间的奇偶性是交替变换的，其中区间长度为奇数为单核心，偶数为双核心
        单核心：left right 起始指向同一个节点，双核心则指向两个相邻节点
         */
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < (2 * len - 1); i++) {
            int left = i / 2, right = i / 2 + i % 2;
            //当子区间范围未超过len 并且区间两端点字符相同，才进行扩张
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                //扩张，同时回文子串+1
                left--;
                right++;
                ans++;
            }

        }
        return ans;
    }

    public int countSubstrings1(String s) {
        //直接暴力枚举获取
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // 回文串长度为奇数 + 回文串长度为偶数
            res += countSubstrings(s, i, i) + countSubstrings(s, i, i + 1);
        }
        return res;
    }

    private int countSubstrings(String s, int left, int right) {
        int count = 0;
        //当子区间范围未超过len 并且区间两端点字符相同，才进行扩张
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}
