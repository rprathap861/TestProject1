package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelreader {
	
	private String filepath;
	private Workbook workbook;
	
	public Excelreader(String filepath) throws IOException {
		this.filepath = filepath;
		FileInputStream fis = new FileInputStream(filepath);
		workbook = WorkbookFactory.create(fis); 
		
	}
	public String getCellData(String sheetName, int rowNum, int colNum) {
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);
		return cell.toString();
		
		
	}

}
