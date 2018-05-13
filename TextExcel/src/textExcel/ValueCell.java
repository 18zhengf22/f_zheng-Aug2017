/*Frank Zheng
 *APCS2
 *March - April 2017 but actually March - May for me :(
 *TextExcel
 *Spreadsheet program that can do some math
 */

package textExcel;

public class ValueCell extends RealCell {

	// constructor
	public ValueCell(String input) {
		super(input);
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
