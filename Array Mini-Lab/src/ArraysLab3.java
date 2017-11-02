
public class ArraysLab3 {

	public static void main(String[] args) {

	}
	
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] arrSum = new int[arr1.length];
		for (int i = 1; i < arr1.length; i++) {
			arrSum[i] = arr1[i] + arr2[i];
		}
		return arrSum;
	}
	
	public static int[] append(int[] arr, int num) {
		int n = arr.length;
		int[] arrAppended = new int[n + 1];
		arrAppended[n] = num;
		return arrAppended;
	}
	
	public static int[] remove(int[] arr, int idx) {
		int[] arrRemoved = new int[arr.length - 1];
		for (int i = 0; i < idx; i++) {
			arrRemoved[i] = arr[i];
		}
		for (int i = idx; i >= idx; i++) {
			arrRemoved[i] = arr[i + 1];
		}
		return arrRemoved;
	}

	public static int sumEven(int[] arr) {
		int sumOfArrEvens = 0;
		for (int i = 0; i < arr.length; i += 2) {
			sumOfArrEvens += arr[i];
		}
		return sumOfArrEvens;
		}
	
	public static void rotateRight(int[] arr) {
		int last = arr[arr.length - 1];
		for (int i = 1; i < arr.length;i++) {
			arr[i] = arr[i - 1];
		}
		arr[0] = last;
	}
	
	public static void main

}
