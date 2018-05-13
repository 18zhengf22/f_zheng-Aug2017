/*Frank Zheng
 *APCS2
 *March - April 2017 but actually March - May for me :(
 *TextExcel
 *Spreadsheet program that can do some math
 */

package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;
// Update this file with your own code.

public class TextExcel {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to TextExcel! To quit, type \"quit\".");
		Spreadsheet spreadsheet = new Spreadsheet();
		boolean done = true;
		while (done) {
			System.out.println("Enter command.");
			String input = scanner.nextLine();
			if (input.equals("quit")) {
				done = false;
			} else {
				System.out.println(spreadsheet.processCommand(input));
			}
		}
	}
}
