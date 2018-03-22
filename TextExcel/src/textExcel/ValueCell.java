package textExcel;

public class ValueCell extends RealCell {
	private String input;

	// constructor
	public ValueCell(String input) {
		super(input);
		this.input = input;
	}

	@Override
	public String abbreviatedCellText() {
		String temp = Double.parseDouble(input) + "";
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
		return Double.parseDouble(input);
	}

}
