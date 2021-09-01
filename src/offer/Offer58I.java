package offer;

/**
 * @Author tangmf
 * @Date 2021/9/1 9:56 上午
 * @Description 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Offer58I {
    public static void main(String[] args) {
        String str = "a good   example";
        System.out.println(new Offer58I().reverseWords1(str));
    }

    public String reverseWords(String s) {
        /*
        字符串的方式
         */
        StringBuilder builder = new StringBuilder();
        s = s.trim();//去掉首尾空格
        if (s.equals("")) {
            return "";
        }
        String[] strArr = s.split(" ");//中间以空格分割，如果有多个，会被分割出来，成为一个空的字符串
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (strArr[i].equals("")) {
                continue;// 如果等于空字符串 跳出本次循环，中断循环中的迭代，不进行下一步
            }
            builder.append(strArr[i]);
            builder.append(" ");//追加空格
        }
        return builder.toString().trim();//还需要去掉最后一个字符的字符串
    }

    public String reverseWords1(String s) {
        /*
        双指针的方法
         - 倒序遍历字符串s,记录单词左右索引边界i,j
         - 每确定一个单词的边界,则将其添加至单词列表res
         - 最终,将单词列表拼接为字符串,并返回即可。

         循环执行
         - 索引i 从右向左搜索首个空格
         - 添加单纯s[i+1:j+1] 到res
         - 索引i 跳过两单词间的所有空格
         - 执行j =i，此时j指向下个单词的尾字符
         */
        s = s.trim();//删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--; // 搜索首个空格
            }
            res.append(s, i + 1, j + 1).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--; // 跳过单词间空格
            }
            j = i;// j 指向下个单词的尾字符
        }
        return res.toString().trim();// 转化为字符串并返回
    }
}
