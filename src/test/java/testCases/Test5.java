package testCases;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class Test5 extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateBtnVisibility() throws InterruptedException {

		// scroll down to Test 5 div
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,900)", "");
		Thread.sleep(1000);

		// locate test 5 button and wait until it is visible
		WebElement btn = driver
				.findElement(By.xpath("//div[@id='test-5-div']//button[@class='btn btn-lg btn-primary']"));
		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(btn)); // explicit wait
		btn.click();
		Thread.sleep(1000);

		/*
		 * //get message from alert Alert alert = driver.switchTo().alert(); String
		 * alrtTxt = driver.switchTo().alert().getText(); System.out.println(alrtTxt);
		 */

		// get success message and assert it
		String successMsg = driver.findElement(By.xpath("//div[@id='test5-alert']")).getText();
		System.out.println("Success msg after button being clicked is: " + successMsg);
		
		softassert.assertEquals(successMsg, "You clicked a button!");

		// validate button is disabled
		boolean btnStatus = btn.isEnabled(); // if btn is disabled btnStatus will be false
		System.out.println("The button status is: " + btnStatus);
		softassert.assertEquals(btnStatus, false);

		softassert.assertAll();

	}

}
