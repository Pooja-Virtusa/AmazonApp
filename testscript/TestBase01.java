package com.qa.testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import com.qa.pages.AmazonApplicationDemoPage;

public class TestBase01 {
	WebDriver driver;
	AmazonApplicationDemoPage amazon;

	@BeforeMethod
	public void Setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\SeleniumTraining\\SeleniumAutomation\\DriverExecutables\\chromedriver.exe");
		driver=new ChromeDriver();
		amazon = new AmazonApplicationDemoPage(driver);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		amazon.clickhelp().click();
		amazon.getEmail().sendKeys("poojadevanaganvi@gmail.com");
		amazon.getContinue().click();
		amazon.getPwd().sendKeys("Pooja3");
		amazon.getSignin().click();
		Thread.sleep(10000);

}
	@AfterMethod
	public void Teardown() {
		driver.quit();
}
}
