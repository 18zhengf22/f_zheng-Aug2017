package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String cellName;
	//constructor
	public SpreadsheetLocation(String cellName) {
		this.cellName = cellName;
	}
	
    @Override
    public int getRow()
    {
        return Integer.parseInt(cellName.substring(1)) - 1;
    }

    @Override
    public int getCol()
    {
        return cellName.charAt(0) - 65;
    }

}
