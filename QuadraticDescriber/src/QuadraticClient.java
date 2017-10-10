/*Frank Zheng
 * September 27, 2017
 * Part of QuadraticDescriber
 * It will handle interactions with the user.
 */
import java.util.Scanner;
public class QuadraticClient {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to the Quadratic Describer");
		System.out.println("Provide values for coefficients a, b, and c");
		System.out.println();
		boolean done = false;
		do {
			System.out.print("a: ");
			double a = userInput.nextDouble();
			System.out.print("b: ");
			double b = userInput.nextDouble();
			System.out.print("c: ");
			double c = userInput.nextDouble();
			System.out.println();
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println();
			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
			String finished = userInput.next();
			char answer = finished.charAt(0);
			if (answer == 'q') {
				done = true;
			}
			System.out.println();
		} while (done == false);

	}

}
