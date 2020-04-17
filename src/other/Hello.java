package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author tangmf
 * @Date 2020/1/15 16:22
 */
public class Hello {
	public static void main(String[] args) {
		List list = new ArrayList();
		String[] str = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			str[i] = (String) list.get(i);
		}

		String[] str2 = (String[]) list.toArray(new String[list.size()]);
		System.out.println("hello");
        f();
	}

	public static void f() {
		String[] arr = { "1", "2" };
		List<String> list = new ArrayList<String>();
		for (String s : arr) {
			list.add(s);
		}
		list.forEach(System.out::println);
	}

	public static void s(String[] str){
	    List<String>  list = new ArrayList<String>(str.length);
        Collections.addAll(list, str);
    }

}
