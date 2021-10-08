package offer;

/**
 * @Author tangmf
 * @Date 2021/10/8 10:59 上午
 * @Description 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 */
public class Offer12 {
    private int count = 0;//匹配到字符串的第几个数字

    public static void main(String[] args) {
        //char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board = {{'a'}};
        //String word = "ABCCEDsfsa";
        String word = "ab";
        System.out.println(new Offer12().exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        /*
        双重循环遍历每一个字符，对每一个字符进行dfs 深度优先搜索，不等于word中的字母就匹配失败，否则匹配成功，
        同时用一个数字记录匹配到了word的第几个字母
        - 匹配成功的字符为了防止再次进行匹配将其改为不是字母的符号，如符号'-'
        - 每次匹配失败后，需要恢复现场，将count--，将board[i][j]恢复
         */
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, words, i, j)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] words, int i, int j) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0)
            return false;//越界检查
        if (board[i][j] != words[count]) {
            return false;//字符检查
        }
        //保存原来的值，将访问过的设置为不为字母的符号
        char temp = board[i][j];
        board[i][j] = '-';

        //如果到达最后一个，则匹配成功，直接返回即可
        if (count == words.length - 1) return true;
        //逐个进行深度遍历
        count++;
        //遍历上下左右的，只要有就代表ok
        boolean res = dfs(board, words, i + 1, j) || dfs(board, words, i - 1, j)
                || dfs(board, words, i, j - 1) || dfs(board, words, i, j + 1);
        //恢复现场count--
        count--;
        board[i][j] = temp;
        return res;
    }
}
