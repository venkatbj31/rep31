package pomTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pomPages.BrowserFactory;
import pomPages.ClsEbay;

public class PomEbayProdSearchTest
{
  @Test
  public void Search() 
  {
	  WebDriver driver=BrowserFactory.startBrowser("Chrome", "http://ebay.com");
	  
	  ClsEbay obj=new ClsEbay(driver);
	  obj.fnSearch("Sony");
	  
	  Reporter.log("Ebay Product Search Test is Successfull...",true);
  }
}
