package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class Test1 extends BaseClass {

	@Test
	public void validateSignInElements() throws InterruptedException {

		// locate email,password and signIn input elements
		WebElement emailInp = driver.findElement(By.id("inputEmail"));
		WebElement passwordInp = driver.findElement(By.id("inputPassword"));
		WebElement signInBtn = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));

		// assert if all elements are displayed
		Assert.assertEquals(true, emailInp.isDisplayed());
		Assert.assertEquals(true, passwordInp.isDisplayed());
		Assert.assertEquals(true, signInBtn.isDisplayed());

		// enter data in email and password fields
		emailInp.sendKeys("resolver");
		Thread.sleep(1000);
		passwordInp.sendKeys("test");
		Thread.sleep(1000);

	}

}
