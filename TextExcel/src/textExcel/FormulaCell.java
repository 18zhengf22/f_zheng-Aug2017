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
		ArrayList<Double> numbers = new ArrayList<Double>();
		ArrayList<String> operators = new ArrayList<String>();
		for (int i = 0; i < arrFormula.length; i += 2) {
			numbers.add(Double.parseDouble(arrFormula[i]));
			if (i < arrFormula.length - 1) {
				operators.add(arrFormula[i + 1]);
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
