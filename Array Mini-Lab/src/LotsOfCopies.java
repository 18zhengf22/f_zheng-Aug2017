
public class LotsOfCopies {

	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		changeMe(num, strMain, arrMain);
		System.out.println("main num = " + num);
		System.out.println("main String: " + strMain);
		System.out.println("main array first number: " + arrMain[0]);
	}
	public static void changeMe (int x, String str, int[] arr) {
		arr[0] = 9;
		System.out.println("changed array first number: " + arr[0]);
	}

}
