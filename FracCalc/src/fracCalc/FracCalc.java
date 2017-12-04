/*Frank Zheng
 *November 2017
 *FracCalc
 *Fraction calculator that can add, subtract, multiply, or divide two fractions (or integers, or an integer and a fraction)
 *Answer is reduced, but FracCalc does not work for multiple operations
 */
package fracCalc;

import java.util.*;

public class FracCalc {

    public static void main(String[] args) {
    		Scanner userInput = new Scanner(System.in);
    		System.out.println("Enter expression. To quit, type \"quit\".");
    		while (!userInput.next().equals("quit")) {
    			String input = userInput.nextLine();
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
    		String[] arrSplit = input.split(" ");
    		int[] arrFirstOperand = splitOperand(arrSplit[0]);
    		String operator = arrSplit[1];
    		int[] arrSecondOperand = splitOperand(arrSplit[2]);
    		if (arrFirstOperand[1] == 0 || arrSecondOperand[1] == 0) {
    			return "ERROR: Cannot divide by zero.";
    		}
    		if (operator.equals("+") || operator.equals("-")) {
    			return reduce(addSubtract(arrFirstOperand, arrSecondOperand, operator));
    		} else {
    			return reduce(multiplyDivide(arrFirstOperand, arrSecondOperand, operator));
    		}
    }
    
        // TODO: Implement this function to produce the solution to the input
        
        //return "";
    public static int[] splitOperand(String operand) {
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
    		numer = denom * whole + numer;
    		int[] arrImprOperand = {numer, denom};
    		return arrImprOperand; //To simplify calculations, improper is returned instead of mixed.
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static int[] addSubtract(int[] firstOperand, int[] secondOperand, String operator) {
    		int answerNumer = 0;
    		int answerDenom = firstOperand[1] * secondOperand[1]; //common denom
    		int newFirstNumer = firstOperand[0] * secondOperand[1];
    		int newSecondNumer = secondOperand[0] * firstOperand[1];
	    	if (operator.equals("+")) { //Add
		    	answerNumer = newFirstNumer + newSecondNumer;
	    	} else { //Subtract
	    		answerNumer = newFirstNumer - newSecondNumer;
	    	}
	    	int[] answer = {answerNumer, answerDenom};
		return answer;
    }
    
    public static int[] multiplyDivide(int[] firstOperand, int[] secondOperand, String operator) {
	    	int answerNumer = 0;
	    	int answerDenom = 1;
	    	if (operator.equals("*")) { //Multiply
	    		answerNumer = firstOperand[0] * secondOperand[0];
	    		answerDenom = firstOperand[1] * secondOperand[1];
	    	} else { //Divide
	    		if (secondOperand[0] < 0) {
	    			secondOperand[0] *= -1;
	    			secondOperand[1] *= -1;//Moves negative sign to answer's numer for reducing later.
	    		}
	    		answerNumer = firstOperand[0] * secondOperand[1]; //Basically multiplies the reciprocal.
	    		answerDenom = firstOperand[1] * secondOperand[0];
	    	}
	    	int[] answer = {answerNumer, answerDenom};
	    	return answer;
    }
    //reduces the unsimplified answer
    public static String reduce(int[] answer) {
    		if (answer[0] == 0) { //If numer is 0, answer will be 0.
    			return "0";
    		}
    		if (isDivisibleBy(answer[0], answer[1])) { //If numer is divisible by denom, answer will be the quotient.
    			return "" + answer[0] / answer[1];
    		}
    		int whole = answer[0] / answer[1];
    		int numer = answer[0] % answer[1];
    		if (whole != 0) {
    			numer = absValue(numer); //Absolute value in case numer is negative, since whole contains negative.
    		}
    		int denom = answer[1];
    		int gcf = gcf(numer, denom);
    		numer /= gcf;
    		denom /= gcf;
    		if (whole == 0) { //If not improper, no need to convert to mixed.
    			return numer + "/" + denom;
    		} else { //Convert improper to mixed.
    			return whole + "_" + numer + "/" + denom;
    		}
    }
    //accepts two ints, returns the gcf
    public static int gcf(int firstNum, int secondNum) {
		int i;
		for (i = firstNum; !(isDivisibleBy(firstNum, i) && isDivisibleBy(secondNum, i)); i--) {	
		}
		return i;
	}
    //accepts two ints, tests if first is divisible by second
    public static boolean isDivisibleBy(int operand, int factor) {
		if (operand % factor == 0) {
			return true;
		} else {
			return false;
		}
	}
    //accepts an int, returns its absolute value
    public static int absValue(int operand) {
		if (operand >= 0) {
			return operand;
		} else {
			return operand * -1;
		}
	}
}