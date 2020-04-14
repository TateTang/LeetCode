/**
 * @Description
 * @Author tangmf
 * @Date 2020/4/9 11:13
 */
public class Test1 {

	public static void main(String[] args) {
		int[] guess = { 1, 2, 3 };
		int[] answer = { 1, 2, 3 };
		System.out.println(game(answer,guess));
	}

	private static int game(int[] guess, int[] answer) {
		int result = 0;
		for (int i = 0; i < guess.length; i++) {
			if (guess[i] == answer[i]) {
				result++;
			}
		}
		return result;
	}
}
