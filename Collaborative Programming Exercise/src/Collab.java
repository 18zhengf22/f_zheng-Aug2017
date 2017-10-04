/*Frank Zheng
 * October 4, 2017
 * This is the final step for the Collaborative Programming Exercise.
 */
import java.util.Scanner;
public class Collab {
	public static void main(String[] args) {
	Scanner userInput = new Scanner(System.in);
	int sum = 0;
	int max = 0;
	int maxEven = 0;
	int min = 0;
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
		if(operand % 2 == 0 && operand > maxEven) {
			maxEven = operand;
		}
		System.out.println("Are we done yet? Enter yes if done.");
		String finished = userInput.next();
		if (finished.equals("yes")) {
			done = true;
		}
	} while(done == false);
	System.out.println("This is your min value: " + min);
	System.out.println("This is your max value: " + max);
	System.out.println("This is your even sum: " + sum);
	System.out.println("This is your max even value: " + maxEven);
	}
}

