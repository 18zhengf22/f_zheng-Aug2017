package textExcel;

public class PercentCell extends RealCell {
	private String input;

	// constructor
	public PercentCell(String input) {
		super(input);
		this.input = input;
	}

	@Override
	public String abbreviatedCellText() {
		String temp = (int) Double.parseDouble(input.substring(0, input.length() - 1)) + "%";
		for (int i = temp.length(); i < 10; i++) {
			temp += " ";
		}
		return temp.substring(0, 10);
	}

	@Override
	public String fullCellText() {
		return getDoubleValue() + "";
	}

	@Override
	public double getDoubleValue() {
		return Double.parseDouble(input.substring(0, input.length() - 1)) / 100.0;
	}

}
