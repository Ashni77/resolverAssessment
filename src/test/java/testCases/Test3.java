package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class Test3 extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateDrpDwn() throws InterruptedException {

		// scroll down to Test 3 div
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");

		// locate dropdown and validate default text is Option 1
		WebElement drpdwn = driver.findElement(By.id("dropdownMenuButton"));
		String act_dfaultValue = drpdwn.getText();
		String exp_dfaultValue = "Option 1";
		System.out.println("Default selected option is: " + act_dfaultValue);
		softassert.assertEquals(act_dfaultValue, exp_dfaultValue);

		// select option 3 from select list
		drpdwn.click();
		Thread.sleep(1000);
		WebElement opt3 = driver.findElement(By.xpath("//a[text()='Option 3']"));
		opt3.click();
		Thread.sleep(1000);

		softassert.assertAll();
	}

}
