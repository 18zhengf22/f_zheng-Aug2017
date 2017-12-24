package fracCalc;

public class Fraction {
	private int whole;
	private int numer;
	private int denom;
	private int sign;
	//constructor that accepts a String (input) 
	public Fraction(String input) { //basically splitOperand
		whole = 0;
		numer = 0;
		denom = 1;
		sign = 1;
		if(input.contains("-")) {
			sign = -1;
		}
		if(input.contains("_")) { //mixed
			whole = Integer.parseInt(input.split("_")[0]);
			numer = Integer.parseInt(input.split("_")[1].split("/")[0]);
			denom = Integer.parseInt(input.split("/")[1]);
		} else if(input.contains("/")) { //fraction or improper
			numer = Integer.parseInt(input.split("/")[0]);
			denom = Integer.parseInt(input.split("/")[1]);
		} else { //only whole, no sign
			whole = absValue(Integer.parseInt(input));
		}
	}
	
	//getters
	public int getWhole() {
		return whole;
	}
	
	public int getNumer() {
		return numer;
	}
	
	public int getDenom() {
		return denom;
	}
	
	//setters
	public void setWhole(int whole) {
		this.whole = whole;
	}
	
	public void setNumer(int numer) {
		this.numer = numer;
	}
	
	public void setDenom(int denom) {
		this.denom = denom;
	}
	
	
	public void toImproper() { //used to convert fractions to improper for ease of calculations
		numer = absValue(denom * whole + numer * sign) * sign;
		whole = 0; //whole becomes 0
		denom = absValue(denom);
	}
	
	public String addSubtract(Fraction secondFrac, String operator) {
		toImproper(); //converts first fraction to improper
		secondFrac.toImproper(); //converts second fraction to improper
		Fraction result = new Fraction("0_0/1");
		result.setDenom(this.denom * secondFrac.getDenom()); //common denom
    		if(operator.equals("+")) { //add
    			result.setNumer(this.numer * secondFrac.getDenom() + secondFrac.getNumer() * this.denom);
    		} else { //subtract
    			result.setNumer(this.numer * secondFrac.getDenom() - secondFrac.getNumer() * this.denom);
    		}
    		if(result.getNumer() == 0) {
    			result.setWhole(0);
    			result.setNumer(0);
    			result.setDenom(1);
    		}
    		return reduce(result);
	} 
	
	public String multDivide(Fraction secondFrac, String operator) {
		toImproper(); //converts first fraction to improper
		secondFrac.toImproper(); //converts second fraction to improper
		Fraction result = new Fraction("0_0/1");
		if(operator.equals("*")) { //multiply
    			result.setNumer(this.numer * secondFrac.getNumer());
    			result.setDenom(this.denom * secondFrac.getDenom());
		} else { //divide
			result.setNumer(this.numer * secondFrac.getDenom()); //basically multiplies by reciprocal
			result.setDenom(this.denom * secondFrac.getNumer());
			if(result.getDenom() < 0 && result.getNumer() > 0) { //makes sure negative sign is with numerator instead of denominator
				result.setNumer(result.getNumer() * -1);
				result.setDenom(result.getDenom() * -1);
			}
		}
		if(result.getDenom() == 0) {
			return "ERROR";
		} else {
		return reduce(result);
		}
	}
	
	public String reduce(Fraction result) {
		if(result.getNumer() < 0 && result.getDenom() < 0) { //make positive if -/-
			result.setNumer(absValue(result.getNumer()));
			result.setDenom(absValue(result.getDenom()));
		} if(result.getNumer() % result.getDenom() == 0) { //simplify to whole if numer divisible by denom
			result.setWhole(result.getNumer() / result.getDenom());
			result.setNumer(0);
		} else if(absValue(result.getNumer()) > absValue(result.getDenom())) { //convert to mixed if improper
			result.setWhole(result.getNumer() / result.getDenom());
			result.setNumer(absValue(result.getNumer() % result.getDenom()));
			result.setDenom(absValue(result.getDenom()));
		}
		int gcf = gcf(result.getNumer(), result.getDenom());
		if(gcf != 0) {
			result.setNumer(result.getNumer() / gcf);
			result.setDenom(absValue(result.getDenom() / gcf));
		}
		return result.toString();
	}
	
	public String toString() { //answer is
		if(this.numer == 0) { //just whole if numer is 0
			return this.whole + "";
		} else if(this.whole == 0) { //fraction if whole is 0
			return numer + "/" + denom;
		} else { //mixed if no components are 0
			return whole + "_" + numer + "/" + denom;
		}
	}
	
	public static int gcf(int firstNum, int secondNum) {
		firstNum = absValue(firstNum);
		secondNum = absValue(secondNum);
		if(firstNum == 0 || secondNum == 0) {
			return 0;
		}
		while (secondNum != 0) {
			if(firstNum > secondNum) {
				firstNum -= secondNum;
			} else {
				secondNum -= firstNum;
			}
		}
		return firstNum;
	}
	
	public static int absValue(int operand) {
		if(operand >= 0) {
			return operand;
		} else {
			return operand * -1;
		}
	}
}