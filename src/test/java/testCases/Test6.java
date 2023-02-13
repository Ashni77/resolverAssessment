package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class Test6 extends BaseClass {

	SoftAssert softassert = new SoftAssert();

	@Test
	public void validateTableValues() throws InterruptedException {

		// scroll down to Test 6 div
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1500)", "");
		Thread.sleep(1000);

		String tableVal = getTableValues(2, 2);
		System.out.println("The cell value at index [2,2] is: " + tableVal);
		softassert.assertEquals(tableVal, "Ventosanzap");
		softassert.assertAll();

	}

	public static String getTableValues(int row, int col) {

		String text = driver
				.findElement(By.xpath("//div[@id=\"test-6-div\"]/div/table/tbody/tr[" + row + "]/td[" + col + "]"))
				.getText();
		return text;

	}

}
