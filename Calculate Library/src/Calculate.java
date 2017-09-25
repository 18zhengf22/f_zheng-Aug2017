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
		if(factor==0) {
			throw new IllegalArgumentException();
		}
		if(operand%factor==0) {
			return true;
		} else {
			return false;
		}
	}
	//calculate absolute value
	public static double absValue (double operand) {
		if(operand>=0) {
			return operand;
		} else {
			return operand*(-1);
		}
	}
	//determine max out of two numbers
	public static double max (double firstNumber, double secondNumber) {
		if(firstNumber>secondNumber) {
			return firstNumber;
		} else {
			return secondNumber;
		}
	}
	//determine max out of three numbers
	public static double max (double firstNumber, double secondNumber, double thirdNumber) {
		if(firstNumber>secondNumber && firstNumber>thirdNumber) {
			return firstNumber;
		} else if(secondNumber>firstNumber && secondNumber>thirdNumber) {
			return secondNumber;
		} else {
			return thirdNumber;
		}
	}
	//determine min out of two numbers
	public static int min (int firstNumber, int secondNumber) {
		if(firstNumber<secondNumber) {
			return firstNumber;
		} else {
			return secondNumber;
		}
	}
	//round a number to 2 decimal places
	public static double round2 (double orig) {
		double result = 0.0;
		int tempInt = (int) (orig * 1000);
		int roundNum = tempInt % 10;
		tempInt = tempInt / 10;
		if(roundNum>=5 && tempInt>0) {
			tempInt++;
		} else if(roundNum<=-5 && tempInt<0) {
			tempInt--;
		}
		result = tempInt / 100.0;
		return result;
	}
	//raise a value to a positive integer power
	public static double exponent (double base, int exponent) {
		if(exponent < 0) {
			throw new IllegalArgumentException();
		}
		if(exponent == 0) {
			return 1.0;
		}
		double result = base;
		for(int i = 1; i < exponent; i++) {
			result *= base;
		}
		return result;
	}
	//factorial for integer
	public static int factorial (int integer) {
		if(integer<0) {
			throw new IllegalArgumentException();
		}
		int result = 1;
		while(integer>1) {
			result *= integer;
			integer--;
		}
		return result; 
	}
	//determine if integer is prime
	public static boolean isPrime (int integer) {
		if(integer<2) {
			return false;
		}
		for(int i = 2; i < integer; i++) {
			if(isDivisibleBy(integer, i)) {
				return false;
			}
		}
		return true;
	}
	//find gcf of two positive integers
	public static int gcf (int integer, int integer2) {
		int i;
		for(i = integer; !(isDivisibleBy(integer, i) && isDivisibleBy(integer2, i)); i--) {	
		}
		return i;
	}
	//square root of input
	public static double sqrt (double operand) {
		if(operand<0) {
			throw new IllegalArgumentException();
		}
		if(operand==0) {
			return operand;
		}
		double guess = operand/2;
		double result = 0;
		while(result != 0.5*(operand/guess + guess)) {
			result = 0.5*(operand/guess + guess);
			guess = result;
		}
		return round2(result);
	}
	//use quadratic formula to solve for roots
	public static String quadform (int a, int b, int c) {
		double result = round2((-b + sqrt(discriminant(a, b, c)))/(2*a));
		double result2 = round2((-b - sqrt(discriminant(a, b, c)))/(2*a));
		if(discriminant(a, b, c) < 0) {
			System.out.println("no real roots");
		} else if(discriminant(a, b, c) == 0) {
			return result;
		} else {
			return min(result, result2) + " and " + max(result, result2);
		}
	}	
	//min method for doubles
	public static double min (double firstNumber, double secondNumber) {
		if(firstNumber<secondNumber) {
			return firstNumber;
		} else {
			return secondNumber;
		}
	}

}
