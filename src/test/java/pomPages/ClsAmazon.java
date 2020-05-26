package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClsAmazon 
{
	public WebDriver wd;
	
	public ClsAmazon(WebDriver d)
	{
		wd=d;
	}
	
	By btnSignIn=By.xpath("//*[@id='nav-link-accountList']/span[1]");
	By txtEmail=By.xpath("//*[@id='ap_email']");
	By btnContinue=By.xpath("//*[@id='continue']");
	By txtPwd=By.xpath("//*[@id='ap_password']");
	By btnLogin=By.xpath("//*[@id='signInSubmit']");
	By txtSearch=By.id("twotabsearchtextbox");
	By btnSearch=By.className("nav-input");
	
	public void fnLogin(String uid,String pwd)
	{
		wd.findElement(btnSignIn).click();
		wd.findElement(txtEmail).sendKeys(uid);
		wd.findElement(btnContinue).click();
		wd.findElement(txtPwd).sendKeys(pwd);
		wd.findElement(btnLogin).click();
	}
	
	public void fnSearch(String prodName)
	{
		wd.findElement(txtSearch).sendKeys(prodName);
		wd.findElement(btnSearch).click();
	}
	
}














