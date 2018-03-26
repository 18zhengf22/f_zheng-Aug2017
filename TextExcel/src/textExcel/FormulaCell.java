package textExcel;

public class FormulaCell extends RealCell {
	private String input;

	// constructor
	public FormulaCell(String input) {
		super(input);
		this.input = input;
	}

	@Override
	public String abbreviatedCellText() {
		return getDoubleValue() + "";
	}

	@Override
	public String fullCellText() {
		return input;
	}

	@Override
	public double getDoubleValue() {
		String formula = input.substring(2, input.length() - 2);
		String[] arrFormula = formula.split(" ");
		Double[] numbers = new Double[arrFormula.length / 2];
		String[] operators = new String[arrFormula.length / 2];
		int count = 0;
		for (int i = 0; i < arrFormula.length / 2; i += 2) {
			numbers[count] = Double.parseDouble(arrFormula[i]);
			operators[count] = arrFormula[i + 1];
			count++;
		}
		double temp = 0;
		count = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			temp = numbers[i];
			if (operators[count].equals("+")) {
				temp += numbers[i + 1];
			} else if (operators[count].equals("-")) {
				temp -= numbers[i - 1];
			} else if (operators[count].equals("*")) {
				temp *= numbers[i + 1];
			} else if (operators[count].equals("/")) {
				temp /= numbers[i + 1];
			}
			count++;
		}
		return temp;
	}

}
