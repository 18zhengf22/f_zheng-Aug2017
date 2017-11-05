/*Frank Zheng
 *November 5, 2017
 *ArraysLab3 
 */
import java.util.Arrays;

public class ArraysLab3 {

	public static void main(String[] args) {
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int[] sumArr = sum(a1, a2);
		int appendNum = 200;
		int[] appendArr = append(a1, appendNum);
		int removeIdx = 5;
		int[] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		System.out.println(Arrays.toString(a1));

	}
	
	//accepts two arrays of ints, returns an array of their sums
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] arrSum = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			arrSum[i] = arr1[i] + arr2[i];
		}
		return arrSum;
	}
	
	//accepts an array of ints, returns the array with num appended to the end
	public static int[] append(int[] arr, int num) {
		int n = arr.length;
		int[] arrAppended = new int[n + 1];
		for (int i = 0; i < n; i++) {
			arrAppended[i] = arr[i];
		}
		arrAppended[n] = num;
		return arrAppended;
	}
	
	//accepts an array of ints, returns it except the element at index idx
	public static int[] remove(int[] arr, int idx) {
		int[] arrRemoved = new int[arr.length - 1];
		for (int i = 0; i < idx; i++) {
			arrRemoved[i] = arr[i];
		}
		for (int i = idx; i < arrRemoved.length; i++) {
			arrRemoved[i] = arr[i + 1];
		}
		return arrRemoved;
	}
	
	//accepts an array of ints, returns an integer containing the sum of the elements at even indices
	public static int sumEven(int[] arr) {
		int sumOfArrEvens = 0;
		for (int i = 0; i < arr.length; i += 2) {
			sumOfArrEvens += arr[i];
		}
		return sumOfArrEvens;
	}
	
	//accepts an array of ints, does not return a value
	//moves each element one index to the right
	public static void rotateRight(int[] arr) {
		int last = arr[arr.length - 1];
		for (int i = arr.length - 1; i >= 1; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = last;
	}

}
