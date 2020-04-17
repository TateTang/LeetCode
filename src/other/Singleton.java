package other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description
 * @Author tangmf
 * @Date 2020/3/18 13:26
 */
public class Singleton {
	/*
	 * private static other.Singleton instatnce = new other.Singleton(); private
	 * other.Singleton(){
	 *
	 * } public static other.Singleton getInstance(){ return instatnce; }
	 */
	// 饿汉模式

	// 懒汉模式
	private static Singleton instance = null;

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public static void main(String[] args) {
		System.out.println(filterChinese("fsdajfdjfladfiojadfadsf时代峰峻肯定会发觉揆理度势j."));
	}

	/**
	 * 过滤掉中文的方法
	 *
	 * @param str，待过滤中文的字符串
	 * @return 过滤掉中文后字符串
	 */
	public static String filterChinese(String str) {
		// 用于返回结果
		String result = str;
		boolean flag = isContainChinese(str);
		if (flag) {// 包含中文
			StringBuilder sb = new StringBuilder();// 用于拼接过滤中文后的字符
			boolean flag2;// 用于校验是否为中文
			char chinese;// 用于临时存储单字符
			char[] charArray = str.toCharArray();// 5.去除掉文件名中的中文,将字符串转换成char[]
			// 过滤到中文及中文字符
			for (char c : charArray) {
				chinese = c;
				flag2 = isChinese(chinese);
				if (!flag2) {// 不是中日韩文字及标点符号
					sb.append(chinese);
				}
			}
			result = sb.toString();
		}
		return result;
	}

	/**
	 * 判定输入的是否是汉字
	 *
	 * @param c，被校验的字符
	 * @return true代表是汉字
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
	}

	/**
	 * 判断字符串中是否包含中文
	 *
	 * @param str，待校验字符串
	 * @return 是否为中文不能校验是否为中文标点符号
	 */
	public static boolean isContainChinese(String str) {
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		return m.find();
	}
}
