package Adidas.AdidasTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.PlaceOrderForm;
import PageObjects.ProductCartPage;
import PageObjects.ProductSelectionPage;
import PageObjects.PurchaseConfirmationPage;
import Resources.Base;

public class ProductStoreWebTest extends Base {
	ProductSelectionPage ps;
	ProductCartPage pca;
	PlaceOrderForm po;
	PurchaseConfirmationPage pc;
	
	@BeforeMethod//Using before method for creating objects of classes and  loading the url as it is common in every test case
	public void openBrowser() throws IOException
	{
		
		driver = intitializedriver();
		ps = new ProductSelectionPage(driver);
		pca= new ProductCartPage(driver);
		po = new PlaceOrderForm(driver);
		pc = new PurchaseConfirmationPage(driver);
	   
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void ValidatePurchaseAmnt() throws InterruptedException {
  
		  ps.AddSonyViao_ToCart();
		  ps.NavigateBackToHomePage();
		  ps.AddDellI7_ToCart();
		  ps.NavigateToCart();
		  pca.delete_DellProduct();
		  pca.click_PlaceOrdr();
		  po.FillPlaceOrderForm();
		  String actualId =  pc.get_Msg().substring(3,11);
		  System.out.println(actualId);
		  String actualAmount = pc.get_Msg().trim().substring(20, 27);
		  System.out.println(actualAmount);
		  Assert.assertEquals("790 USD", actualAmount);	
		  pc.click_OkBttn(); 
		}
	
	@AfterMethod//Closing the browser
	public void AfterMethod()
	{
		driver.quit();
	}

}
