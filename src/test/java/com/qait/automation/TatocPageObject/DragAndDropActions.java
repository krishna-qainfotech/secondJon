package com.qait.automation.TatocPageObject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropActions {
       WebDriver driver;
       
       public DragAndDropActions(WebDriver driver) {
    	   this.driver = driver;
       }
       
       private  WebElement getWebElementToDrop() {
    	   return driver.findElement(By.id("dragbox"));
       }
       
       private WebElement getWebElemntDropBox() {
    	   return driver.findElement(By.id("dropbox"));
       }
       
       public void verifyisDragBoxPresent() {
    	   assertTrue(driver.findElement(By.id("dragbox")).isDisplayed());
       }
       
       public void verifyisDropBoxPresent() {
    	   assertTrue(driver.findElement(By.id("dropbox")).isDisplayed());
       }
       
       public void proceedingWithoutDragAndDropTakesToErrorPage() {
    	driver.findElement(By.linkText("Proceed")).click();
   		String expectedUrl = "http://10.0.1.86/tatoc/error";
   		assertTrue(expectedUrl.contains(driver.getCurrentUrl()));
      	driver.navigate().back();
       }
       
       public void proceedingWithDragAndDropTakesToPopupWindowsPage() {
   		Actions act = new Actions(driver);
   		act.dragAndDrop(getWebElementToDrop(),getWebElemntDropBox()).build().perform();
   		driver.findElement(By.linkText("Proceed")).click();
   		String expectedUrl = "http://10.0.1.86/tatoc/basic/windows";
   		assertTrue(expectedUrl.contains(driver.getCurrentUrl()));
       }
       
       
}
