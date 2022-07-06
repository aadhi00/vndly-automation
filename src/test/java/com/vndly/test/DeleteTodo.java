package com.vndly.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DeleteTodo {
	
	@Test
	public void deleteTodo() {
		// find browser driver
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\chromedriver.exe");
		
		// initialize browser driver as 'driver'
		WebDriver driver = new ChromeDriver();
		
		// load up the web site to test
		driver.get("https://qa-challenge.beta.vndly.com/");
		
		// select delete button element
		WebElement deleteBtn = driver.findElement(By.xpath("//button[@data-testid='todo-list-item-delete']"));
		
		// automate clicking action to delete
		deleteBtn.click();
		
		// output when the action is performed 
		System.out.println("Delete button clicked");
		
		// initialize expected header message
		String expToastHeader = "SUCCESS";

		// initialize expected body message
		String expToastBody = "Todo \"This todo is meant to be deleted\" removed successfully.";
		
		// find the actual header message
		WebElement actualToastHeader = driver.findElement(By.className("me-auto"));

		// find the actual body message
		WebElement actualToastBody = driver.findElement(By.className("toast-body"));
		
		// initialize soft assert
		SoftAssert softAssert = new SoftAssert();
		
		// check if toast header matches
		softAssert.assertEquals(actualToastHeader, expToastHeader, "Toast header mismatched");
		
		// output when the action is performed 
		System.out.println("Toast header matched");
		
		// check if toast body matches
		softAssert.assertEquals(actualToastBody, expToastBody, "Toast body mismatched");
		
		// output when the action is performed
		System.out.println("Toast body matched");
		
	}

}
