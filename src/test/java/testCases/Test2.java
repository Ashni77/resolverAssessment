package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class Test2 extends BaseClass {
	
	SoftAssert softassert = new SoftAssert();
	
	@Test
	public void validateListItms() throws InterruptedException {
		
		//locate and get size of list group
		List<WebElement> lstGrp = driver.findElements(By.xpath("//li[@class='list-group-item justify-content-between']"));
		int numOfEle = lstGrp.size();
		System.out.println("Total number of list group elements are: "+numOfEle);
		//assert there are 3 list elements
		softassert.assertEquals(numOfEle, 3);
		
		//get text from list2
		String txt = lstGrp.get(1).getText();
		System.out.println("Second list text value is: "+txt);
		String itemValue = txt.substring(0, 11); //getting list item value
		System.out.println("Second list item value is set to: "+itemValue);
		//assert second list item value
		softassert.assertEquals(itemValue, "List Item 2");
		String badgeValue = txt.substring(12, 13); //getting badge value
		System.out.println("Second list badge value is: "+badgeValue);
		//assert second list badge value
		softassert.assertEquals(badgeValue, "6");
		
		softassert.assertAll();
	}

}
