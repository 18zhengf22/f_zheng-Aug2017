
public class Pikachu {

	public static void main(String[] args) {
		System.out.println("   Pikachu welcomes you to the world of Pokemon!");
		System.out.println("             (\\__/)");
		System.out.println("             (o^-^)");
		System.out.println("           z(_(\")(\")");

	}
	public static String scrambleIt (String word) {
		String scrambled = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == 'A' && word.charAt(i + 1) != 'A') {
				scrambled += word.charAt(i + 1) + "A";
				i++;
			} else {
				scrambled += word.charAt(i);
			}
		}
		return scrambled;
	}
}
