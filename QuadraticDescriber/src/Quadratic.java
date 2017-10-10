/*Frank Zheng
 * September 27, 2017
 * Part of QuadraticDescriber
 * It is responsible for all the calculations.
 */
public class Quadratic {
	public static String quadrDescriber (double a, double b, double c) {
		System.out.println("Description of the graph of:");
		System.out.println("y = " + a + " x^2 + " + b + " x + " + c);
		System.out.println();
		String opens = "";	
		if (a > 0) {
			opens = "Up";
		} else {
			opens = "Down";
		}
		double aos = -b / (2 * a);
		double vertex_y = a * aos * aos + b * aos + c;
		String vertex = "Vertex: (" + aos + ", " + vertex_y + ")";
		String x_cept = quadform(a, b, c);
		String y_cept = "y-intercept: " + c;
		return "Opens: " + opens + "\n" + 
			   "Axis of Symmetry: x = " + aos + "\n" + 
			   vertex + "\n" + 
			   "x-intercept(s): " + x_cept + "\n" +
			   y_cept;
	}
	public static String quadform (double a, double b, double c) {
		if (discriminant(a, b, c) < 0) {
			return "None";
		}
		double result1 = round2((-b + sqrt(discriminant(a, b, c))) / (2 * a));
		double result2 = round2((-b - sqrt(discriminant(a, b, c))) / (2 * a));
		if (discriminant(a, b, c) == 0) {
			return result1 + "";
		} else {
			return min(result1, result2) + " and " + max(result1, result2);
		}
	}
	public static double discriminant (double a, double b, double c) {
		return b * b - 4 * a * c;
	}
	public static double sqrt (double operand) {
		if (operand < 0) {
			throw new IllegalArgumentException();
		}
		if (operand == 0) {
			return operand;
		}
		double guess = operand / 2;
		double result = 0;
		while (result != 0.5 * (operand / guess + guess)) {
			result = 0.5 * (operand / guess + guess);
			guess = result;
		}
		return round2(result);
	}
	public static double round2 (double orig) {
		double result = 0.0;
		int tempInt = (int) (orig * 1000);
		int roundNum = tempInt % 10;
		tempInt = tempInt / 10;
		if (roundNum >= 5 && tempInt > 0) {
			tempInt++;
		} else if (roundNum <= -5 && tempInt < 0) {
			tempInt--;
		}
		result = tempInt / 100.0;
		return result;
	}
	public static double min (double firstNum, double secondNum) {
		if (firstNum < secondNum) {
			return firstNum;
		} else {
			return secondNum;
		}
	}
	public static double max (double firstNum, double secondNum) {
		if (firstNum > secondNum) {
			return firstNum;
		} else {
			return secondNum;
		}
	}

}
