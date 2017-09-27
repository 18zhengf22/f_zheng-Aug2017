/*Frank Zheng
 * September 6, 2017
 * This is the runner for the calculate library. It is used to test the methods in Calculate.
 */
public class DoMath {

	public static void main(String[] args) {
		System.out.println(Calculate.square(-7));
		System.out.println(Calculate.cube(-5));
		System.out.println(Calculate.average(1, 5));
		System.out.println(Calculate.average(5, 10, 6));
		System.out.println(Calculate.toDegrees(6.28318));
		System.out.println(Calculate.toRadians(360));
		System.out.println(Calculate.discriminant(3, 4, 2));
		System.out.println(Calculate.toImproperFrac(5, 3, 4));
		System.out.println(Calculate.toMixedNum(10, 7));
		System.out.println(Calculate.foil(1, 1, 1, 1, "n"));
		System.out.println(Calculate.isDivisibleBy(9, 3));
		System.out.println(Calculate.absValue(-2.4));
		System.out.println(Calculate.max(21, 20));
		System.out.println(Calculate.max(12.4, -1, 10));
		System.out.println(Calculate.min(-2, 2));
		System.out.println(Calculate.round2(7.777777));
		System.out.println(Calculate.exponent(3, 3));
		System.out.println(Calculate.factorial(4));
		System.out.println(Calculate.isPrime(19));
		System.out.println(Calculate.gcf(24, 54));
		System.out.println(Calculate.sqrt(25));
		System.out.println(Calculate.quadform(1, 6, 9));

	}

}
