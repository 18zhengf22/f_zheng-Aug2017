/*Frank Zheng
 *November 2017
 *FracCalc
 */
package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner userInput = new Scanner(System.in);
    	while (userInput.next() != "quit") {
    		String input = userInput.nextLine();
    		produceAnswer(input);
    		System.out.println(produceAnswer(input));
    	}
        // TODO: Read the input from the user and call produceAnswer with an equation

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
    	String[] array = input.split(" ");
    	String firstOperand = array[0];
    	String operator = array[1];
    	String secondOperand = array[2];
    	splitOperand(firstOperand);
    	splitOperand(secondOperand);
    	String result = "whole:" + splitOperand(secondOperand)[0] + " numerator:" + splitOperand(secondOperand)[1] + " denominator:" + splitOperand(secondOperand)[2];
    	return result;
    }
        // TODO: Implement this function to produce the solution to the input
        
        //return "";
    public static String[] splitOperand(String operand) {
    	String whole = "";
    	String numer = "";
    	String denom = "";
    	String fraction = "";
    	String[] arrOperand = operand.split("_");
    	if (operand.contains("_")) {
    		whole = arrOperand[0];
    		fraction = arrOperand[1];
    	} else if (operand.contains("/")) {
    		whole = "0";
    		fraction = arrOperand[0];
    	} else {
    		whole = operand;
    		numer = "0";
    		denom = "1";
    	}
    	if (!fraction.equals("")) {
    		String[] arrFraction = fraction.split("/");
    		numer = arrFraction[0];
    		denom = arrFraction[1];
    	}
    	String[] arrComponents = {whole, numer, denom};
    	return arrComponents;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
