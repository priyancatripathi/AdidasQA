package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.Base;

public class ProductSelectionPage extends Base {

	public WebDriver driver;
	
	private String categories_Laptop = "//a[text()='Laptops']";
	private String laptops_SonyVaioI5 = "//a[text()='Sony vaio i5']";
	private String laptops_Dell78gb = "//a[contains(text(),'Dell i7 8gb')]";
	private String dellI7_AddToCart = "//a[contains(text(),'Add to cart')]";
	private String homePage_Cart = "cartur";
    private String sonyVaio_AddToCart = "//a[text()='Add to cart']";
    private String productStore_Ele = "//a[@id='nava']";

    public ProductSelectionPage(WebDriver driver2) {
        this.driver=driver2;
    	}
    
    
    
	public void click_categories_Laptop() {
		driver.findElement(By.xpath(categories_Laptop)).click();
	}
	
	public void click_laptops_SonyVaioI5() {
		driver.findElement(By.xpath(laptops_SonyVaioI5)).click();
	}
	
	public void click_sonyVaio_AddToCart() {
		driver.findElement(By.xpath(sonyVaio_AddToCart)).click();
	}
	
	public void click_laptops_Dell78gb() {
		driver.findElement(By.xpath(laptops_Dell78gb)).click();
	}
	
	public void click_DellI7_AddToCart() {
		driver.findElement(By.xpath(dellI7_AddToCart)).click();
	}
	
	public void AddSonyViao_ToCart() {
		WebDriverWait w = new WebDriverWait(driver, 5);
		click_categories_Laptop();
		click_laptops_SonyVaioI5();
		click_sonyVaio_AddToCart();
		w.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		}
	
	public void NavigateBackToHomePage() {
		driver.findElement(By.xpath(productStore_Ele)).click();
	}
	
	public void AddDellI7_ToCart() {
		WebDriverWait w = new WebDriverWait(driver, 5);		
		click_categories_Laptop();
		click_laptops_Dell78gb();
		click_DellI7_AddToCart(); 
		w.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		}
	
	public void NavigateToCart()
	{
		driver.findElement(By.id(homePage_Cart)).click();
	}
	
}
