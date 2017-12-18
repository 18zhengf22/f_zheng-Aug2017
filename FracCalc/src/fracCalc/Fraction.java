package fracCalc;

public class Fraction {
	private int whole;
	private int numer;
	private int denom;
	private int sign;
//constructor
	public Fraction(int whole, int numer, int denom) {
		this.whole = whole;
		this.numer = numer;
		this.denom = denom;
	}
	
	public String toString() {
		return "whole:" + whole + " numerator:" + numer + " denominator:" + denom;
	}
}