package T420;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author tangmf
 * @Date 2020/4/20 15:09
 * @Description 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b"
 *              对应 "-...", "c" 对应 "-.-.", 等等。
 *
 *              为了方便，所有26个英文字母对应摩尔斯密码表如下：
 *
 *              [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 *              给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即
 *              "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
 *
 *              返回我们可以获得所有词不同单词翻译的数量。
 *
 *              例如: 输入: words = ["gin", "zen", "gig", "msg"] 输出: 2 解释: 各单词翻译如下:
 *              "gin" -> "--...-." "zen" -> "--...-." "gig" -> "--...--." "msg"
 *              -> "--...--."
 *
 *              共有 2 种不同翻译, "--...-." 和 "--...--.".
 */
public class T5 {

	public static void main(String[] args) {
		String[] arrs = { "gin", "zen", "gig", "msg" };
		System.out.println(uniqueMorseRepresentations(arrs));
		// System.out.println('c' - 'a');
	}

	private static int uniqueMorseRepresentations(String[] words) {
		// 我们将数组 word 中的每个单词转换为摩尔斯码，并加入哈希集合（HashSet）中，最终的答案即为哈希集合中元素的个数。
		String[] MORSE = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
				".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
				"--.." };
		Set<String> seen = new HashSet<>();
		for (String word : words) {
			StringBuilder builder = new StringBuilder();
			for (char c : word.toCharArray()) {
				builder.append(MORSE[c - 'a']);// 获取每个福尔斯码 也就是 MORSE中对应的
			}
			seen.add(builder.toString());// 添加到hash集合中,hash集合中不能重复
		}
		return seen.size();
	}
}
