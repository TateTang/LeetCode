/**
 * @Author tangmf
 * @Date 2020/4/9 16:35
 * @Description 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。 所谓无效化 IP
 *              地址，其实就是用 "[.]" 代替了每个 "."。 示例 1： 输入：address = "1.1.1.1"
 *              输出："1[.]1[.]1[.]1"
 *
 */
public class Test8 {

	public static void main(String[] args) {
		String address = "255.100.50.0";
		System.out.println(defangIPaddr(address));
	}

    /**
     * 这一题没啥好说的，用replace没有sb的快。简单暴力
     */
	private static String defangIPaddr(String address) {
//		String str = "";
//		for (int i = 0; i < address.length(); i++) {
//			str = address.replace(".", "[.]");
//		}
//		return str;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i)=='.'){
                builder.append("[.]");
                continue;//跳出本次循环，中断循环中的迭代   break，跳出循环结束循环所在的循环体已经结束。
            }
            builder.append(address.charAt(i));
        }
        return  builder.toString();
	}
}
