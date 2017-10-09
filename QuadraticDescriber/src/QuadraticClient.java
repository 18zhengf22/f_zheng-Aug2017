/*Frank Zheng
 * September 27, 2017
 * Part of QuadraticDescriber
 * It will handle interactions with the user.
 */
import java.util.Scanner;
public class QuadraticClient {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		do {
			System.out.println("Provide values for coefficients a, b, and c");
			System.out.println();
			System.out.println("a: ");
			double a = userInput.nextDouble();
			System.out.println("b: ");
			double b = userInput.nextDouble();
			System.out.println("c: ");
			double c = userInput.nextDouble();
			System.out.println();
			quadrDescriber(a, b, c);
			System.out.println(description);
		} while (done == false);

	}

}
