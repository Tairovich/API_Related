package com.app.utilities;

import java.util.List;
import java.util.Map;

public class TestingExcelUtils {

	public static void main(String[] args) {
		
		//open the file and create utility object which holds the our excel data
		ExcelUtils excelObject = new ExcelUtils("src/test/resources/com/prestashop/test-data/Products.xlsx", "Sheet1");
		
		System.out.println("Number of columns: " + excelObject.columnCount());
		System.out.println("Number of rows: " + excelObject.rowCount());
		
		//method to get all column names
		List<String> columnName = excelObject.getColumnsNames();
		System.out.println(columnName);
		
		//get all data in nested array
		String[][] dataArray = excelObject.getDataArray();
		for (String[] row : dataArray) {
			for (String value : row) {
				System.out.print(value + "\t");
			}
			System.out.println();
		}
		System.out.println();
		
		List<Map<String, String>> dataList = excelObject.getDataList();
		
		System.out.println(dataList);
		for (Map<String, String> row : dataList) {
			System.out.println(row);
		}	
		//name of the proudct in the 3rd row
		System.out.println("Name of the product in the 3rd row");
		System.out.println(dataList.get(0).get("Price"));
		
		System.out.println("-----------------");
		//get data by index
		System.out.println(excelObject.getCellData(0, 0));
		
		
		
		
	}
}
