package textExcel;

public class TextCell implements Cell {
	
	private String cellText;
	//constructor
	public TextCell(String cellText) {
		this.cellText = cellText;
	}

	@Override
	public String abbreviatedCellText() {
		String temp = cellText;
		for(int i = cellText.length(); i < 10; i++) {
			temp += " ";
		}
		return temp.substring(0,10);
	}

	@Override
	public String fullCellText() {
		return "\"" + cellText + "\"";
	}

}
