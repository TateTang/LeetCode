package One_question_per_day;

/**
 * @Author tangmf
 * @Date 2021/4/20 10:09 上午
 * @Description 28. 实现 strStr()
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
 * 这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 */
public class T0420 {
    public static void main(String[] args) {
        String haystack = "heoll";
        String needle = "ll";
        System.out.println(strStr2(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        /*
        在 haystack 字符串中找出 needle 字符串出现的第一个位置
        直接解法
         */
        if (needle.length() == 0) {
            return 0;
        }
        return haystack.indexOf(needle);
    }

    public static int strStr1(String haystack, String needle) {
        /*
        在 haystack 字符串中找出 needle 字符串出现的第一个位置
        双指针解法：定义两个指针i，j分别指向haystack的开头和needle的开头
        开始遍历
         - 若当前两个指针指向的字符相同，则两个指针都向右移动一次
         - 字符不同，则说明当前i遍历过的子字符串（从两个指针指向字符第一次相等开始到当前位置所构成的子字符串）
         与字符串needle并不相同，此时需要将 j 指针重新指向字符串needle的开头，j=0；并且i指针往前移动到之前
         两个字符串第一次字符相同的位置的下一个位置，i=i-j，继续遍历两个字符串
         - 若j==needle.length，则返回i+1-needle.length()这个位置就是字符串needle在字符串haystack开始的位置
         因为此时i指针没有右移，只是将j指针右移了一位，所以为了得到起始位置；应该从i指针的下一个位置开始-字符串needle的长度，就是起始位置
         */
        int h = haystack.length();
        int n = needle.length();
        if (n == 0) return 0;
        if (n > h) return -1;
        int i = 0, j = 0;
        for (; i < h; i++) {
            if (j < n && haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {
                i = i - j;
                j = 0;
            }
            if (j == n) {
                return i + 1 - n;// 先将 i 指针右移，再减去字符串 needle 的长度，即为起始位置
            }
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        /*
            i s s i p  <- needle
            m i s s i s s i p p i  <- haystack
            ^(×)
            m i s s i s s i p p i
              ^ ^ ^ ^ ^(×)
            m i s s i s s i p p i
                ^(×)
            m i s s i s s i p p i
                  ^(×)
            m i s s i s s i p p i
                    ^ ^ ^ ^ ^      ✅
        在 haystack 字符串中找出 needle 字符串出现的第一个位置
        双指针解法2：
        思路：
        将needle目标字符串依次与字符串haystack长度为needle的字串比较，完全相同返回字串的数组下标
        - 一个指针用于遍历，遍历次数为 haystack 多余长度 + 1；
        - 一个指针用于依次比较是否与 needle 每一个字符相同
        时间复杂度：O(M) = O(M-N) + O(N)？
        空间复杂度：O(1)
         */
        int hLen = haystack.length(), nLen = needle.length();
        //等于，适用于两者长度相等的情况下
        for (int i = 0; i <= hLen - nLen; i++) {
            int j = 0;
            for (; j < nLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == nLen) {
                return i;
            }
        }
        return -1;
    }

}
