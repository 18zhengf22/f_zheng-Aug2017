/*Frank Zheng
 *December 2017
 *FracCalc (with objects)
 *Fraction calculator that can add, subtract, multiply, or divide two fractions (or integers, or an integer and a fraction)
 *Answer is reduced, but FracCalc does not work for multiple operations
 */
package fracCalc;

import java.util.Scanner;

public class FracCalc {
	
    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter expression. To quit, type \"quit\".");
		boolean done = true;
		while(done) {
			String input = userInput.nextLine();
			if(input.equals("quit")) {
				done = false;
			} else {
				System.out.println(produceAnswer(input));
			}
		}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) {  	
        // TODO: Implement this function to produce the solution to the input
    		String[] arrInput = input.split(" ");
    		Fraction firstOperand = splitOperand(arrInput[0]);
    		String operator = arrInput[1];
    		Fraction secondOperand = splitOperand(arrInput[2]);
    		return secondOperand.toString();
    }
    
    public static Fraction splitOperand(String operand) {
    		int whole = 0;
		int numer = 0;
		int denom = 1;
		if (operand.contains("_")) {
			whole = Integer.parseInt(operand.split("_")[0]);
			numer = Integer.parseInt(operand.split("_")[1].split("/")[0]);
			denom = Integer.parseInt(operand.split("/")[1]);
		} else if (operand.contains("/")) {
			numer = Integer.parseInt(operand.split("/")[0]);
			denom = Integer.parseInt(operand.split("/")[1]);
		} else {
			whole = Integer.parseInt(operand);
		}
		if (whole < 0) {
			numer *= -1;
		}
		Fraction result = new Fraction(whole, numer, denom);
		return result;
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
