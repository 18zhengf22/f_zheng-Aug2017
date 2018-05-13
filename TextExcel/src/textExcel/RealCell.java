/*Frank Zheng
 *APCS2
 *March - April 2017 but actually March - May for me :(
 *TextExcel
 *Spreadsheet program that can do some math
 */

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
