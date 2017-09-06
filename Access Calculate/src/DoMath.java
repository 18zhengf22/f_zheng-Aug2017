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

	}

}
