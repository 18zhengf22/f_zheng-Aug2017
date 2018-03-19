package textExcel;

public class ValueCell extends RealCell {
	private String input;
	//constructor
	public ValueCell(String input) {
		super(input);
		this.input = input;
	}

	@Override
	public String abbreviatedCellText() {
		return null;
	}

	@Override
	public String fullCellText() {
		return input;
	}

	@Override
	public double getDoubleValue() {
		return Double.parseDouble(input);
	}

}
