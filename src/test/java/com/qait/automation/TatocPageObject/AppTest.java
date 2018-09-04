package com.qait.automation.TatocPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;

public class AppTest {
	WebDriver driver;
	GridBox gridbox;
	FrameAndDungeon frame_and_dungeon;
	DragAndDropActions drag_and_drop;
	PopupWindowsActions popup_windows;
	CookieActions cookie;

	@BeforeClass
	public void openPage() {
		System.out.println("Uday kumar is a coder");
		String dir = System.getProperty("user.dir");
		System.out.println(System.getProperty("user.dir"));
		String chromedriver= "chromedriver";  		
		System.setProperty("webdriver.chrome.driver", dir+"/"+chromedriver);
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.get("https://hris.qainfotech.com/login.php");
	}

	  @Test
	  public void LoginWithvalidPasswordAndvalidUserName() {
		  driver.findElement(By.cssSelector("#txtUserName")).clear();
		  driver.findElement(By.cssSelector("#txtUserName")).sendKeys("krishnachauhan");
		  driver.findElement(By.cssSelector("#txtPassword")).clear();
		  driver.findElement(By.cssSelector("#txtPassword")).sendKeys("Krishna@321#");
		  driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
	  }
	  @Test(dependsOnMethods= {"LoginWithvalidPasswordAndvalidUserName"})
	  public void checkForPageTitle() {
		  Assert.assertFalse
		  ("QAIT Resource Management Tool ".equals(driver.getTitle()));
	  }
	  @Test(dependsOnMethods= {"checkForPageTitle"})
	  public void checkForPageHeader() {
		  Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),\"Timesheet\")]")).isDisplayed());
	  }
	@Test(dependsOnMethods= {"checkForPageHeader"})
	public void checkForImageofTheuser() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class=\"profile-btn\"]//img")).isDisplayed());
	}
	@Test(dependsOnMethods= {"checkForImageofTheuser"})
	public void isLogoDisplayed() {
	    Assert.assertTrue(driver.findElement(By.cssSelector("[alt=\"logo\"]")).isDisplayed());
	}
	@AfterTest
	public void closePage() {

		//driver.quit();
	}
}
