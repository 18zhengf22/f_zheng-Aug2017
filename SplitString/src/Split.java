/*Frank Zheng
 * October 30, 2017
 * SplitString
 * Using split method
 */
import java.util.Arrays;

public class Split {
	
	// Your task Part 0
	//String.split();
	//It's a method that acts on a string, <StringName>.split(<String sp>);
	//Where sp is the string where the string splits
	//And it returns an array
	// Example: "I like apples!".split(" "); 
//		it will split at spaces and return an array of ["I","like","apples!"]
	// Example 2: "I really like really red apples".split("really")
//		it will split at the word "really" and return an array of ["I "," like "," red apples!"]
	//play around with String.split! 
	//What happens if you "I reallyreally likeapples".split("really") ?
	public static void main(String[] args) {
		System.out.println(Arrays.toString("I like apples!".split(" ")));
		System.out.println(Arrays.toString("I really like really red apples".split("really")));
		System.out.println(Arrays.toString("I reallyreally likeapples".split("really")));
		System.out.println("The filling: " + getTheFilling("breadlettustomatobaconmayohambreadcheesebread"));
		System.out.println(splitAtSpaces("apples pineapples bread lettus bread tomato bacon mayo ham bread cheese"));
	}

		//Your task Part 1:
		/*Write a method that take in a string like "applespineapplesbreadlettustombreadatobaconmayohambreadcheese" describing a sandwich
		* use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
		* What if it's a fancy sandwich with multiple pieces of bread?
		*/
	public static String getTheFilling (String sandwich) {
		String[] btwnBread = sandwich.split("bread");
		String filling = "";
		if (sandwich.endsWith("bread")) {
			
		}
		for (int i = 1; i < btwnBread.length - 1; i++) {
			filling += btwnBread[i];
		}
		return filling;
	}

	//Your task Part 2:
	/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
	* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
	* Again, what if it's a fancy sandwich with multiple pieces of bread?
	*/
	public static String splitAtSpaces (String sandwich) {
		String[] items = sandwich.split(" ");
		int firstBread = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals("bread")) {
				firstBread = i;
				break;
			}
		}
		int lastBread = 0;
		for (int i = items.length - 1; i > -1; i--) {
			if(items[i].equals("bread")) {
				lastBread = i;
				break;
			}
		}
		String filling = "";
		for (int i = firstBread + 1; i < lastBread; i++) {
			filling += items[i] + " ";
		}
		return filling;
	}
}

