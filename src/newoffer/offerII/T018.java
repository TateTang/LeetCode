package newoffer.offerII;

/**
 * @author tangmf
 * @date 2022年09月02日 10:08:​05
 * 剑指 Offer II 018. 有效的回文
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 * 本题中，将空字符串定义为有效的回文串 。
 * 示例 1:
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * <p>
 * 示例 2:
 * 输入: s = "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * 提示：
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 */
public class T018 {
    public static void main(String[] args) {
        //String s = "A man, a plan, a canal: Panama";
        //String s = "race a car";
        //String s = " ";
        //String s = ".";
        String s = "aa";
        System.out.println(new T018().isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        // 先去除特殊字符以及空格
        StringBuilder builder = new StringBuilder();
        //char数组：全部格式化为小写，后面双指针好判断
        char[] chars = s.toLowerCase().trim().toCharArray();
        for (char c : chars) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                // A-Z ascii 码 65-90，a-z ascii码 97-122，0-9 ascii码：48-57
                builder.append(c);
            }
        }
        // 双指针解法，left：左指针，right：右指针
        char[] resultChars = builder.toString().toCharArray();
        int left = 0, right = resultChars.length - 1;
        while (left < right) {
            if (resultChars[left] == resultChars[right]) {
                left++;
                right--;
            } else {
                // char 不等 直接返回false
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        // 正则表达式用法
        String s1 = s.replaceAll("[^A-Za-z0-9]+", "");
        char[] chars = s1.trim().toLowerCase().toCharArray();
        for (int i = 0, length = chars.length - 1; i <= length; i++, length--) {
            if (chars[i] != chars[length]) {
                return false;
            }
        }
        return true;
    }
}
