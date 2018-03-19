package textExcel;

public class EmptyCell implements Cell {
	private String cellEmpty;
	public EmptyCell() {
		cellEmpty = "";
	}

	@Override
	public String abbreviatedCellText() { // text for spreadsheet cell display, must be exactly length 10
		return "          ";
	}

	@Override
	public String fullCellText() { // text for individual cell inspection, not truncated or padded
		return "";
	}

}
