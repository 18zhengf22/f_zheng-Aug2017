import java.util.Arrays;

public class Split {

	public static void main(String[] args) {
		System.out.println(Arrays.toString("I like apples!".split(" ")));
		System.out.println(Arrays.toString("I really like really red apples".split("really")));
	}
	public static String getTheFilling (String sandwich) {
		//Your task Part 1:
		/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
		* use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
		* What if it's a fancy sandwich with multiple pieces of bread?
		*/
		String[] swBread = sandwich.split("bread");
		String filling = "";
		for (int i = 1; i < swBread.length - 1; i++) {
			filling += swBread[i];
		}
		return filling;
	}
}

	//Your task Part 2:
	/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
	* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
	* Again, what if it's a fancy sandwich with multiple pieces of bread?
	*/
	public static String splitSwSpaces(String sandwich) {
		String[] items = sandwich.split(" ");
		int firstBread = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals("bread")) {
				firstBread = i;
				break;
			}
		}
		int lastBread = 0;
		for(int i = items.length - 1; i > -1; i--) {
			if(items[i].equals("bread")) {
				lastBread = i;
				break;
			}
		}
		String contents = "";
		for(int i = firstBread + 1; i < lastBread; i++) {
			contents += items[i] + " ";
		}
		return contents;
	}
}

