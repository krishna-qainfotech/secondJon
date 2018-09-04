package com.qait.automation.TatocPageObject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameAndDungeon {
	WebDriver driver;
	
	public FrameAndDungeon(WebDriver driver) {
		this.driver = driver;
	}
	
	private String getColorOfBox1() {
		driver.switchTo().frame("main");
		String color_of_box1 = driver.findElement(By.id("answer")).getAttribute("class");
		driver.switchTo().defaultContent();
		return color_of_box1;
	}
	
	private String getColorOfBox2() {
		driver.switchTo().frame("main");
		driver.switchTo().frame("child");
		String color_of_box_2 = driver.findElement(By.id("answer")).getAttribute("class");
		driver.switchTo().defaultContent();
		return color_of_box_2;
	}
	
	private void repaint() {
		driver.switchTo().frame("main");
		driver.findElement(By.linkText("Repaint Box 2")).click();
		driver.switchTo().defaultContent();
	}
	
	private void matchColor() {
		String box1Color = getColorOfBox1();
		String box2Color = getColorOfBox2();
		while(box1Color.equals(box2Color) != true) {
			repaint();
			box2Color = getColorOfBox2();
		}
	}
	private void proceed() {
		driver.switchTo().frame("main");
		driver.findElement(By.linkText("Proceed")).click();
	}
	
	
	public void isclickingWithoutColorMatchingTakesToErrorPage() {
		proceed();
		String expectedUrl = "http://10.0.1.86/tatoc/error";
		assertTrue(expectedUrl.contains(driver.getCurrentUrl()));
		driver.navigate().back();
	}
	
	public void isclickingWithmatchingColorsTakesToDragAndDropBoxPage() {
		matchColor();
		proceed();
		String expectedUrl = "http://10.0.1.86/tatoc/basic/drag";
		assertTrue(expectedUrl.contains(driver.getCurrentUrl()));	
	}
	
	
}
