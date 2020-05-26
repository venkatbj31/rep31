package pomTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pomPages.BrowserFactory;
import pomPages.ClsAmazon;

public class PomAmazonLoginTest
{
  @Test
  public void login() throws Exception
  {
	  WebDriver driver=BrowserFactory.startBrowser("Chrome", "http://amazon.in");
	  Thread.sleep(3000);
	  
	  ClsAmazon obj=new ClsAmazon(driver);
	  obj.fnLogin("venkatbj@yahoo.com", "admin123");
	  
	  Reporter.log("Amazon Login Test is Successfull...",true);
 
  }
}
