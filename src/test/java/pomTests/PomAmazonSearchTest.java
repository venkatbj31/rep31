package pomTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pomPages.BrowserFactory;
import pomPages.ClsAmazon;

public class PomAmazonSearchTest 
{
  @Test
  public void Search() throws Exception
  {
	  WebDriver driver=BrowserFactory.startBrowser("Chrome", "http://amazon.in");
	  Thread.sleep(3000);
	  
	  ClsAmazon obj=new ClsAmazon(driver);
	  obj.fnLogin("venkatbj@yahoo.com", "admin123");
	  obj.fnSearch("LG");
	  
	  Reporter.log("Amazon Search Test is Successfull...",true);
 
  }
}
