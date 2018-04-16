package textExcel;

public abstract class RealCell implements Cell {
	protected String input;

	// constructor
	public RealCell(String input) {
		this.input = input;
	}

	public abstract String abbreviatedCellText();

	public abstract String fullCellText();

	public abstract double getDoubleValue();

}
