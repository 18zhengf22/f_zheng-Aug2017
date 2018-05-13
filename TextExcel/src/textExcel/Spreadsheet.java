/*Frank Zheng
 *APCS2
 *March - April 2017 but actually March - May for me :(
 *TextExcel
 *Spreadsheet program that can do some math
 */

package textExcel;

public class Spreadsheet implements Grid {
	private Cell[][] cells;

	// constructor
	public Spreadsheet() {
		cells = new Cell[getRows()][getCols()];
		clearSheet();
	}

	@Override
	public String processCommand(String command) {
		// cell inspection
		if (command.length() == 2 || command.length() == 3) {
			Location loc = new SpreadsheetLocation(command.toUpperCase());
			return inspectCell(loc);
		} else

		// percent assignment
		if (command.endsWith("%")) {
			assignCell(command);
			return getGridText();
		} else

		// string assignment
		if (command.endsWith("\"")) {
			assignCell(command);
			return getGridText();
		} else

		// formula assignment
		if (command.endsWith(" )")) {
			assignCell(command);
			return getGridText();
		}

		// real value assignment
		if (command.contains("=")) {
			assignCell(command);
			return getGridText();
		}

		// clearing the entire sheet
		if (command.toLowerCase().equals("clear")) {
			clearSheet();
			return getGridText();
		} else

		// clearing a particular cell
		if (command.toLowerCase().startsWith("clear") && command.length() > 7) {
			Location loc = new SpreadsheetLocation(command.substring(6).toUpperCase());
			clearCell(loc);
			return getGridText();
		} else {
			return "";
		}

	}

	@Override
	public int getRows() {
		return 20;
	}

	@Override
	public int getCols() {
		return 12;
	}

	@Override
	public Cell getCell(Location loc) {
		return cells[loc.getRow()][loc.getCol()];
	}
	
	public Cell getCell(int i, int j) { // used in FormulaCell's SUM
		return cells[i][j];
	}

	@Override
	public String getGridText() {
		// header
		int letter = 65;
		String gridText = "   |";
		for (int i = 0; i < 12; i++) {
			gridText += (char) letter + "         |";
			letter++;
		}

		int number = 1;
		for (int i = 0; i < 20; i++) {
			if (number < 10) {
				gridText += "\n" + number + "  |";
			} else {
				gridText += "\n" + number + " |";
			}
			for (int j = 0; j < 12; j++) {
				gridText += cells[i][j].abbreviatedCellText() + "|";
			}
			number++;
		}
		gridText += "\n";
		return gridText;
	}

	public String inspectCell(Location loc) {
		return getCell(loc).fullCellText();
	}

	public void assignCell(String input) {
		Location loc = new SpreadsheetLocation(input.split(" ")[0].toUpperCase());
		String assignment = input.split(" ", 3)[2];
		if (input.endsWith("\"")) {
			assignment = input.split(" ", 3)[2].substring(1, input.split(" ", 3)[2].length() - 1);
			cells[loc.getRow()][loc.getCol()] = new TextCell(assignment);
		} else if (input.endsWith("%")) {
			cells[loc.getRow()][loc.getCol()] = new PercentCell(assignment);
		} else if (input.endsWith(" )")) {
			cells[loc.getRow()][loc.getCol()] = new FormulaCell(assignment, this);
		} else {
			cells[loc.getRow()][loc.getCol()] = new ValueCell(assignment);
		}
	}

	public void clearSheet() {
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				cells[i][j] = new EmptyCell();
			}
		}
	}

	public void clearCell(Location loc) {
		cells[loc.getRow()][loc.getCol()] = new EmptyCell();
	}
}
