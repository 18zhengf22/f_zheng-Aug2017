package fracCalc;

public class Fraction {
	private int whole;
	private int numer;
	private int denom;
	private int sign;
	//constructor that accepts a String (input) 
	public Fraction(String input) {
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
		whole = 0; //whole becomes 0
		numer = denom * whole + numer * sign; //numer changes, denom does not change
	}
	
	public Fraction addSubtract(Fraction secondFrac, String operator) {
		toImproper(); //converts first fraction to improper
		secondFrac.toImproper(); //converts second fraction to improper
		Fraction result = new Fraction("0_0/1");
		result.setDenom(this.denom * secondFrac.getDenom()); //common denom
    		if (operator.equals("+")) { //add
    			result.setNumer(this.numer * secondFrac.getDenom() + secondFrac.getNumer() * this.denom);
    		} else { //subtract
    			result.setNumer(this.numer * secondFrac.getDenom() - secondFrac.getNumer() * this.denom);
    		}
    		return result;
	} 
	
	public Fraction multDivide(Fraction secondFrac, String operator) {
		toImproper(); //converts first fraction to improper
		secondFrac.toImproper(); //converts second fraction to improper
		Fraction result = new Fraction("0_0/1");
		if(operator.equals("*")) { //multiply
    			result.setNumer(this.numer * secondFrac.getNumer());
    			result.setDenom(this.denom * secondFrac.getDenom());
		} else { //divide
			result.setNumer(this.numer * secondFrac.getDenom()); //basically multiplies by reciprocal
			result.setDenom(this.denom * secondFrac.getNumer());
		}
		return result;
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
	
	public void reduce() { 
		whole = numer / denom;
		numer %= denom;
		int gcf = gcf(numer, denom);
		numer /= gcf;
		denom /= gcf;
	}
	
	public static int gcf(int firstNum, int secondNum) {
		int i;
		for(i = firstNum; !(isDivisibleBy(firstNum, i) && isDivisibleBy(secondNum, i)); i--) {	
		}
		return i;
	}
	
	public static boolean isDivisibleBy(int operand, int factor) {
		if(operand % factor == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int absValue(int operand) {
		if(operand >= 0) {
			return operand;
		} else {
			return operand * -1;
		}
	}
}