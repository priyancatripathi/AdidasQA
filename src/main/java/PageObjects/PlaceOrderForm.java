package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.Base;
import Resources.Xls_Reader;

public class PlaceOrderForm extends Base {

	public WebDriver driver;
	
	Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir")+"\\PlaceOrderFormDetails.xlsx");
	
	public PlaceOrderForm(WebDriver driver2) {
        this.driver=driver2;
    	}
	
	private String form_Name = "name";
	private String form_Country = "country";
	private String form_City = "city";
	private String form_CreditCard = "card";
	private String form_Month = "month";
	private String form_Year = "year";
	private String purchase_Button= "//button[text()='Purchase']";
	
	public void fill_Name(String name)
	{
		driver.findElement(By.id(form_Name)).sendKeys(name);
	}
	
	public void fill_Country(String country)
	{
		driver.findElement(By.id(form_Country)).sendKeys(country);
	}
	
	public void fill_City(String city)
	{
		driver.findElement(By.id(form_City)).sendKeys(city);
	}
	
	public void fill_CreditCard(String card)
	{
		driver.findElement(By.id(form_CreditCard)).sendKeys(card);
	}
	
	public void fill_Month(String month)
	{
		driver.findElement(By.id(form_Month)).sendKeys(month);
	}
	
	public void fill_Year(String year)
	{
		driver.findElement(By.id(form_Year)).sendKeys(year);
	}
	
	public void click_Purchase_Bttn()
	{
		driver.findElement(By.xpath(purchase_Button)).click();
	}
	public void FillPlaceOrderForm() throws InterruptedException
	{
		fill_Name(excel.getCellData("place_order_details", "Name", 2));
		fill_Country(excel.getCellData("place_order_details", "Country", 2));
		fill_City(excel.getCellData("place_order_details", "City", 2));
		fill_CreditCard(excel.getCellData("place_order_details", "Creditcard", 2));
		fill_Month(excel.getCellData("place_order_details", "Month", 2));
		fill_Year(excel.getCellData("place_order_details", "Year", 2));
		click_Purchase_Bttn();
		
	 }
	
}
	