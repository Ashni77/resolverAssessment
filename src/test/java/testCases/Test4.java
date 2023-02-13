package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class Test4 extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateBtnStatus() throws InterruptedException {

		// scroll down to Test 4 div
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)", "");
		Thread.sleep(1000);

		// locate button1 and button2
		WebElement btn1 = driver
				.findElement(By.xpath("//div[@id='test-4-div']//button[@class='btn btn-lg btn-primary']"));
		WebElement btn2 = driver
				.findElement(By.xpath("//div[@id='test-4-div']//button[@class='btn btn-lg btn-secondary']"));
		// check status of btn1 and btn2
		boolean btn1Status = btn1.isEnabled();
		boolean btn2Status = btn2.isEnabled();

		System.out.println("Button 1 status is: " + btn1Status);
		System.out.println("Button 2 status is: " + btn2Status);

		softassert.assertEquals(btn1Status, true); // assert if button1 is enabled
		softassert.assertEquals(btn2Status, false); // assert if button2 is disabled
		softassert.assertAll();

	}

}
