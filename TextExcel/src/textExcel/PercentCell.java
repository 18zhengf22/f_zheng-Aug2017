package textExcel;

public class PercentCell extends RealCell {
	private String input;
	//constructor
	public PercentCell(String input) {
		super(input);
		this.input = input;
	}

	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fullCellText() {
		return input;
	}

	@Override
	public double getDoubleValue() {
		return Double.parseDouble(input.substring(0, input.length()-1));
	}

}
