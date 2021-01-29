package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Resources.Base;

public class PurchaseConfirmationPage extends Base {
	
	public WebDriver driver;
	
	private String confirm_OKBttn = "//button[contains(text(),'OK')]";
	private String cnfrm_Msg = "//body/div[10]/p[1]";
	

	public PurchaseConfirmationPage(WebDriver driver2) {
        this.driver=driver2;
    	}
	public String get_Msg()
	{
	  String msg = 	driver.findElement(By.xpath(cnfrm_Msg)).getText();
	  return msg;
	}
	
	public void click_OkBttn()
	{
		driver.findElement(By.xpath(confirm_OKBttn)).click();
	}
	
	

}
