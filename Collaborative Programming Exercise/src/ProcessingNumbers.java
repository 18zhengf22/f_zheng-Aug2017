/*Frank Zheng
 * October 5, 2017
 * This is the final step for the Collaborative Programming Exercise.
 * Prints min, max, sum of evens, and largest even.
 */
import java.util.Scanner;
public class ProcessingNumbers {
	public static void main(String[] args) {
	Scanner userInput = new Scanner(System.in);
	System.out.println("Enter an integer!");
	int firstNum = userInput.nextInt();
	int sum = 0;
	int max = firstNum;
	int maxEven = firstNum;
	int min = firstNum;
	boolean done = false;
	do {
		System.out.println("Enter an integer!");
		int operand = userInput.nextInt(); 
		if(operand >= max) {
			max = operand;
		}
		if(operand <= min) {
			min = operand;
		}
		if(operand % 2 == 0) {
			sum = operand + sum;
		}
		if((firstNum % 2 != 0 && operand % 2 == 0) || (operand % 2 == 0 && operand > maxEven)) {
			maxEven = operand;
		}
		System.out.println("Are we done yet? Enter yes if done.");
		String finished = userInput.next();
		if(finished.equals("yes")) {
			done = true;
			if(maxEven % 2 != 0) {
				System.out.println("No even numbers.");
			}
		}
	} while(done == false);
	System.out.println("This is your minimum: " + min);
	System.out.println("This is your maximum: " + max);
	System.out.println("This is the sum of your even numbers: " + sum);
	if(maxEven %2 == 0) {
	System.out.println("This is your maximum even: " + maxEven);
	}
	}
}

