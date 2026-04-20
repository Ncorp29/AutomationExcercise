package utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private String path;
	
	public ExcelUtility(String path)
	{
		this.path=path;
	}
		
	public int getRowCount(String sheetName) throws IOException 
	{
		try (FileInputStream fi = new FileInputStream(path);
			 XSSFWorkbook workbook = new XSSFWorkbook(fi)) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowcount=sheet.getLastRowNum();
			return rowcount;
		}
	}
	
	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		try (FileInputStream fi = new FileInputStream(path);
			 XSSFWorkbook workbook = new XSSFWorkbook(fi)) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row=sheet.getRow(rownum);
			int cellcount=row.getLastCellNum();
			return cellcount;
		}
	}
	
	
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		try (FileInputStream fi = new FileInputStream(path);
			 XSSFWorkbook workbook = new XSSFWorkbook(fi)) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row=sheet.getRow(rownum);
			XSSFCell cell=row.getCell(colnum);
			
			DataFormatter formatter = new DataFormatter();
			String data;
			try{
			data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
			}
			catch(Exception e)
			{
				data="";
			}
			return data;
		}
	}
	
	public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())    // If file not exists then create new file
		{
			try (XSSFWorkbook workbook=new XSSFWorkbook();
				 FileOutputStream fo=new FileOutputStream(path)) {
				workbook.write(fo);
			}
		}
				
		try (FileInputStream fi=new FileInputStream(path);
			 XSSFWorkbook workbook=new XSSFWorkbook(fi)) {
			
			if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
				workbook.createSheet(sheetName);
			XSSFSheet sheet=workbook.getSheet(sheetName);
						
			if(sheet.getRow(rownum)==null)   // If row not exists then create new Row
					sheet.createRow(rownum);
			XSSFRow row=sheet.getRow(rownum);
			
			XSSFCell cell=row.createCell(colnum);
			cell.setCellValue(data);
			try (FileOutputStream fo=new FileOutputStream(path)) {
				workbook.write(fo);
			}
		}
	}
	
	
	public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException
	{
		try (FileInputStream fi=new FileInputStream(path);
			 XSSFWorkbook workbook=new XSSFWorkbook(fi);
			 FileOutputStream fo=new FileOutputStream(path)) {
			XSSFSheet sheet=workbook.getSheet(sheetName);
			
			XSSFRow row=sheet.getRow(rownum);
			XSSFCell cell=row.getCell(colnum);
			
			CellStyle style=workbook.createCellStyle();
			
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
					
			cell.setCellStyle(style);
			workbook.write(fo);
		}
	}
	
	
	public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException
	{
		try (FileInputStream fi=new FileInputStream(path);
			 XSSFWorkbook workbook=new XSSFWorkbook(fi);
			 FileOutputStream fo=new FileOutputStream(path)) {
			XSSFSheet sheet=workbook.getSheet(sheetName);
			XSSFRow row=sheet.getRow(rownum);
			XSSFCell cell=row.getCell(colnum);
			
			CellStyle style=workbook.createCellStyle();
			
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
			
			cell.setCellStyle(style);		
			workbook.write(fo);
		}
	}
	
}