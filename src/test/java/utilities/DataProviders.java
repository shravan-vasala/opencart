package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "LoginData")
	public String[][] getData () throws IOException {
		
		String path = ".\\testData\\Opencart_LoginData.xlsx"; //taking xl file from testData
		
		ExcelUtility excelUtil = new ExcelUtility(path);
		
		int totalRows = excelUtil.getRowCount("Sheet1");
		int totalCells = excelUtil.getCellCount("Sheet1", 1);
		
		String[][] loginData = new String[totalRows][totalCells]; //Created for two dimension array which can store the data
		
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCells; j++) {
				loginData[i - 1][j] = excelUtil.getCellData("Sheet1", i, j);
				
			}
		}
		return loginData; // returning two dimension array
	}
}
