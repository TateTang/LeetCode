/**
 * @Author tangmf
 * @Date 2020/4/20 9:20
 * @Description
 */
public class TT {
	// 两者的循环次数是一直的，造成性能差异，主要是实例化次数和初始化次数不一样。

	public static void main(String[] args) {
        t1();
//        t2();
	}

	public static void t1() {
		long startTime = System.nanoTime();
		for (int i = 0; i < 10000000; i++) {
			for (int j = 0; j < 10; j++) {

			}
		}
		long endTime = System.nanoTime();
		System.out.println("外大内小耗时：" + (endTime - startTime));
	}

	public static void t2() {
		long stratTime1 = System.nanoTime();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10000000; j++) {

			}
		}
		long endTime1 = System.nanoTime();
		System.out.println("外小内大耗时：" + (endTime1 - stratTime1));
	}
}
