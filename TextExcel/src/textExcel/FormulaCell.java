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
		return "Formula...";
	}

	@Override
	public String fullCellText() {
		return input;
	}

	@Override
	public double getDoubleValue() {
		String formula = input.substring(2, input.length()-2);
		
		return 0;
	}

}
