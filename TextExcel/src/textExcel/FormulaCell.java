package textExcel;

import java.util.ArrayList;

public class FormulaCell extends RealCell {

	private Spreadsheet spreadsheet;

	// constructor
	public FormulaCell(String input, Spreadsheet spreadsheet) {
		super(input);
		this.spreadsheet = spreadsheet;
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
		String formula = input.substring(2, input.length() - 2).toUpperCase();
		String[] arrFormula = formula.split(" ");
		ArrayList<String> operands = new ArrayList<String>(); // ArrayList to store operands (numbers, cell references)
		ArrayList<String> operators = new ArrayList<String>(); // ArrayList to store operators (+, -, *, /)
		ArrayList<Double> numbers = new ArrayList<Double>(); // ArrayList to store numeric value of operands
		if (arrFormula[0].equals("SUM") || arrFormula[0].equals("AVG")) {
			for (char col = arrFormula[1].charAt(0); col <= arrFormula[1].charAt(arrFormula[1].indexOf("-") + 1); col++) {
				for (int row = Integer.parseInt(arrFormula[1].substring(1, arrFormula[1].indexOf("-"))); row <= Integer.parseInt(arrFormula[1].substring(arrFormula[1].indexOf("-") + 2)); row++) {
					operands.add("" + col + row);
					operators.add("+");
				}
			}
			operators.remove(0);
		} else {
			for (int i = 0; i < arrFormula.length; i += 2) {
				operands.add(arrFormula[i]);
				if (i < arrFormula.length - 1) { // so it doesn't look for an operator after the last operand
					operators.add(arrFormula[i + 1]);
				}
			}
		}
		for (int i = 0; i < operands.size(); i++) {
			// Checks whether it is a SpreadsheetLocation or a number
			if (Character.isLetter(operands.get(i).charAt(0))) {
				RealCell c = (RealCell) spreadsheet.getCell(new SpreadsheetLocation(operands.get(i).toUpperCase()));
				numbers.add(c.getDoubleValue());
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
		if (arrFormula[0].equals("AVG")) {
			return temp / numbers.size();
		}
		return temp;
	}

}
