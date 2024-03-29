package com.shopping.demo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_reader {
	
	public static final Logger logger  = Logger.getLogger(Excel_reader.class.getName());

	public String[][] getExcelData(String excellocation, String sheetName) {
		try {
			logger.info("Creating excel object:-"+excellocation);
			String dataSets[][] = null;
			
			FileInputStream file = new FileInputStream(new File(excellocation));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active tows
			int totalRow = sheet.getLastRowNum() + 1;
			// count number of active columns in row
			int totalColumn = sheet.getRow(0).getLastCellNum();
			// Create array of rows and column
			dataSets = new String[totalRow-1][totalColumn];
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();

			int i = 0;
			int t = 0;
			
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (i++ != 0) {
					int k = t;
					t++;
					// For each row, iterate through all the columns
					Iterator<Cell> cellIterator = row.cellIterator();
					int j = 0;
					while (cellIterator.hasNext()) {

						Cell cell = cellIterator.next();
						// Check the cell type and format accordingly
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							System.out.print(k+",");
							System.out.print(j+",");
							dataSets[k][j++] = cell.getStringCellValue();
							System.out.println(cell.getNumericCellValue());
							break;
						case Cell.CELL_TYPE_STRING:
							System.out.print(k+",");
							System.out.print(j+",");
							dataSets[k][j++] = cell.getStringCellValue();
							System.out.println(cell.getStringCellValue());
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							System.out.print(k+",");
							System.out.print(j+",");
							dataSets[k][j++] = cell.getStringCellValue();
							System.out.println(cell.getStringCellValue());
							break;
						case Cell.CELL_TYPE_FORMULA:
							System.out.print(k+",");
							System.out.print(j+",");
							dataSets[k][j++] = cell.getStringCellValue();
							System.out.println(cell.getStringCellValue());
							break;
						}
					}
					System.out.println("");
				}
			}

			file.close();
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getDataWithColumnName(String excellocation, String sheetName, String ColumnName){
		String[][] data = getExcelData(excellocation,sheetName);
		int i=0, j=1;
		while(i<data.length){
			if(data[0][i].toString().equals(ColumnName)){
				break;
			}
			i++;
		}
		return data[j][i];
	}

}
