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
    		String firstOperand = arrSplit[0];
    		String operator = arrSplit[1];
    		String secondOperand = arrSplit[2];
    		int[] arrFirstOperand = splitOperand(firstOperand);
    		int[] arrSecondOperand = splitOperand(secondOperand);
    		if (operator.equals("+") || operator.equals("-")) {
    			return addSubtract(arrFirstOperand, arrSecondOperand, operator);
    		} else {
    			return "";
    			//return multiplyDivide(arrFirstOperand, arrSecondOperand, operator);
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
    		int[] arrParsedInt = {whole, numer, denom};
    		return arrParsedInt;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String addSubtract(int[] firstOperand, int[] secondOperand, String operator) {
    		int[] firstImproper = toImproper(firstOperand);
    		int[] secondImproper = toImproper(secondOperand);
    		int firstDenom = firstImproper[1];
    		firstImproper[0] *= secondImproper[1];
    		firstImproper[1] *= secondImproper[1];
    		secondImproper[0] *= firstDenom;
    		secondImproper[1] *= firstDenom;
    		int answerNumer = 0;
    		int answerDenom = firstImproper[1];
    		String answer = "";
    		if (operator.equals("+")) {
    			answerNumer = firstImproper[0] + secondImproper[0];
    		} else {
    			answerNumer = firstImproper[0] - secondImproper[0];
    		}
    		answer = answerNumer + "/" + answerDenom;
    		return answer;
    }
    public static int[] toImproper (int[] orig) {
		int[] improper = new int[2];
		int numer = orig[2] * orig[0] + orig[1];
		int denom = orig[2];
		improper[0] = numer;
		improper[1] = denom;
		return improper;
    }
}
