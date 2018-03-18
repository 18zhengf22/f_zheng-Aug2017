package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	Cell[][] cells;
	//constructor
	public Spreadsheet() {
		cells = new Cell[getRows()][getCols()];
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				cells[i][j] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		//cell inspection
		return getCell(new SpreadsheetLocation(command)).fullCellText(); 
	}

	@Override
	public int getRows()
	{
		return 20;
	}

	@Override
	public int getCols()
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return cells[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		int letter = 65;
		String gridText = "   |";
		for (int i = 0; i < 12; i++) {
			gridText += (char) letter + "         |";
			letter++;
		}
		int number = 1;
		for (int i = 0; i < 20; i++) {
			if(number < 10) {
				gridText += "\n" + number + "  |";
			} else {
				gridText += "\n" + number + " |";
			}
			for (int j = 0; j < 12; j++) {
				gridText += "          |";
			}
			number++;
		}
		return gridText;
	}

}
