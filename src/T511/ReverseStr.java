package T511;

/**
 * @Author tangmf
 * @Date 2020/5/11 14:38
 * @Description 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 *              不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 *              你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *               
 *
 *              示例 1：
 *
 *              输入：["h","e","l","l","o"] 输出：["o","l","l","e","h"] 示例 2：
 *
 *              输入：["H","a","n","n","a","h"] 输出：["h","a","n","n","a","H"]
 */
public class ReverseStr {

	public static void main(String[] args) {
		char[] chars = { 'h', 'e', 'l', 'l', 'o' };
		reverseString(chars);
	}

	public static void reverseString(char[] s) {
		/*
		 * 双指针法是使用两个指针，一个左指针 left，右指针 right，开始工作时 left 指向首元素，right
		 * 指向尾元素。交换两个指针指向的元素，并向中间移动，直到两个指针相遇。
		 * 1、将 left 指向首元素，right 指向尾元素。
		 * 2、当 left<right： 交换 s[left] 和 s[right]。
		 * 3、left++ right++
		 */
		int left = 0,right = s.length-1;//定义双指针
		while (left<right){ // 不同时，进行元素
		    char temp = s[left];
		    s[left++] = s[right];// 加加减减在后先运算 后加减 也就是 s[0]=s[4] left =left+1
		    s[right--]=temp;
        }
        System.out.println(s);
	}
}
