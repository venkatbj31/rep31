package pomTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pomPages.BrowserFactory;
import pomPages.ClsEbay;

public class PomEbayProdCatSearchTest
{
  @Test
  public void CatSearch() 
  {
	  WebDriver driver=BrowserFactory.startBrowser("Chrome", "http://ebay.com");
	  
	  ClsEbay obj=new ClsEbay(driver);
	  obj.fnCatSearch("Cameras & Photo", "Sony");
	  
	  Reporter.log("Ebay Product Search in a Category Test is Successfull...",true); 
  }
}
