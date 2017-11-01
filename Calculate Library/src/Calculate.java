/*Frank Zheng
 * September 6, 2017 - September 29, 2017
 * Our self written math library
 * It contains a series of methods to do basic math functions.
 */
public class Calculate {
	
	//accepts int, returns int: the square of the input
	public static int square (int operand) {
		int squared = operand*operand;
		return squared;
	}
	//accepts int, returns int: the cube of the input
	public static int cube (int operand) {
		return operand*operand*operand;
	}
	//accepts two doubles, returns double: the average of the input 
	public static double average (double operand, double operand2) {
		return (operand+operand2)/2;
	}
	//accepts three doubles, returns double: the average of the input
	public static double average (double operand, double operand2, double operand3) {
		return (operand+operand2+operand3)/3;
	}
	//accepts double, returns double: convert angle measure given in radians into degrees
	public static double toDegrees (double operand) {
		return operand*180/3.14159;
	}
	//accepts double, returns double: convert angle measure given in degrees into radians
	public static double toRadians (double operand) {
		return operand*3.14159/180;
	}
	//accepts three doubles, returns double: the discriminant
	public static double discriminant (double a, double b, double c) {
		return b*b-4*a*c;
	}
	//accepts three ints, returns String: convert mixed number into improper fraction
	public static String toImproperFrac (int wholeNumber, int numerator, int denominator) {
		return denominator*wholeNumber+numerator+"/"+denominator;
	}
	//accepts two ints, returns String: convert improper fraction into mixed number
	public static String toMixedNum (int numerator, int denominator) {
		return numerator/denominator+"_"+numerator%denominator+"/"+denominator;
	}
	//accepts four ints and String, returns String: convert binomial multiplication into standard form of a quadratic expression
	public static String foil (int a, int b, int c, int d, String variable) {
		return a*c+variable+"^2"+" + "+(a*d+b*c)+variable+" + "+b*d;
	}
	//accepts two ints, return boolean: determine whether or not integer is evenly divisible by another
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
	//accepts double, returns double: the absolute value of the input
	public static double absValue (double operand) {
		if(operand>=0) {
			return operand;
		} else {
			return operand*(-1);
		}
	}
	//accepts two doubles, returns double: the max out of two numbers
	public static double max (double firstNumber, double secondNumber) {
		if(firstNumber>secondNumber) {
			return firstNumber;
		} else {
			return secondNumber;
		}
	}
	//accepts three doubles, return double: the max out of three numbers
	public static double max (double firstNumber, double secondNumber, double thirdNumber) {
		if(firstNumber>secondNumber && firstNumber>thirdNumber) {
			return firstNumber;
		} else if(secondNumber>firstNumber && secondNumber>thirdNumber) {
			return secondNumber;
		} else {
			return thirdNumber;
		}
	}
	//accepts two ints, returns int: the min out of two numbers
	public static int min (int firstNumber, int secondNumber) {
		if(firstNumber<secondNumber) {
			return firstNumber;
		} else {
			return secondNumber;
		}
	}
	//accepts double, returns double: a number rounded to 2 decimal places
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
	//accepts double and int, returns double: raise a value to a positive integer power
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
	//accepts int, returns int: factorial for integer
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
	//accepts int, returns boolean: determine if integer is prime
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
	//accepts two ints, return int: the gcf of two positive integers
	public static int gcf (int integer, int integer2) {
		int i;
		for(i = integer; !(isDivisibleBy(integer, i) && isDivisibleBy(integer2, i)); i--) {	
		}
		return i;
	}
	//accepts double, returns double: the square root of the input
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
	//accepts three ints, returns String: use quadratic formula to solve for roots
	public static String quadForm (int a, int b, int c) {
		if(discriminant(a, b, c) < 0) {
			return "no real roots";
		}
		double result = round2((-b + sqrt(discriminant(a, b, c)))/(2*a));
		double result2 = round2((-b - sqrt(discriminant(a, b, c)))/(2*a));
		if(discriminant(a, b, c) == 0) {
			return result + "";
		} else {
			return min(result, result2) + " and " + max(result, result2);
		}
	}	
	//min method for doubles, primarily to be used in quadform
	//accepts two doubles, returns double: the min out of two doubles
	public static double min (double firstNumber, double secondNumber) {
		if(firstNumber<secondNumber) {
			return firstNumber;
		} else {
			return secondNumber;
		}
	}
	
}
