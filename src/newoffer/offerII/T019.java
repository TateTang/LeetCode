package newoffer.offerII;

/**
 * @author tangmf
 * @date 2022年09月02日 10:08:​31
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 * 示例 1:
 * 输入: s = "aba"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 * <p>
 * 示例 3:
 * 输入: s = "abc"
 * 输出: false
 */
public class T019 {
    public static void main(String[] args) {
        String s = "abca";
        System.out.println(new T019().validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
         /*
        判断回文串显然用双指针，left 前->后遍历；right 后->前 遍历。难点：如何判断删除一个元素后是否是回文字符串
        - 以 'abdda'例子,left 指向 'b',j指向'd'，不对，又有一次删除机会，写几个case 发现，子串范围为
        (i+1,j) 或 (i,j-1)的两个只要有一个是回文串，则结果就是回文串，否则就不是
         */
        // 左右指针
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // 其中一个是回文串即可
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            //指针移动
            left++;
            right--;
        }
        return true;
    }

    /**
     * 是否是回文字符串
     *
     * @param s     字符串
     * @param left  左指针
     * @param right 右指针
     * @return false or true
     */
    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            //左指针++；右指针--
            left++;
            right--;
        }
        return true;
    }
}
