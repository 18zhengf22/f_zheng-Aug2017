/*Frank Zheng
 * September 27, 2017 - October 17, 2017
 * Part of QuadraticDescriber
 * It will handle interactions with the user.
 */
import java.util.Scanner;
public class QuadraticClient {
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to the Quadratic Describer");
		System.out.println("Provide values for coefficients a, b, and c"); //we can assume user inputs numbers
		do {
			System.out.println();
			System.out.print("a: ");
			double a = userInput.nextDouble(); //we can assume a != 0
			System.out.print("b: ");
			double b = userInput.nextDouble();
			System.out.print("c: ");
			double c = userInput.nextDouble();
			System.out.println();
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println();
			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
		} while (userInput.next().charAt(0) != 'q'); //exit after user inputs anything beginning with the letter q
	}

}
