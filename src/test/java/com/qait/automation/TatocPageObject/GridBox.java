package com.qait.automation.TatocPageObject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GridBox {
        WebDriver driver;
        
        public GridBox(WebDriver driver) {
        	this.driver = driver;
        }
          
        private void clickGridBox(String colorOfBox) {
        	if(colorOfBox == "greenbox") {
        		driver.findElement(By.className("greenbox")).click();
        	}
        	else {
        		driver.findElement(By.className("redbox")).click();
        	}
        }
        
        public void isclickingRedBoxTakesToErrorPage() {
        	clickGridBox("redbox");
    		String expectedUrl = "http://10.0.1.86/tatoc/error";
    		assertTrue(expectedUrl.contains(driver.getCurrentUrl()));
       		driver.navigate().back();
        }
        
        public void isclickingGreenBoxTakesToFrameAndDungeonPage() {
        	clickGridBox("greenbox");
    		String expectedUrl = "http://10.0.1.86/tatoc/basic/frame/dungeon";
    		assertTrue(expectedUrl.contains(driver.getCurrentUrl()));
        }

        
        
}
