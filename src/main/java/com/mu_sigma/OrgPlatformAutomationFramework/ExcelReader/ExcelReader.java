package com.mu_sigma.OrgPlatformAutomationFramework.ExcelReader;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	public ExcelReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public String[][] getData(String sheetname, String excelname) {
		String dataset[][] = null;
		try {
			XSSFSheet sheet = workbook.getSheet(sheetname);
			int totalRow = sheet.getLastRowNum() + 1;
			int totalCol = sheet.getRow(0).getLastCellNum();
			dataset = new String[totalRow - 1][totalCol];
			for (int i = 1; i < totalRow; i++) {
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j < totalCol; j++) {
					XSSFCell cell = row.getCell(j);
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						dataset[i - 1][j] = cell.getStringCellValue();
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						//String celltext = String.valueOf(cell.getNumericCellValue());
						String celltext = String.valueOf((int)cell.getNumericCellValue());
						dataset[i - 1][j] = celltext;
					}
					else {
						dataset[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
					}
				}
			}
			return dataset;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataset;
	}

	public String getCellData(String sheetname, String colName, int rownumber) {
		try {

			int col_num = 0;
			int index = workbook.getSheetIndex(sheetname);
			sheet = workbook.getSheetAt(index);
			XSSFRow row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equals(colName)) {
					col_num = i;
					break;
				}
			}
			row = sheet.getRow(rownumber - 1);
			XSSFCell cell = row.getCell(col_num);
			if (cell.getCellType() == cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			}
			else if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	
}
