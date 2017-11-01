
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
	

}
