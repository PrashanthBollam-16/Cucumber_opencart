package utilites;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

	public static HashMap<String,String> storevalues = new HashMap<>();
	public static List<HashMap<String,String>> data(String filepath,String sheetname)
	{
		List<HashMap<String,String>> mydata=new ArrayList<>();
		
		try
		{
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook =new XSSFWorkbook(fs);
			XSSFSheet sheet=workbook.getSheet(sheetname);
			XSSFRow HeaderRow=sheet.getRow(0);
			for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
			{
				XSSFRow CurrentRow=sheet.getRow(i);
				HashMap<String,String> currentHash = new HashMap<String,String>();
				for(int j=0;j<CurrentRow.getPhysicalNumberOfCells();j++)
				{
					XSSFCell currentCell=CurrentRow.getCell(j);
					switch(currentCell.getCellType())
					{
					case STRING:
						currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
						break;
					}
				}
				mydata.add(currentHash);
			}
			fs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return mydata;
		
	}
	
}
