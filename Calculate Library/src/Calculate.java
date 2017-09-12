/*Frank Zheng
 * September 6, 2017
 * Our self written math library
 * It contains a series of methods to do basic math functions.
 */
public class Calculate {
	
	//square the input
	public static int square (int operand) {
		int squared = operand*operand;
		return squared;
	}
	//cube the input
	public static int cube (int operand) {
		return operand*operand*operand;
	}
	//average the input of 2 values
	public static double average (double operand, double operand2) {
		return (operand+operand2)/2;
	}
	//average the input of 3 values
	public static double average (double operand, double operand2, double operand3) {
		return (operand+operand2+operand3)/3;
	}
	//convert angle measure given in radians into degrees
	public static double toDegrees (double operand) {
		return operand*180/3.14159;
	}
	//convert angle measure given in degrees into radians
	public static double toRadians (double operand) {
		return operand*3.14159/180;
	}
	//calculate the discriminant
	public static double discriminant (double a, double b, double c) {
		return b*b-4*a*c;
	}
	//convert mixed number into improper fraction
	public static String toImproperFrac (int wholeNumber, int numerator, int denominator) {
		return denominator*wholeNumber+numerator+"/"+denominator;
	}
	//convert improper fraction into mixed number
	public static String toMixedNum (int numerator, int denominator) {
		return numerator/denominator+"_"+numerator%denominator+"/"+denominator;
	}
	//convert binomial multiplication into standard form of a quadratic expression
	public static String foil (int a, int b, int c, int d, String variable) {
		return a*c+variable+"^2"+" + "+(a*d+b*c)+variable+" + "+b*d;
	}
	//determine whether or not integer is evenly divisible by another
	public static boolean isDivisibleBy (int operand, int factor) {
		if(operand%factor==0) {
			return true;//what are these?
		} else {
			return false;
		}
	}
}
