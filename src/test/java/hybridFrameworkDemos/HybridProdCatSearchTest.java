package hybridFrameworkDemos;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pomPages.BrowserFactory;
import pomPages.ClsEbay;
import pomPages.ClsTestData;

public class HybridProdCatSearchTest {
	@Test(dataProvider = "ebayData")
	  public void Search(String ddValue,String txtValue) 
	  {
		  WebDriver driver=BrowserFactory.startBrowser("Chrome", "http://ebay.com");
		  ClsEbay obj=new ClsEbay(driver);
		  obj.fnCatSearch(ddValue, txtValue);
		  	  
		  Reporter.log("'" + txtValue + "' Product Search in '" + ddValue + "' Category Test is Successfull..",true);
	  }

	  @DataProvider
	  public Object[][] ebayData() throws Exception
	  {
		  Object[][] data=ClsTestData.getExcelData(System.getProperty("user.dir") + "//TestData//DDFEbayInput.xlsx");		  
		  return data;
	  }
	}
