/*Frank Zheng
 * November 2, 2017
 * Array Mini Lab
 * See what a method that changes values does to the main method
 */
public class LotsOfCopies {

	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		System.out.println("main num: " + num + " before change");
		System.out.println("main strMain: " + strMain + " before change");
		System.out.println("main arrMain first number: " + arrMain[0] + " before change");
		System.out.println();
		changeMe(num, strMain, arrMain);
		System.out.println("main num = " + num + " after change");
		System.out.println("main strMain: " + strMain + " after change");
		System.out.println("main arrMain first number: " + arrMain[0] + " after change");
	}
	public static void changeMe (int x, String str, int[] arr) {
		x = 10;
		System.out.println("change num: " + x);
		str = "CPCS";
		System.out.println("change strMain: " + str);
		arr[0] = 15;
		System.out.println("change arrMain first number: " + arr[0]);
		System.out.println();
	}
}
//conclusion: only arrMain[] changes in main after changeMe
//also, after some testing, I found that setting an array equal to another and then changing the original array to something else will change the second array too, but the int and String variables stay the same

