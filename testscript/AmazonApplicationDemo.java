package com.qa.testscript;


import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

public class AmazonApplicationDemo extends TestBase01 {
	
	@Test(dataProvider = "getData")
	//Function to validate add product to cart and delete
	public void verifyAmazonAddToCart_DeleteFunctionality(String Input) throws InterruptedException
	{
		amazon.getSearch().clear();
		amazon.getSearch().sendKeys(Input);
		amazon.getSearchIcon().click();
		amazon.getImage().click();
		amazon.getImage1().click();
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator(); 
		it.next();
		String childId=it.next();//To get the child window id
		driver.switchTo().window(childId);
		amazon.clickBuyAllOptionsBtn().click();
		amazon.clickAddToCartBtn().click();
		amazon.validateShoppingCartPageTitle();
		Thread.sleep(3000);
	}
	@DataProvider
	public String[][] getData() throws IOException {
		String xlPath="F:\\SeleniumTraining\\SeleniumAutomation\\src\\test\\java\\com\\qa\\TestData\\TestData.xlsx";
		String xlSheet="Sheet1";
		int rowCount = ExcelUtility.getRowCount(xlPath, xlSheet);
		int cellCount = ExcelUtility.getCellCount(xlPath, xlSheet, rowCount);
		String[][] data = new String[rowCount][cellCount];	
		for(int i=1;i < rowCount+1;i++) {
			for(int j=0;j < cellCount;j++) {
				data[i-1][j] = ExcelUtility.getCellData(xlPath, xlSheet, i, j);
			}
		}
		return data;
		
	}
}

