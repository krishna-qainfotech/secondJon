package com.qait.automation.TatocPageObject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookieActions {
	WebDriver driver;
	
	public CookieActions(WebDriver driver) {
		this.driver = driver;
	}
	
	private WebElement getGenerateTokenButton() {
		return driver.findElement(By.linkText("Generate Token"));
	}
	
	private String getToken() {
		getGenerateTokenButton().click();
		String tokenText = driver.findElement(By.id("token")).getText();
		String tokenValue = tokenText.substring(7, tokenText.length());
		return tokenValue;
	}
	
	private void setCookie() {
		Cookie cookie = new Cookie("Token",getToken());
		driver.manage().addCookie(cookie);
	}
	
	public void isgenerateTokenButtonIsPresent() {
		assertTrue(getGenerateTokenButton().isDisplayed());
	}
	
	public void proceedingWithoutAddingCookieTakesToErrorPage() {
		driver.findElement(By.linkText("Proceed")).click();
   		String expectedUrl = "http://10.0.1.86/tatoc/error";
   		assertTrue(expectedUrl.contains(driver.getCurrentUrl()));
      	driver.navigate().back();
	}
	
	public void proceedingAfterAddingCookieTakesToEndPage() {
		setCookie();
		driver.findElement(By.linkText("Proceed")).click();
   		String expectedUrl = "http://10.0.1.86/tatoc/end";
   		assertTrue(expectedUrl.contains(driver.getCurrentUrl()));
	}
	

}
