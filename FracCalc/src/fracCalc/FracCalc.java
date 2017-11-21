/*Frank Zheng
 *November 2017
 *FracCalc
 *Fraction calculator that can add, subtract, multiply, or divide two fractions
 */
package fracCalc;

import java.util.*;

public class FracCalc {

    public static void main(String[] args) {
    		Scanner userInput = new Scanner(System.in);
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
    		if (operator.equals("+") || operator.equals("-")) {
    			return addSubtract(arrFirstOperand, arrSecondOperand, operator);
    		} else {
    			return multiplyDivide(arrFirstOperand, arrSecondOperand, operator);
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
    		numer = denom * whole + numer;
    		int[] arrImprOperand = {numer, denom};
    		return arrImprOperand;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String addSubtract(int[] firstOperand, int[] secondOperand, String operator) {
    		int answerNumer = 0;
    		int answerDenom = firstOperand[1] * secondOperand[1];
    		int newFirstNumer = firstOperand[0] * secondOperand[1];
    		int newSecondNumer = secondOperand[0] * firstOperand[1];
    		if (operator.equals("+")) {
    			answerNumer = newFirstNumer + newSecondNumer;
    		} else {
    			answerNumer = newFirstNumer - newSecondNumer;
    		}
    		String answer = answerNumer + "/" + answerDenom;
    		return answer;
    }
    public static String multiplyDivide (int[] firstOperand, int[] secondOperand, String operator) {
    		int answerNumer = 0;
    		int answerDenom = 1;
    		if (operator.equals("*")) {
    			answerNumer = firstOperand[0] * secondOperand[0];
    			answerDenom = firstOperand[1] * secondOperand[1];
    		} else {
    			answerNumer = firstOperand[0] * secondOperand[1];
    			answerDenom = firstOperand[1] * secondOperand[0];
    		}
    		String answer = answerNumer + "/" + answerDenom;
    		return answer;
    }
}
