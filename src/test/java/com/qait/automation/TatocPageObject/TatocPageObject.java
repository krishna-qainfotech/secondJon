//package com.qait.automation.TatocPageObject;
//
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeClass;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class TatocPageObject {
//	WebDriver driver;
//	GridBox gridbox;
//	FrameAndDungeon frame_and_dungeon;
//	DragAndDropActions drag_and_drop;
//	PopupWindowsActions popup_windows;
//	CookieActions cookie;
//
//	@BeforeClass
//	public void openPage() {
//		System.out.println("Uday kumar is a coder");
//		String dir = System.getProperty("user.dir");
//		System.out.println(System.getProperty("user.dir"));
//		String chromedriver= "chromedriver";
//		System.setProperty("webdriver.chrome.driver", dir+"/"+chromedriver);
//		driver = new ChromeDriver();
//		driver.get("http://10.0.1.86/tatoc");
//		driver.findElement(By.linkText("Basic Course")).click();
//		gridbox = new GridBox(driver);
//		frame_and_dungeon = new FrameAndDungeon(driver);
//		drag_and_drop = new DragAndDropActions(driver);
//		popup_windows = new PopupWindowsActions(driver);
//		cookie = new CookieActions(driver);
//	}
//
//	@Test
//	public void step1_GridBoxPage() {
//		gridbox.isclickingRedBoxTakesToErrorPage();
//
//		gridbox.isclickingGreenBoxTakesToFrameAndDungeonPage();
//	}
//
//	@Test(dependsOnMethods = { "step1_GridBoxPage" })
//	public void step2_FrameAndDungeonPage() {
//		frame_and_dungeon.isclickingWithoutColorMatchingTakesToErrorPage();
//
//		frame_and_dungeon.isclickingWithmatchingColorsTakesToDragAndDropBoxPage();
//	}
//
//	@Test(dependsOnMethods = { "step2_FrameAndDungeonPage" })
//	public void Step3_DragAndDropPage() {
//		drag_and_drop.verifyisDragBoxPresent();
//
//		drag_and_drop.verifyisDropBoxPresent();
//
//		drag_and_drop.proceedingWithoutDragAndDropTakesToErrorPage();
//
//		drag_and_drop.proceedingWithDragAndDropTakesToPopupWindowsPage();
//	}
//
//	@Test(dependsOnMethods = { "Step3_DragAndDropPage" })
//	public void Step4_PopupWindowsPage() {
//		popup_windows.proceedingWithoutOpeningNewWindowTakesToErrorPage();
//
//		popup_windows.isLaunchWindowButtonPresent();
//
//		popup_windows.isClickingLaunchOpensNewWinDow();
//
//		popup_windows.proceedWithoutTypingInTextBoxTakesToErrorPage();
//
//		popup_windows.submittingAfterTypingInTextBoxTakesToPopupWindowsPage();
//
//		popup_windows.proceedingCompletingThePopupWindowsTakesToTokenPage();
//	}
//
//	@Test(dependsOnMethods = { "Step4_PopupWindowsPage" })
//	public void Step5_CookieAdding() {
//		cookie.isgenerateTokenButtonIsPresent();
//
//		cookie.proceedingWithoutAddingCookieTakesToErrorPage();
//
//		cookie.proceedingAfterAddingCookieTakesToEndPage();
//		
//		System.out.println("hello world");
//	}
//	
//
//	@AfterTest
//	public void closePage() {
//
//		driver.quit();
//	}
//
//}
