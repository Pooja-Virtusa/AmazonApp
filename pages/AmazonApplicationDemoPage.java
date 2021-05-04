package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AmazonApplicationDemoPage {
	WebDriver driver;
	
	
	
	public AmazonApplicationDemoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

}
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement Help;
	public WebElement clickhelp() {
		return Help;
}
	@FindBy(id="ap_email")
	WebElement email;
	public WebElement getEmail() {
		return email;
}
	
	@FindBy(id="ap_password")
	WebElement pwd;
	public WebElement getPwd() {
		return pwd;
}
	@FindBy(id="continue")
	WebElement continuebtn;
	public WebElement getContinue() {
		return continuebtn;
	}

	@FindBy(id="signInSubmit")
	WebElement signinbtn;
	public WebElement getSignin() {
		return signinbtn;
	
}
	@FindBy(id="twotabsearchtextbox")
	WebElement search;
	public WebElement getSearch() {	
		String expectedValue=driver.getTitle();
		System.out.println(expectedValue);
		Assert.assertEquals(expectedValue, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		return search;
}
	@FindBy(id="nav-search-submit-button")
	WebElement searchIcon;
	public WebElement getSearchIcon() {
		return searchIcon;
}
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div[2]/div[1]/div/div/span/a/div/img")
	WebElement img;
	public WebElement getImage() {
		return img;
}
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[3]/div/span/div/div/div[2]/div[1]/div/div/span/a/div/img")
	WebElement img1;
	public WebElement getImage1() {
		return img1;
}
	
	
	@FindBy(xpath="//a[contains(@title,'See All Buying Options') and @role='button']")
	WebElement btnBuyAllOptions;
	public WebElement clickBuyAllOptionsBtn() throws InterruptedException {
		return btnBuyAllOptions;
	}
	
	
	/*
	 * @FindBy(xpath="") WebElement txtProductName; public WebElement
	 * validateProductName() {
	 * 
	 * return btnAddToCart; }
	 */
	@FindBy(xpath="//input[contains(@name,'submit.addToCart')]")
	WebElement btnAddToCart;
	public WebElement clickAddToCartBtn() {
		return btnAddToCart;
	}
	
	@FindBy(xpath="//*[@id=\"sc-active-cart\"]/div/div[1]/div[1]/h1")
	WebElement titleShoppingCart;
	public WebElement validateShoppingCartPageTitle() {
		try {
			driver.findElement(By.id("hlb-view-cart-announce")).click();//Clicks on Cart button
			Assert.assertEquals(titleShoppingCart.getText(),"Shopping Cart");
			driver.findElement(By.xpath("(//input[contains(@name,'submit.delete')])[1]")).click();//Deletes first product from the cart
			System.out.println("Product successfully deleted from the Cart");
			
			  }catch(Exception e) { 
				  System.out.println(e.getMessage());
			  }
			 
			return titleShoppingCart;

	}
	
	
	
}
