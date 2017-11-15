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
    	String whole = "";
    	String numerator = "";
    	String denominator = "";
    	if (firstOperand.indexOf("_") >= 0 && firstOperand.indexOf("/") >= 0) {
    		String[] arrOperand = firstOperand.split("_");
    		whole = arrOperand[0];
    		String[] arrOperand2 = arrOperand[1].split("/");
    		numerator = arrOperand2[0];
    		denominator = arrOperand2[1];
    	}
    	String result = "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
    	return result;
        // TODO: Implement this function to produce the solution to the input
        
        //return "";
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
