package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.Base;

public class ProductCartPage extends Base {
	
	public WebDriver driver;
	
	private String dellI7_Delete = "//tbody/tr[1]/td[4]/a[1]";
	private String sonyviao_Delete = "//a[contains(text(),'Delete')]";
	private String plcOrdr_Bttn = "//button[contains(text(),'Place Order')]";
	
	public ProductCartPage(WebDriver driver2) {
        this.driver=driver2;
    	}
	
	public void delete_DellProduct() {
	driver.findElement(By.xpath(dellI7_Delete)).click();	
	}
	
	public void click_PlaceOrdr() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath(plcOrdr_Bttn)).click();
	}

}
