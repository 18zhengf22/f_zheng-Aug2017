package textExcel;

public class TextCell implements Cell {
	
	private String strInput;
	public TextCell(String strInput) {
		this.strInput = strInput;
	}

	@Override
	public String abbreviatedCellText() {
		while(strInput.length() < 10) {
			strInput += " ";
		}
		return strInput.substring(0, 10);
	}

	@Override
	public String fullCellText() {
		return "\"" + strInput + "\"";
	}

}
