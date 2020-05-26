package dataDrivenFrameworkDemos;

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

public class DDFProdCatSearchTest 
{
	@Test(dataProvider = "ebayData")
	  public void Search(String ddValue,String txtValue) 
	  {
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("http://ebay.com");
		  
		  WebElement dd=driver.findElement(By.id("gh-cat"));
		  Select s=new Select(dd);
		  s.selectByVisibleText(ddValue);
		  
		  driver.findElement(By.id("gh-ac")).sendKeys(txtValue);
		  driver.findElement(By.id("gh-btn")).click();
		  	  
		  Reporter.log("'" + txtValue + "' Product Search in '" + ddValue + "' Category Test is Successfull..",true);
	  }

	  @DataProvider
	  public Object[][] ebayData() throws Exception
	  {
		  Object[][] data=null;
		  
		  XSSFWorkbook wb=new XSSFWorkbook(System.getProperty("user.dir") + "//TestData//DDFEbayInput.xlsx");
		  XSSFSheet ws=wb.getSheet("Sheet1");
		  int rows=ws.getPhysicalNumberOfRows();
		  
		  data=new Object[rows][2];
		  
		  for(int i=0;i<rows;i++)
		  {
			  data[i][0]=ws.getRow(i).getCell(0).getStringCellValue();
			  data[i][1]=ws.getRow(i).getCell(1).getStringCellValue();
		  }
		  
		  return data;
	  }
	}
