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
import java.sql.*;

public class DDFUsingDB {
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
		Object[][] data=new Object[2][2];

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=ebayDB;integratedsecurity=true");

		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from ebayInput");

		int i=0;
		while(rs.next())
		{
			data[i][0]=rs.getString(1);
			data[i][1]=rs.getString(2);
			i=i+1;
		}

		return data;
	}
}
