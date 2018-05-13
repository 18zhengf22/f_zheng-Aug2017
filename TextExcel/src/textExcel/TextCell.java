/*Frank Zheng
 *APCS2
 *March - April 2017 but actually March - May for me :(
 *TextExcel
 *Spreadsheet program that can do some math
 */

package textExcel;

public class TextCell implements Cell {

	private String cellText;

	// constructor
	public TextCell(String cellText) {
		this.cellText = cellText;
	}

	@Override
	public String abbreviatedCellText() {
		String temp = cellText;
		for (int i = temp.length(); i < 10; i++) {
			temp += " ";
		}
		return temp.substring(0, 10);
	}

	@Override
	public String fullCellText() {
		return "\"" + cellText + "\"";
	}

}
