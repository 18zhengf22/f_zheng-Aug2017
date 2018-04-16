package textExcel;

import java.util.ArrayList;

public class FormulaCell extends RealCell {
	private String input;

	// constructor
	public FormulaCell(String input) {
		super(input);
		this.input = input;
	}

	@Override
	public String abbreviatedCellText() {
		String temp = getDoubleValue() + "";
		for (int i = temp.length(); i < 10; i++) {
			temp += " ";
		}
		return temp.substring(0, 10);
	}

	@Override
	public String fullCellText() {
		return input;
	}

	@Override
	public double getDoubleValue() {
		String formula = input.substring(2, input.length() - 2);
		String[] arrFormula = formula.split(" ");
		ArrayList<String> operands = new ArrayList<String>(); //ArrayList to store operands (numbers, cell references)
		ArrayList<String> operators = new ArrayList<String>(); //ArrayList to store operators (+, -, *, /)
		ArrayList<Double> numbers = new ArrayList<Double>(); //ArrayList to store numeric value of operands
		for (int i = 0; i < arrFormula.length; i += 2) {
			operands.add(arrFormula[i]);
			if (i < arrFormula.length - 1) {
				operators.add(arrFormula[i + 1]);
			}
		}
		for (int i = 0; i < operands.size(); i++) {
			if (Character.isLetter(operands.get(i).charAt(0))) {
				Location loc = new SpreadsheetLocation(operands.get(i));
				//get the stuff in that location
			} else {
				numbers.add(Double.parseDouble(operands.get(i)));
			}
		}
		double temp = numbers.get(0);
		for (int i = 0; i < operators.size(); i++) {
			if (operators.get(i).equals("+")) {
				temp += numbers.get(i + 1);
			} else if (operators.get(i).equals("-")) {
				temp -= numbers.get(i + 1);
			} else if (operators.get(i).equals("*")) {
				temp *= numbers.get(i + 1);
			} else if (operators.get(i).equals("/")) {
				temp /= numbers.get(i + 1);
			}
		}
		return temp;
	}

}
